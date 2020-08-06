package es.weso.hermes.model;

import es.weso.hermes.shapes.TripleExpression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShapesTable {

    private final Map<String, List<TripleExpression>> map = new HashMap<>();
    private final Logger logger = LoggerFactory.getLogger(ShapesTable.class);

    public void put(String shapeURI, TripleExpression expression) {
        if(map.containsKey(shapeURI)) {
            List<TripleExpression> aux = new ArrayList<>();
            aux.add(expression);
            map.put(shapeURI, aux);
        } else {
            map.get(shapeURI).add(expression);
        }
    }

}
