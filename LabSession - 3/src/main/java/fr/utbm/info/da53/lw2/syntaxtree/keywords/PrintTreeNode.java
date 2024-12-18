package fr.utbm.info.da53.lw2.syntaxtree.keywords;

import fr.utbm.info.da53.lw2.context.ExecutionContext;
import fr.utbm.info.da53.lw2.error.InterpreterErrorType;
import fr.utbm.info.da53.lw2.error.InterpreterException;
import fr.utbm.info.da53.lw2.syntaxtree.abstractclasses.AbstractStatementTreeNode;
import fr.utbm.info.da53.lw2.syntaxtree.abstractclasses.AbstractValueTreeNode;
import fr.utbm.info.da53.lw2.type.Value;


/**
 * Represents a `PRINT` statement in the syntax tree.
 *
 * This node evaluates its child expression and prints the result
 * to the standard output or a designated output stream.
 *
 * @author Arthur
 */
public class PrintTreeNode extends AbstractStatementTreeNode {

    private AbstractValueTreeNode expression;

    /**
     * Constructs a `PRINT` statement node with the specified expression.
     *
     * @param expression the expression to evaluate and print.
     */
    public PrintTreeNode(AbstractValueTreeNode expression) {
        this.expression = expression;
    }

    /**
     * Default constructor for creating an empty `PRINT` statement node.
     * The expression should be set later using {@link #setExpression}.
     */
    public PrintTreeNode() {
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
     * Executes the `PRINT` statement by evaluating the expression
     * and printing its result to the standard output.
     *
     * @param executionContext the current execution context.
     * @throws InterpreterException if an error occurs during evaluation or execution.
     */
    @Override
    public ExecutionContext run(ExecutionContext executionContext) throws InterpreterException {
        if (this.expression == null) {
            executionContext.getInterpreter().getStandardOutput().println();
        }

        // Evaluate the expression
        Value result = this.expression.evaluate(executionContext);
        if (result.isSet()){
            executionContext.getInterpreter().getStandardOutput().println(result.toString());
        } else {
            warn(executionContext, InterpreterErrorType.UNSET_VALUE);
            executionContext.getInterpreter().getStandardOutput().println();
        }

        return executionContext;
    }

    /**
     * Returns a string representation of this node, including the `PRINT` keyword
     * and the expression.
     *
     * @return a string representation of the `PRINT` statement node.
     */
    @Override
    public String toString() {
        return "PRINT " + (this.expression != null ? this.expression.toString() : "null");
    }

}
