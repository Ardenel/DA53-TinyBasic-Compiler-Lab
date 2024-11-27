package fr.utbm.info.da53.lw2.syntaxtree.keywords;


import fr.utbm.info.da53.lw2.context.ExecutionContext;
import fr.utbm.info.da53.lw2.error.InterpreterException;
import fr.utbm.info.da53.lw2.syntaxtree.abstractclasses.AbstractStatementTreeNode;
import fr.utbm.info.da53.lw2.syntaxtree.abstractclasses.AbstractValueTreeNode;
import fr.utbm.info.da53.lw2.type.Value;

/**
 * Represents a `LET` statement in the syntax tree.
 *
 * This node evaluates its child expression and assigns the result
 * to a variable in the current execution context.
 *
 * @Author Arthur
 */
public class LetTreeNode extends AbstractStatementTreeNode {

    private String variable;
    private AbstractValueTreeNode expression;

    /**
     * Constructs a `LET` statement node with the specified variable and expression.
     *
     * @param variable    the variable to assign the expression to.
     * @param expression  the expression to evaluate and assign.
     */
    public LetTreeNode(String variable, AbstractValueTreeNode expression) {
        this.variable = variable;
        this.expression = expression;
    }

    /**
     * Default constructor for creating an empty `LET` statement node.
     * The variable and expression should be set later using their respective setters.
     */
    public LetTreeNode() {
        super();
    }

    /**
     * Sets the variable to assign the expression to.
     *
     * @param variable the variable to set.
     */
    public void setVariable(String variable) {
        this.variable = variable;
    }

    /**
     * Returns the variable to assign the expression to.
     *
     * @return the variable.
     */
    public String getVariable() {
        return this.variable;
    }

    /**
     * Sets the expression to be evaluated and assigned.
     *
     * @param expression the expression to set.
     */
    public void setExpression(AbstractValueTreeNode expression) {
        this.expression = expression;
    }

    /**
     * Returns the expression to be evaluated and assigned.
     *
     * @return the expression.
     */
    public AbstractValueTreeNode getExpression() {
        return this.expression;
    }

    /**
     * Executes the `LET` statement by evaluating the expression
     * and assigning its result to the variable in the current execution context.
     *
     * @param executionContext the current execution context.
     */
    @Override
    public ExecutionContext run(ExecutionContext executionContext) throws InterpreterException {
        // Evaluate the expression
        Value value = this.expression.evaluate(executionContext) ;

        // Assign the result to the variable
        executionContext.setVariable(this.variable,value);
        return executionContext;
    }

}
