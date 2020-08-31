package es.weso.hermes;

import java.io.IOException;

/**
 * Hermes translator is a Java based library that allows to translate from Shape Expressions tabular formats like
 * ShExCSV to the Shape Expressions Compact Syntax. This interface is the main entrypoint for specific implementations.
 *
 * @version 1.0.0
 * @since 1.0.0
 * @author Guillermo Facundo Colunga
 */
public interface HermesTranslator {

    /**
     * Translates from ShExCSV format to ShExC format. the input files are the prefixes CSV file and the shapes CSV file,
     * both following the formats defined at <a href="https://github.com/weso/hermes">GitHub repo README</a>. If the
     * input files do not follow this specification the method will raise an exception indicating the element of the
     * file that do not follow the expected syntax. Otherwise will return a formatted string containing the ShExC
     * representation of the input Shape Expressions.
     *
     * @param prefixesCSVFile is the CSV file where all the prefixes are defined. This prefixes are the ones that are
     *                        referenced from the Shape Expressions CSV file. This file should be formatted as:
     *                        <code>Prefix,URI</code>.
     * @param shapesCSVFile is the CSV file that contains all the shape expressions. This file should be formatted as:
     *                      <code>Shape Label,Constraint Property,Constraint,Min,Max</code>, where no field should be
     *                      empty. If any doubt, please refer to <a href="https://github.com/weso/hermes">GitHub repo README</a>.
     * @return an formatted string containing the ShExC representation of the input Shape Expressions if there is no error
     * during the translation. Otherwise an empty string.
     * @throws TranslationException if any error occurs during the translation.
     * @throws IOException id any error occurs while loading the files.
     */
    String translate(String prefixesCSVFile, String shapesCSVFile) throws TranslationException, IOException;
}
