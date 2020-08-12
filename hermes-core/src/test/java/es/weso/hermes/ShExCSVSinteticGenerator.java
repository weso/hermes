package es.weso.hermes;

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

public class ShExCSVSinteticGenerator {

    @Test
    public void generate() throws IOException {
        String shapeLabel = "shapePrefix:shape";
        String constraintLabel = "constraintPrefix:constraint";
        String constraint = "xsd:string";
        int min = 1;
        int max = 3;

        FileWriter writer = new FileWriter("synthetic_shapes.csv");
        for(int i = 0; i < 1000000000; i++) {
            writer.write(shapeLabel+i + "," + constraintLabel+i + "," + constraint + "," + min + "," + max + "\n");
        }
        writer.close();
    }
}
