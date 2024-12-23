package fr.utbm.info.da53.lw2.syntaxtree.keywords;

import fr.utbm.info.da53.lw2.context.ExecutionContext;
import fr.utbm.info.da53.lw2.error.InterpreterErrorType;
import fr.utbm.info.da53.lw2.error.InterpreterException;
import fr.utbm.info.da53.lw2.syntaxtree.abstractclasses.AbstractStatementTreeNode;
import fr.utbm.info.da53.lw2.syntaxtree.abstractclasses.AbstractValueTreeNode;
import fr.utbm.info.da53.lw2.threeaddresscode.ThreeAddressCode;
import fr.utbm.info.da53.lw2.threeaddresscode.ThreeAddressInstruction;
import fr.utbm.info.da53.lw2.threeaddresscode.ThreeAddressRecord;

/**
 * Represents a `GOSUB` statement in the syntax tree.
 *
 * This node evaluates its child expression and prints the result
 * to the standard output or a designated output stream.
 *
 * @Author Arthur
 */
public class GosubTreeNode extends AbstractStatementTreeNode {

    AbstractValueTreeNode expression;

    /**
     * Constructs a `GOSUB` statement node with the specified expression.
     *
     * @param expression the expression to evaluate and print.
     */
    public GosubTreeNode(AbstractValueTreeNode expression) {
        this.expression = expression;
    }

    /**
     * Default constructor for creating an empty `GOSUB` statement node.
     * The expression should be set later using {@link #setExpression}.
     */
    public GosubTreeNode() {
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
     * Executes the `GOSUB` statement by evaluating the expression
     * and printing its result to the standard output.
     *
     * @param executionContext the current execution context.
     */
    @Override
    public ExecutionContext run(ExecutionContext executionContext) throws InterpreterException {
        int value = this.expression.evaluate(executionContext).getValue(Integer.class);

        if (value < 0) {
            warn(executionContext, InterpreterErrorType.LINE_NOT_FOUND);
        }

        ExecutionContext newContext = new ExecutionContext(executionContext);
        newContext.setCurrentLine(value);
        return newContext;
    }

    @Override
    public void generate(ThreeAddressCode code) {
        if (this.expression == null) {
            throw new IllegalStateException("GOSUB expression is missing.");
        }

        // Generate code for the expression and get the resulting variable
        String targetLineNumber = this.expression.generate(code);

        // Generate a label for the return address
        String returnLabel = code.createLabel();

        // Save the return address in the code
        code.addRecord(new ThreeAddressRecord(
                ThreeAddressInstruction.LABEL,
                returnLabel, // Label for returning after the subroutine
                null, // No second parameter
                null, // No result
                null, // No dynamic label needed here
                "Return address for GOSUB"
        ));

        // Add the GOSUB instruction to jump to the target line
        code.addRecord(new ThreeAddressRecord(
                ThreeAddressInstruction.GOSUB,
                targetLineNumber, // Tiny Basic line number of the subroutine
                null, // No second parameter
                null, // No result
                null, // Label or mapping not resolved yet
                "Dynamic jump to Tiny Basic line " + targetLineNumber + " for subroutine"
        ));
    }


    /**
     * Returns the string representation of this node.
     *
     * @return the string representation.
     */
    @Override
    public String toString() {
        return "GOSUB " + this.expression;
    }
}
