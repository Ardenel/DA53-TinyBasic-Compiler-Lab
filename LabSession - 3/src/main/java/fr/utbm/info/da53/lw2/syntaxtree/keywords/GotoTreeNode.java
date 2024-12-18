package fr.utbm.info.da53.lw2.syntaxtree.keywords;

import fr.utbm.info.da53.lw2.context.ExecutionContext;
import fr.utbm.info.da53.lw2.error.InterpreterErrorType;
import fr.utbm.info.da53.lw2.error.InterpreterException;
import fr.utbm.info.da53.lw2.syntaxtree.abstractclasses.AbstractStatementTreeNode;
import fr.utbm.info.da53.lw2.syntaxtree.abstractclasses.AbstractValueTreeNode;

/**
 * Represents a `GOTO` statement in the syntax tree.
 *
 * This node evaluates its child expression and prints the result
 * to the standard output or a designated output stream.
 *
 * @author Arthur
 */

public class GotoTreeNode extends AbstractStatementTreeNode {

    private AbstractValueTreeNode expression;

    /**
     * Constructs a `GOTO` statement node with the specified expression.
     *
     * @param expression the expression to evaluate and print.
     */
    public GotoTreeNode(AbstractValueTreeNode expression) {
        this.expression = expression;
    }

    /**
     * Default constructor for creating an empty `GOTO` statement node.
     * The expression should be set later using {@link #setExpression}.
     */
    public GotoTreeNode() {
        super();
    }

    /**
     * Sets the expression to be evaluated and printed.
     *
     * @param expression the expression to set.
     */
    public void setExpression(AbstractValueTreeNode expression) {
        this.expression = expression;
    }

    /**
     * Returns the expression to be evaluated and printed.
     *
     * @return the expression.
     */
    public AbstractValueTreeNode getExpression() {
        return this.expression;
    }

    /**
     * Executes the `GOTO` statement by evaluating the expression
     * and printing its result to the standard output.
     *
     * @param executionContext the current execution context.
     */
    public ExecutionContext run(ExecutionContext executionContext) throws InterpreterException {
        int value = this.expression.evaluate(executionContext).getValue(Integer.class);

        if (value < 0) {
            fail(executionContext, InterpreterErrorType.LINE_NOT_FOUND, "Line number cannot be negative.");
        }


        executionContext.setCurrentLine(value);

        return executionContext;
    }

    /**
     * Returns a string representation of the `GOTO` statement node.
     *
     * @return a string representing the node.
     */
    @Override
    public String toString() {
        return "GOTO " + this.expression.toString();
    }
}
