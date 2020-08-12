package es.weso.hermes.slice;

public interface SliceOperations {

    /**
     * Gets the value of the shape label. A Shape label is the prefix plus the label itself.
     *
     * @return an string containing the shape label.
     */
    String getShapeLabel();

    /**
     * Gets the constraint label. A constraint label is the prefix plus the label itself.
     *
     * @return an string containing the prefix and the label itself.
     */
    String getConstraintLabel();

    /**
     * Gets the constraint as plain text.
     *
     * @return an string containing the constraint in plain text.
     */
    String getConstraint();

    /**
     * Gets the cardinality minimum number of times.
     *
     * @return an integer indicating the minimum number of times of the cardinality.
     */
    int getMin();

    /**
     * Gets the cardinality maximum number of times.
     *
     * @return an integer indicating the maximum number of times of the cardinality.
     */
    int getMax();
}
