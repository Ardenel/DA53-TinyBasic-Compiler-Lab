package fr.utbm.info.da53.lw2.syntaxtree.relop;

import fr.utbm.info.da53.lw2.syntaxtree.abstractclasses.AbstractComparisonOperatorTreeNode;
import fr.utbm.info.da53.lw2.threeaddresscode.ThreeAddressCode;
import fr.utbm.info.da53.lw2.threeaddresscode.ThreeAddressInstruction;
import fr.utbm.info.da53.lw2.threeaddresscode.ThreeAddressRecord;

/**
 * Represents an equality comparison operation in the syntax tree.
 *
 * This node evaluates its left and right operands and returns a boolean result
 * indicating whether the operands are equal.
 *
 * Operands of different types are considered unequal.
 *
 * @author Arthur
 */
public class EqualTreeNode extends AbstractComparisonOperatorTreeNode {

    /**
     * Default constructor for creating an empty equality comparison node.
     * Operands should be set later using {@link #setOperands}.
     */
    public EqualTreeNode() {
        super();
    }

    /**
     * Translates the comparison result into a boolean indicating equality.
     *
     * @param comparisonResult the result of comparing the left and right operands:
     *                         - Zero indicates equality.
     *                         - Non-zero indicates inequality.
     * @return {@code true} if the operands are equal, {@code false} otherwise.
     */
    @Override
    protected boolean translate(int comparisonResult) {
        return comparisonResult == 0;
    }

    @Override
    public String generate(ThreeAddressCode code) {
        // Generate code for the left operand and get the resulting temporary variable
        String leftResult = getLeftOperand().generate(code);

        // Generate code for the right operand and get the resulting temporary variable
        String rightResult = getRightOperand().generate(code);

        // Create a temporary variable for the result of the equality comparison
        String result = code.createTempVariable();

        // Add an EQ instruction to the three-address code
        code.addRecord(new ThreeAddressRecord(
                ThreeAddressInstruction.EQ, // Equality comparison
                leftResult,                 // Left operand
                rightResult,                // Right operand
                result,                     // Result variable
                null,                       // No label
                "Compare " + leftResult + " == " + rightResult
        ));

        // Return the result variable
        return result;
    }


    /**
     * Returns the operator string for equality ("==").
     *
     * @return the string representing the equality operator.
     */
    @Override
    public String getOperatorString() {
        return "==";
    }

    /**
     * Returns a string representation of this node, including its operands and operator.
     *
     * @return a string representation of the equality comparison tree node.
     */
    @Override
    public String toString() {
        return "(" + getLeftOperand().toString() + " == " + getRightOperand().toString() + ")";
    }
}
