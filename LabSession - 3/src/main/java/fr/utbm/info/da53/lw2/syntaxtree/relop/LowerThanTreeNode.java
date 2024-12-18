package fr.utbm.info.da53.lw2.syntaxtree.relop;

import fr.utbm.info.da53.lw2.syntaxtree.abstractclasses.AbstractComparisonOperatorTreeNode;

/**
 * Represents a "lower than" comparison operation in the syntax tree.
 *
 * This node evaluates its left and right operands and returns a boolean result
 * indicating whether the left operand is strictly lower the right operand.
 *
 * @author Arthur
 */
public class LowerThanTreeNode extends AbstractComparisonOperatorTreeNode {

    /** Default constructor for creating an empty "lower than" comparison node.
     * Operands should be set later using {@link #setOperands}.
     */
    public LowerThanTreeNode() {
    }

    /**
     * Translates the comparison result into a boolean indicating "lower than".
     *
     * @param comparisonResult the result of comparing the left and right operands:
     *                         - Negative value indicates less than.
     *                         - Zero indicates equality.
     *                         - Positive value indicates greater than.
     * @return {@code true} if the left operand is strictly lower than the right operand,
     *         {@code false} otherwise.
     */
    @Override
    protected boolean translate(int comparisonResult) {
        return comparisonResult < 0;
    }

    /**
     * Returns the operator string for "lower than" ("<").
     *
     * @return the string representing the "lower than" operator.
     */
    @Override
    public String getOperatorString() {
        return "<";
    }

    /**
     * Returns a string representation of this node, including its operands and operator.
     *
     * @return a string representation of the equality comparison tree node.
     */
    @Override
    public String toString() {
        return "LowerThanTreeNode{" +
                "leftOperand=" + getLeftOperand() +
                ", rightOperand=" + getRightOperand() +
                '}';
    }
}
