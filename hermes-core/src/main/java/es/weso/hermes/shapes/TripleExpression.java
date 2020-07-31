package es.weso.hermes.shapes;

public class TripleExpression {

    private final String label;
    private final String constraint;
    private final String min;
    private final String max;

    public TripleExpression(String label, String constraint, String min, String max) {
        this.label = label;
        this.constraint = constraint;
        this.min = min;
        this.max = max;
    }

    @Override
    public String toString() {
        return label + " " + constraint + " {" + min + "," + max + "} ;";
    }
}
