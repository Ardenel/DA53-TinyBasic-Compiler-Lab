package fr.utbm.info.da53.lw2.syntaxtree.operator;

import fr.utbm.info.da53.lw2.context.ExecutionContext;
import fr.utbm.info.da53.lw2.error.InterpreterErrorType;
import fr.utbm.info.da53.lw2.error.InterpreterException;
import fr.utbm.info.da53.lw2.syntaxtree.abstractclasses.AbstractBinaryOperatorTreeNode;
import fr.utbm.info.da53.lw2.syntaxtree.abstractclasses.AbstractValueTreeNode;
import fr.utbm.info.da53.lw2.type.Value;
import fr.utbm.info.da53.lw2.type.VariableType;

/**
 * Represents a binary multiplication operation in the syntax tree.
 *
 * The left and right operands are multiplied together.
 *
 * @author Arthur
 */
public class MultiplyTreeNode extends AbstractBinaryOperatorTreeNode {

    /**
     * Constructs a multiplication tree node with the specified operands.
     *
     * @param leftOperand  the left operand of the multiplication.
     * @param rightOperand the right operand of the multiplication.
     */
    public MultiplyTreeNode(AbstractValueTreeNode leftOperand, AbstractValueTreeNode rightOperand) {
        super(leftOperand, rightOperand);
    }

    /**
     * Default constructor for creating an empty multiplication tree node.
     * Operands should be set later using {@link #setOperands}.
     */
    public MultiplyTreeNode() {
        super();
    }

    /**
     * Computes the result of multiplying the left and right operand values.
     *
     * @param context the current execution context.
     * @param left  the evaluated value of the left operand.
     * @param right the evaluated value of the right operand.
     * @return the result of the multiplication.
     * @throws InterpreterException if the operand types are incompatible.
     */
    @Override
    protected Value compute(ExecutionContext context, Value left, Value right) throws InterpreterException {
        if (left.getType() != VariableType.NUMBER || right.getType() != VariableType.NUMBER) {
            fail(context, InterpreterErrorType.EXPECTING_NUMBER,
                    "Multiplication operands (" + getOperatorString() + ") must be numbers: " + left + ", " + right);
        }

        Number result = left.getValue(Number.class).doubleValue() * right.getValue(Number.class).doubleValue();
        return new Value(result);
    }

    /**
     * Returns the operator string for multiplication ("*").
     *
     * @return the string representing the multiplication operator.
     */
    @Override
    public String getOperatorString() {
        return "*";
    }

    @Override
    public String toString(){
        return "MultiplyTreeNode(" + getLeftOperand() + " * " + getRightOperand() + ")";
    }
}
