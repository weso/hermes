package es.weso.hermes.index;

import es.weso.hermes.slice.HermesSlice;
import java.util.*;

public final class HermesIndex implements IndexOperations<String> {

    private final Map<String, Collection<HermesSlice>> index = new HashMap<>();

    /**
     * Indexes an slice.
     *
     * @param slice to index.
     */
    public void index(HermesSlice slice) {
        if(index.containsKey(slice.getShapeLabel())) {
            index.get(slice.getShapeLabel()).add(slice);
        } else {
            List<HermesSlice> aux = new ArrayList<>();
            index.put(slice.getShapeLabel(), aux);
        }
    }

    /**
     * Gets the entries slices indexed at a given key.
     *
     * @param key to look for the slices.
     *
     * @return a collection containing the slices indexed at the given key.
     */
    public Collection<HermesSlice> getSlicesForKey(String key) {
        return this.index.get(key);
    }

    /**
     * Gets all the elements of the index.
     *
     * @return  all the elements of the index.
     */
    public Map<String, Collection<HermesSlice>> getIndex() {
        return this.index;
    }
}
