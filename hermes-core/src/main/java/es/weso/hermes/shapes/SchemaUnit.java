package es.weso.hermes.shapes;

import java.util.LinkedList;
import java.util.List;

public class SchemaUnit {

    private List<Prefix> prefixes = new LinkedList<>();
    private List<ShapeExpression> shapes = new LinkedList<>();

    public List<ShapeExpression> getShapes() {
        return shapes;
    }

    public void setShapes(List<ShapeExpression> shapes) {
        this.shapes = shapes;
    }

    public List<Prefix> getPrefixes() {
        return prefixes;
    }

    public void setPrefixes(List<Prefix> prefixes) {
        this.prefixes = prefixes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Prefix prefix: prefixes) {
            sb.append(prefix.toString() + "\n");
        }

        sb.append("\n");

        for(ShapeExpression shape: shapes) {
            sb.append(shape.toString() + "\n");
        }

        return sb.toString();
    }
}
