package es.weso.hermes;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Hermes {

    private HermesStorageGateway hsg;
    private final Map<String, String> stats = new HashMap<>();

    public Hermes() {
        // Init the statistics.
        initStats();
    }

    public boolean loadPrefixesFromCSV(Reader reader, String separator) throws IOException {
        BufferedReader br = new BufferedReader(reader);
        String line = "";
        while((line = br.readLine()) != null) {
            String[] cells = line.split(separator);
            hsg.storePrefix(cells[0], cells[1]);
        }
        return true;
    }

    boolean loadShapesFromCSV(Reader reader, String separator) throws IOException {
        BufferedReader br = new BufferedReader(reader);
        String line = "";
        while((line = br.readLine()) != null) {
            String[] cells = line.split(separator);
            hsg.storePrefix(cells[0], cells[1]);
        }
        return true;
    }

    String toShExCString();

    Map<String, String> getStats();

    void clear();

    private void initStats() {
        this.stats.put("n_prefixes", "0");
        this.stats.put("n_shapes", "0");
        this.stats.put("n_constraints", "0");
        this.stats.put("mean_constraints_per_shape", "0.000");
    }
}
