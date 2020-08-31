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

    @Override
    public String translate(String prefixesCSVFile, String shapesCSVFile) throws TranslationException, IOException {
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

        String line = "";
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




        return output.toString();
    }
}
