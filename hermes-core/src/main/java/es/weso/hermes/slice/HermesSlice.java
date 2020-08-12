package es.weso.hermes.slice;

import java.io.Serializable;

/**
 * An Hermes slice is the conjunction of the Shape Label or Shape Name and a Triple Constraint.
 *
 * @author Guillermo Facundo Colunga
 * @since 0.1.0
 */
public class HermesSlice implements Serializable, SliceOperations {

    public String shapeLabel;
    public String constraintLabel;
    public String constraint;
    public int min = Integer.MIN_VALUE;
    public int max = Integer.MAX_VALUE;

    /**
     * Main constructor for the Shape Constraint entry. Each entry must have all the values with exception of the
     * minimum and the maximum.
     *
     * @param shapeLabel
     * @param constraintLabel
     * @param constraint
     */
    public HermesSlice(String shapeLabel, String constraintLabel, String constraint) {
        this(shapeLabel, constraintLabel, constraint, Integer.MIN_VALUE);
    }

    /**
     * Main constructor for the Shape Constraint entry. Each entry must have all the values with exception of the
     * minimum and the maximum.
     *
     * @param shapeLabel
     * @param constraintLabel
     * @param constraint
     * @param min
     */
    public HermesSlice(String shapeLabel, String constraintLabel, String constraint, int min) {
        this(shapeLabel, constraintLabel, constraint, min, Integer.MAX_VALUE);
    }

    /**
     * Main constructor for the Shape Constraint entry. Each entry must have all the values with exception of the
     * minimum and the maximum.
     *
     * @param shapeLabel
     * @param constraintLabel
     * @param constraint
     * @param min
     * @param max
     */
    public HermesSlice(String shapeLabel, String constraintLabel, String constraint, int min, int max) {
        this.shapeLabel = shapeLabel;
        this.constraintLabel = constraintLabel;
        this.constraint = constraint;
        this.min = min;
        this.max = max;
    }

    /**
     * Gets the value of the shape label. A Shape label is the prefix plus the label itself.
     *
     * @return an string containing the shape label.
     */
    public String getShapeLabel() {
        return shapeLabel;
    }

    /**
     * Gets the constraint label. A constraint label is the prefix plus the label itself.
     *
     * @return an string containing the prefix and the label itself.
     */
    public String getConstraintLabel() {
        return constraintLabel;
    }

    /**
     * Gets the constraint as plain text.
     *
     * @return an string containing the constraint in plain text.
     */
    public String getConstraint() {
        return constraint;
    }

    /**
     * Gets the cardinality minimum number of times.
     *
     * @return an integer indicating the minimum number of times of the cardinality.
     */
    public int getMin() {
        return min;
    }

    /**
     * Gets the cardinality maximum number of times.
     *
     * @return an integer indicating the maximum number of times of the cardinality.
     */
    public int getMax() {
        return max;
    }

     @Override
    public String toString() {
        return this.shapeLabel + " " + this.constraintLabel + " " + this.constraint + " " + this.min + " " +this.max;
    }
}
