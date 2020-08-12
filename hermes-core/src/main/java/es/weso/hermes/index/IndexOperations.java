package es.weso.hermes.index;

import es.weso.hermes.slice.HermesSlice;

import java.util.Collection;
import java.util.Map;

public interface IndexOperations<T> {

    /**
     * Indexes an slice.
     *
     * @param slice to index.
     */
    void index(HermesSlice slice);

    /**
     * Gets the entries slices indexed at a given key.
     *
     * @param key to look for the slices.
     *
     * @return a collection containing the slices indexed at the given key.
     */
    Collection<HermesSlice> getSlicesForKey(T key);

    /**
     * Gets all the elements of the index.
     *
     * @return  all the elements of the index.
     */
    Map<T, Collection<HermesSlice>> getIndex();
}
