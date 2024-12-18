package fr.utbm.info.da53.lw2.syntaxtree.operator;

import fr.utbm.info.da53.lw2.context.ExecutionContext;
import fr.utbm.info.da53.lw2.error.InterpreterErrorType;
import fr.utbm.info.da53.lw2.error.InterpreterException;
import fr.utbm.info.da53.lw2.syntaxtree.abstractclasses.AbstractBinaryOperatorTreeNode;
import fr.utbm.info.da53.lw2.syntaxtree.abstractclasses.AbstractValueTreeNode;
import fr.utbm.info.da53.lw2.type.Value;
import fr.utbm.info.da53.lw2.type.VariableType;

/**
 * Represents a binary subtraction operation in the syntax tree.
 *
 * The right operand is subtracted from the left operand.
 *
 * @author Arthur
 */
public class SubtractionTreeNode extends AbstractBinaryOperatorTreeNode {

    /**
     * Constructs a subtraction tree node with the specified operands.
     *
     * @param leftOperand  the left operand of the subtraction.
     * @param rightOperand the right operand of the subtraction.
     */
    public SubtractionTreeNode(AbstractValueTreeNode leftOperand, AbstractValueTreeNode rightOperand) {
        super(leftOperand, rightOperand);
    }

    /**
     * Default constructor for creating an empty subtraction tree node.
     * Operands should be set later using {@link #setOperands}.
     */
    public SubtractionTreeNode() {
        super();
    }

    /**
     * Computes the result of subtracting the right operand from the left operand.
     *
     * @param context the current execution context.
     * @param left  the evaluated value of the left operand.
     * @param right the evaluated value of the right operand.
     * @return the result of the subtraction.
     * @throws InterpreterException if the operand types are incompatible.
     */
    @Override
    protected Value compute(ExecutionContext context, Value left, Value right) throws InterpreterException {
        if (left.getType() != VariableType.NUMBER || right.getType() != VariableType.NUMBER) {
            fail(context, InterpreterErrorType.EXPECTING_NUMBER,
                    "Subtraction operands (" + getOperatorString() + ") must be numbers: " + left + ", " + right);
        }

        Number result = left.getValue(Number.class).doubleValue() - right.getValue(Number.class).doubleValue();
        return new Value(result);
    }

    /**
     * Returns the operator string for subtraction ("-").
     *
     * @return the string representing the subtraction operator.
     */
    @Override
    public String getOperatorString() {
        return "-";
    }

    @Override
    public String toString(){
        return "SubtractionTreeNode(" + getLeftOperand() + " - " + getRightOperand() + ")";
    }
}
