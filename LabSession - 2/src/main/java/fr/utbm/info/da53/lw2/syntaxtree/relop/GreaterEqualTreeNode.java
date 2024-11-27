package fr.utbm.info.da53.lw2.syntaxtree.relop;

import fr.utbm.info.da53.lw2.syntaxtree.abstractclasses.AbstractComparisonOperatorTreeNode;

/**
 * Represents a "greater than or equal to" comparison operation in the syntax tree.
 *
 * This node evaluates its left and right operands and returns a boolean result
 * indicating whether the left operand is greater or equal to the right operand.
 *
 * @author Arthur
 */
public class GreaterEqualTreeNode extends AbstractComparisonOperatorTreeNode {

    /**
     * Default constructor for creating an empty "greater than or equal to" comparison node.
     * Operands should be set later using {@link #setOperands}.
     */
    public GreaterEqualTreeNode() {
        super();
    }

    /**
     * Translates the comparison result into a boolean indicating "greater than or equal to".
     *
     * @param comparisonResult the result of comparing the left and right operands:
     *                         - Negative value indicates less than.
     *                         - Zero indicates equality.
     *                         - Positive value indicates greater than.
     * @return {@code true} if the left operand is greater than or equal to the right operand,
     *         {@code false} otherwise.
     */
    @Override
    protected boolean translate(int comparisonResult) {
        return comparisonResult >= 0;
    }

    /**
     * Returns the operator string for "greater than or equal to" (">=").
     *
     * @return the string representing the "greater than or equal to" operator.
     */
    @Override
    public String getOperatorString() {
        return ">=";
    }

    /**
     * Returns a string representation of this node, including its operands and operator.
     *
     * @return a string representation of the equality comparison tree node.
     */
    @Override
    public String toString() {
        return "GreaterEqualTreeNode{" +
                "leftOperand=" + getLeftOperand() +
                ", rightOperand=" + getRightOperand() +
                '}';
    }

}

