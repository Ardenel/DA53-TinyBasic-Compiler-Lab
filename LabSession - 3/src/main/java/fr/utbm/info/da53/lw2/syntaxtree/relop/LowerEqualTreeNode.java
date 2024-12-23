package fr.utbm.info.da53.lw2.syntaxtree.relop;

import fr.utbm.info.da53.lw2.syntaxtree.abstractclasses.AbstractComparisonOperatorTreeNode;
import fr.utbm.info.da53.lw2.threeaddresscode.ThreeAddressCode;
import fr.utbm.info.da53.lw2.threeaddresscode.ThreeAddressInstruction;
import fr.utbm.info.da53.lw2.threeaddresscode.ThreeAddressRecord;

/**
 * Represents a "lower equal" comparison operation in the syntax tree.
 *
 * This node evaluates its left and right operands and returns a boolean result
 * indicating whether the left operand is lower or equal than the right operand.
 *
 * @author Arthur
 */
public class LowerEqualTreeNode extends AbstractComparisonOperatorTreeNode {

    /**
     * Default constructor for creating an empty "lower equal" comparison node.
     * Operands should be set later using {@link #setOperands}.
     */
    public LowerEqualTreeNode() {

    }

    /**
     * Translates the comparison result into a boolean indicating "greater than".
     *
     * @param comparisonResult the result of comparing the left and right operands:
     *                         - Negative value indicates less than.
     *                         - Zero indicates equality.
     *                         - Positive value indicates greater than.
     * @return {@code true} if the left operand is strictly greater than the right operand,
     *         {@code false} otherwise.
     */
    @Override
    protected boolean translate(int comparisonResult) {
        return comparisonResult <= 0;
    }

    @Override
    public String generate(ThreeAddressCode code) {
        // Generate code for the left operand and get the resulting temporary variable
        String leftResult = getLeftOperand().generate(code);

        // Generate code for the right operand and get the resulting temporary variable
        String rightResult = getRightOperand().generate(code);

        // Create a temporary variable for the result of the equality comparison
        String result = code.createTempVariable();

        // Add an LE instruction to the three-address code
        code.addRecord(new ThreeAddressRecord(
                ThreeAddressInstruction.LE, // Lower or equal comparison
                leftResult,                 // Left operand
                rightResult,                // Right operand
                result,                     // Result variable
                null,                       // No label
                "Compare " + leftResult + " <= " + rightResult
        ));

        // Return the result variable
        return result;
    }


    /**
     * Returns the operator string for "lower equal" ("<").
     *
     * @return the string representing the "greater than" operator.
     */
    @Override
    public String getOperatorString() {
        return "<=";
    }

    /**
     * Returns a string representation of this node, including its operands and operator.
     *
     * @return a string representation of the equality comparison tree node.
     */
    @Override
    public String toString() {
        return "LowerEqualTreeNode{" +
                "leftOperand=" + getLeftOperand() +
                ", rightOperand=" + getRightOperand() +
                '}';
    }
}
