package es.weso.hermes.shapes;

public class Prefix {

    private final String label;
    private final String uri;

    public Prefix(String label, String uri) {
        this.label = label;
        this.uri = uri;
    }

    @Override
    public String toString() {
        return "prefix " + this.label + ":" + this.uri;
    }
}
