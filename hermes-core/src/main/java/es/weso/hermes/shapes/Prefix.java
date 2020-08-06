package es.weso.hermes.shapes;

/**
 * A prefix is the conjunction of a label and an uri.
 *
 * @author Guillermo Facundo Colunga
 * @since 0.1.0
 */
public class Prefix {

    private final String label;
    private final String uri;

    /**
     * Prefix main constructor. The label is the label that will take the prefix and the uri is the address that will
     * be pointed by the label.
     *
     * @param label of the prefix.
     * @param uri of the prefix.
     */
    public Prefix(String label, String uri) {
        this.label = label;
        this.uri = uri;
    }

    /**
     * Gets the label
     *
     * @return
     */
    public String getLabel() {
        return this.label;
    }


    @Override
    public String toString() {
        return "prefix " + this.label + ":" + this.uri;
    }
}
