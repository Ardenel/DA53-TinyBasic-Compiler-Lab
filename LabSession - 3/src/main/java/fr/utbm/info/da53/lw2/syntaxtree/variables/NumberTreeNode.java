package fr.utbm.info.da53.lw2.syntaxtree.variables;

import fr.utbm.info.da53.lw2.context.ExecutionContext;
import fr.utbm.info.da53.lw2.error.InterpreterException;
import fr.utbm.info.da53.lw2.syntaxtree.abstractclasses.AbstractValueTreeNode;
import fr.utbm.info.da53.lw2.type.Value;

/**
 * Node for a number.
 *
 * @Author Arthur
 */
public class NumberTreeNode extends AbstractValueTreeNode {

    private final Value number;

    /**
     * Constructs a number node with the specified value.
     *
     * @param number the value of the number.
     */
    public NumberTreeNode(Value number) {
        this.number = number;
    }

    /**
     * Returns the value of the number.
     *
     * @return the value.
     */
    public Value getNumber() {
        return this.number;
    }


    /**
     * Evaluates the number node by returning the number.
     * @param executionContext is the current execution context.
     * @return the number.
     * @throws InterpreterException if an error occurs during the evaluation.
     */
    @Override
    public Value evaluate(ExecutionContext executionContext) throws InterpreterException {
        return this.number;
    }

    /**
     * Returns the string representation of the number.
     * @return the string representation.
     */
    @Override
    public String toString() {
        return this.number.toString();
    }
}
