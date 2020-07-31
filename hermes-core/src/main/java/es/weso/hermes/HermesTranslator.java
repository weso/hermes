package es.weso.hermes;

import es.weso.hermes.shapes.Prefix;
import es.weso.hermes.shapes.SchemaUnit;
import es.weso.hermes.shapes.ShapeExpression;
import es.weso.hermes.shapes.TripleExpression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Public interface of the hermes system. Allows access to basic functionality methods. Among them are those of
 * creating an instance of the translator. The one to add prefixes for the translation. The one to add shapes
 * to the translation. And the one to translate everything previously introduced.
 *
 * @author Guillermo Facundo Colunga
 * @since 0.1.0
 */
public class HermesTranslator {

    // Loggers
    private final Logger log = LoggerFactory.getLogger(HermesTranslator.class);

    private final List<String> prefixesFiles = new LinkedList<>();
    private final List<String> shapesFiles = new LinkedList<>();

    private final HermesTranslatorConfig config;

    // Private constructor to enforce factory method.
    private HermesTranslator(HermesTranslatorConfig config) {
        this.config = config;
    }

    /**
     *
     * @return
     */
    public static HermesTranslator fromDefaultConfig() {
        return new HermesTranslator(HermesTranslatorConfig.empty());
    }

    /**
     *
     * @return
     */
    public static HermesTranslator fromConfig(HermesTranslatorConfig config) {
        return new HermesTranslator(config);
    }

    public String translate(List<String> prefixesFilePaths, List<String> shapesFilePaths) throws IOException {
        // Checks
        if(Objects.isNull(prefixesFilePaths) || prefixesFilePaths.size() < 1) {
            log.error("the list of files for the prefixes is null or empty.");
            throw new IllegalArgumentException("The list containing the prefixes file paths cannot be null. It must have at least one element.");
        } else if(Objects.isNull(shapesFilePaths) || shapesFilePaths.size() < 1) {
            log.error("the list of files for the shapes is null or empty.");
            throw new IllegalArgumentException("The list containing the shapes file paths cannot be null. It must have at least one element.");
        }

        // Create a new Schema.
        SchemaUnit schema = new SchemaUnit();

        // Create prefixes
        for(String prefixFilePath: prefixesFilePaths) {
            BufferedReader br = new BufferedReader(new FileReader(prefixFilePath));
            String line;
            Prefix prefix = null;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                prefix = new Prefix(values[0], values[1]);
                schema.getPrefixes().add(prefix);
            }
            schema.getPrefixes().add(prefix);
        }

        // Create Shapes
        for(String shapeFilePath: shapesFilePaths) {
            BufferedReader br = new BufferedReader(new FileReader(shapeFilePath));
            String line;
            TripleExpression tripleExpression;
            ShapeExpression shape = new ShapeExpression(shapeFilePath + ".shex");
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                System.out.println(values.length);
                if(values.length==4)
                    tripleExpression = new TripleExpression(values[0], values[1], values[2], values[3]);
                else
                    tripleExpression = new TripleExpression(values[0], values[1], values[2], "*");
                shape.getExpressions().add(tripleExpression);
            }
            schema.getShapes().add(shape);
        }

        // Return the toString representation of the schema.
        return schema.toString();
    }
}
