package es.weso.hermes.shapes;

import java.util.ArrayList;
import java.util.List;

public class ShapeExpression {

    private final String name;
    private List<TripleExpression> expressions = new ArrayList<>();

    public ShapeExpression(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<TripleExpression> getExpressions() {
        return expressions;
    }

    public void setExpressions(List<TripleExpression> expressions) {
        this.expressions = expressions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + " {\n");
        for(TripleExpression triple : expressions) {
            sb.append("  " + triple.toString() + "\n");
        }
        sb.append("}\n");

        return sb.toString();
    }
}
