package es.weso.hermes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

/**
 * The ToShExCHermesTranslator is the specific implementation of {@link HermesTranslator} interface to translate from
 * CSV to ShExC.
 *
 * @version 1.0.0
 * @since 1.0.0
 * @author Guillermo Facundo Colunga
 */
public class ToShExCHermesTranslator implements HermesTranslator {

    // Static fields.
    public static final String CSV_SEPARATOR_CHAR = ",";
    public static final String PREFIX_FORMAT_STRING = "PREFIX %s:%s;\n";
    public static final String SHAPE_DECL_FORMAT_STRING = "%s {\n";
    public static final String TRIPLE_EXPR_FORMAT_STRING = "\t%s %s {%s,%s};\n";
    public static final String SHAPE_DECL_CLOSING_CHAR = "}\n";

    @Override
    public String translate(final String prefixesCSVFile, final String shapesCSVFile) throws TranslationException, IOException {
        // 1. Sanity checks.
        if(Objects.isNull(prefixesCSVFile)) {
            throw new IllegalArgumentException("The prefixes CSV file cannot be null");
        } else if(Objects.isNull(shapesCSVFile)) {
            throw new IllegalArgumentException("The shapes CSV file cannot be null");
        }

        // 2. Load the CSV files. If any error will throw a java.io exception.
        File prefixesFile = new File(prefixesCSVFile);
        File shapesFile = new File(shapesCSVFile);

        // 3. Process the files. First the prefixes one and then the shapes one.
        final StringBuilder output = new StringBuilder(); // Final variable to store the result.
        FileReader fr = new FileReader(prefixesFile);
        BufferedReader br = new BufferedReader(fr);

        // Auxiliary variable to store each line of the files. This variable will be reuse for the second file.
        String line = "";

        // Processing ther prefixes file.
        try {
            while((line = br.readLine()) != null) {
                String[] cells = line.split(CSV_SEPARATOR_CHAR);
                output.append(String.format(PREFIX_FORMAT_STRING, cells[0], cells[1])); // We insert the string 'PREFIX label:uri;'
            }
        } catch (Exception e) {
            throw new TranslationException(
                    String.format("The prefixes file does not follow the format defined for ShExCSV. Nested Exception: %s",
                            e.getMessage())
            );
        }

        // Processing the shapes file
        fr = new FileReader(shapesFile);
        br = new BufferedReader(fr);
        try {
            String lastShape = ""; // Current shape
            while((line = br.readLine()) != null) {
                String[] cells = line.split(CSV_SEPARATOR_CHAR);

                // Parsed shape parts.
                String shapeLabel = cells[0];
                String propertyLabel = cells[1];
                String constraint = cells[2];
                String min = cells[3];
                String max = cells[4];

                // If the current shape label is equals to the previous one we are still processing it.
                if(!shapeLabel.equals(lastShape)) {
                    if(!lastShape.isEmpty()) {
                        output.append(SHAPE_DECL_CLOSING_CHAR);
                    }
                    output.append(String.format(SHAPE_DECL_FORMAT_STRING, shapeLabel)); // A new Shape Expression decl. has been found.
                }
                lastShape = shapeLabel;
                output.append(String.format(TRIPLE_EXPR_FORMAT_STRING, propertyLabel, constraint, min, max));
            }
            output.append(SHAPE_DECL_CLOSING_CHAR);
        } catch (Exception e) {
            throw new TranslationException(
                    String.format("The shapes file does not follow the format defined for ShExCSV. Nested Exception: %s",
                            e.getMessage())
            );
        }

        return output.toString();
    }
}
