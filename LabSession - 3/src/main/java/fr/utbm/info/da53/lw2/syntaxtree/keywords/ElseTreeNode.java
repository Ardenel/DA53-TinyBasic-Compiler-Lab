package fr.utbm.info.da53.lw2.syntaxtree.keywords;

import fr.utbm.info.da53.lw2.context.ExecutionContext;
import fr.utbm.info.da53.lw2.error.InterpreterErrorType;
import fr.utbm.info.da53.lw2.error.InterpreterException;
import fr.utbm.info.da53.lw2.syntaxtree.abstractclasses.AbstractStatementTreeNode;

/**
 * Represents an `ELSE` statement in the syntax tree.
 *
 * This node executes the associated statement if the `IF` condition is false.
 *
 * Note: This node is optional and is used only as part of an `IF-THEN-ELSE` structure.
 *
 * @author Arthur
 */
public class ElseTreeNode extends AbstractStatementTreeNode {

    private AbstractStatementTreeNode statement;

    /**
     * Constructs an `ELSE` statement node with the specified statement.
     *
     * @param statement the statement to execute in the `ELSE` branch.
     */
    public ElseTreeNode(AbstractStatementTreeNode statement) {
        this.statement = statement;
    }

    /**
     * Default constructor for creating an empty `ELSE` statement node.
     * The statement should be set later using {@link #setStatement}.
     */
    public ElseTreeNode() {
        super();
    }

    /**
     * Sets the statement to be executed in the `ELSE` branch.
     *
     * @param statement the statement to set.
     */
    public void setStatement(AbstractStatementTreeNode statement) {
        this.statement = statement;
    }

    /**
     * Returns the statement to be executed in the `ELSE` branch.
     *
     * @return the statement.
     */
    public AbstractStatementTreeNode getStatement() {
        return this.statement;
    }

    /**
     * Executes the `ELSE` statement.
     *
     * @param executionContext the current execution context.
     * @throws InterpreterException if an error occurs during execution.
     */
    @Override
    public ExecutionContext run(ExecutionContext executionContext) throws InterpreterException {
        if (this.statement == null) {
            fail(executionContext, InterpreterErrorType.NOTHING_TO_RUN);
        }
        return this.statement.run(executionContext);
    }

    /**
     * Returns a string representation of this node, including the `ELSE` keyword
     * and its statement.
     *
     * @return a string representation of the `ELSE` statement node.
     */
    @Override
    public String toString() {
        return "ELSE " + (this.statement != null ? this.statement.toString() : "null");
    }
}

