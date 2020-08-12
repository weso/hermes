package es.weso.hermes.table;

import es.weso.hermes.index.HermesIndex;
import es.weso.hermes.index.IndexOperations;
import es.weso.hermes.slice.HermesSlice;
import es.weso.hermes.slice.SliceOperations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Stream;

public class ShapesTable {
    private final Collection<SliceOperations> shapes = new ArrayList<>();
    private final IndexOperations index = new HermesIndex();

    public void addEntry(HermesSlice entry) {
        index.index(entry);
        this.shapes.add(entry);
    }

    public Stream<SliceOperations> stream() {
        return this.shapes.stream();
    }

    public Map<String, Collection<HermesSlice>> getShapesGroupedByShapeLabel() {
        return index.getIndex();
    }
}
