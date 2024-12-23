package fr.utbm.info.da53.lw2.syntaxtree.operator;

import fr.utbm.info.da53.lw2.context.ExecutionContext;
import fr.utbm.info.da53.lw2.error.InterpreterErrorType;
import fr.utbm.info.da53.lw2.error.InterpreterException;
import fr.utbm.info.da53.lw2.syntaxtree.abstractclasses.AbstractBinaryOperatorTreeNode;
import fr.utbm.info.da53.lw2.syntaxtree.abstractclasses.AbstractValueTreeNode;
import fr.utbm.info.da53.lw2.threeaddresscode.ThreeAddressCode;
import fr.utbm.info.da53.lw2.threeaddresscode.ThreeAddressInstruction;
import fr.utbm.info.da53.lw2.threeaddresscode.ThreeAddressRecord;
import fr.utbm.info.da53.lw2.type.Value;
import fr.utbm.info.da53.lw2.type.VariableType;

/**
 * Represents a binary division operation in the syntax tree.
 *
 * The left operand is divided by the right operand. Division by zero
 * is handled by throwing an exception.
 *
 * @author Arthur
 */
public class DivideTreeNode extends AbstractBinaryOperatorTreeNode {

    /**
     * Constructs a division tree node with the specified operands.
     *
     * @param leftOperand  the left operand of the division.
     * @param rightOperand the right operand of the division.
     */
    public DivideTreeNode(AbstractValueTreeNode leftOperand, AbstractValueTreeNode rightOperand) {
        super(leftOperand, rightOperand);
    }

    /**
     * Default constructor for creating an empty division tree node.
     * Operands should be set later using {@link #setOperands}.
     */
    public DivideTreeNode() {
        super();
    }

    /**
     * Computes the result of dividing the left operand by the right operand.
     *
     * @param context the current execution context.
     * @param left  the evaluated value of the left operand.
     * @param right the evaluated value of the right operand.
     * @return the result of the division.
     * @throws InterpreterException if the right operand is zero or if the operand types are incompatible.
     */
    @Override
    protected Value compute(ExecutionContext context, Value left, Value right) throws InterpreterException {
        if (left.getType() != VariableType.NUMBER || right.getType() != VariableType.NUMBER) {
            fail(context, InterpreterErrorType.EXPECTING_NUMBER,
                    "Division operands (" + getOperatorString() + ") must be numbers: " + left + ", " + right);
        }

        Number rightValue = right.getValue(Number.class);
        if (rightValue.doubleValue() == 0) {
            fail(context, InterpreterErrorType.DIVISION_BY_ZERO, "Division by zero is not allowed.");
        }

        Number result = left.getValue(Number.class).doubleValue() / rightValue.doubleValue();
        return new Value(result);
    }

    @Override
    public String generate(ThreeAddressCode code) {
        // Generate code for the left operand and get the resulting temporary variable
        String leftResult = getLeftOperand().generate(code);

        // Generate code for the right operand and get the resulting temporary variable
        String rightResult = getRightOperand().generate(code);

        // Create a temporary variable for the result of the addition
        String result = code.createTempVariable();

        // Add an DIVISION instruction to the three-address code
        code.addRecord(new ThreeAddressRecord(
                ThreeAddressInstruction.DIVISION,
                leftResult,   // Left operand
                rightResult,  // Right operand
                result,       // Result variable
                null,         // No label
                "Compute the division of " + leftResult + " and " + rightResult
        ));

        // Return the result variable
        return result;
    }


    /**
     * Returns the operator string for division ("/").
     *
     * @return the string representing the division operator.
     */
    @Override
    public String getOperatorString() {
        return "/";
    }

    @Override
    public String toString() {
        return "DivideTreeNode(" + getLeftOperand() + " / " + getRightOperand() + ")";
    }
}
