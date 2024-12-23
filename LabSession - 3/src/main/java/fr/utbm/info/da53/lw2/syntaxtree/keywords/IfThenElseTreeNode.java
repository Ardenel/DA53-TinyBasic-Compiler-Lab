package fr.utbm.info.da53.lw2.syntaxtree.keywords;

import fr.utbm.info.da53.lw2.context.ExecutionContext;
import fr.utbm.info.da53.lw2.error.InterpreterErrorType;
import fr.utbm.info.da53.lw2.error.InterpreterException;
import fr.utbm.info.da53.lw2.syntaxtree.abstractclasses.AbstractStatementTreeNode;
import fr.utbm.info.da53.lw2.syntaxtree.abstractclasses.AbstractValueTreeNode;
import fr.utbm.info.da53.lw2.threeaddresscode.ThreeAddressCode;
import fr.utbm.info.da53.lw2.threeaddresscode.ThreeAddressInstruction;
import fr.utbm.info.da53.lw2.threeaddresscode.ThreeAddressRecord;
import fr.utbm.info.da53.lw2.type.Value;
import fr.utbm.info.da53.lw2.type.VariableType;

/**
 * Represents an `IF-THEN` statement in the syntax tree.
 *
 * This node evaluates a condition and executes the `thenStatement` if the condition is true.
 * Optionally, an `elseStatement` can be executed if the condition is false.
 *
 * @author Arthur
 */
public class IfThenElseTreeNode extends AbstractStatementTreeNode {

    private AbstractValueTreeNode condition;
    private AbstractStatementTreeNode thenStatement;
    private AbstractStatementTreeNode elseStatement;

    /**
     * Constructs an `IF-THEN` statement node with the specified condition and then-statement.
     *
     * @param condition     the condition to evaluate.
     * @param thenStatement the statement to execute if the condition is true.
     */
    public IfThenElseTreeNode(AbstractValueTreeNode condition, AbstractStatementTreeNode thenStatement) {
        this.condition = condition;
        this.thenStatement = thenStatement;
    }


    /**
     * Constructs an `IF-THEN-ELSE` statement node with the specified condition, then-statement and else-statement.
     *
     * @param condition     the condition to evaluate.
     * @param thenStatement the statement to execute if the condition is true.
     * @param elseStatement the statement to execute if the condition is false.
     */
    public IfThenElseTreeNode(AbstractValueTreeNode condition, AbstractStatementTreeNode thenStatement, AbstractStatementTreeNode elseStatement) {
        this.condition = condition;
        this.thenStatement = thenStatement;
        this.elseStatement = elseStatement;
    }

    /**
     * Default constructor for creating an empty `IF-THEN` statement node.
     * Components should be set later using their respective setters.
     */
    public IfThenElseTreeNode() {
        super();
    }

    /**
     * Sets the condition to be evaluated.
     *
     * @param condition the condition to set.
     */
    public void setCondition(AbstractValueTreeNode condition) {
        this.condition = condition;
    }

    /**
     * Returns the condition to be evaluated.
     *
     * @return the condition.
     */
    public AbstractValueTreeNode getCondition() {
        return this.condition;
    }

    /**
     * Sets the statement to be executed if the condition is true.
     *
     * @param thenStatement the then-statement to set.
     */
    public void setThenStatement(AbstractStatementTreeNode thenStatement) {
        this.thenStatement = thenStatement;
    }

    /**
     * Returns the statement to be executed if the condition is true.
     *
     * @return the then-statement.
     */
    public AbstractStatementTreeNode getThenStatement() {
        return this.thenStatement;
    }

    /**
     * Sets the statement to be executed if the condition is false.
     *
     * @param elseStatement the else-statement to set.
     */
    public void setElseStatement(AbstractStatementTreeNode elseStatement) {
        this.elseStatement = elseStatement;
    }

    /**
     * Returns the statement to be executed if the condition is false.
     *
     * @return the else-statement.
     */
    public AbstractStatementTreeNode getElseStatement() {
        return this.elseStatement;
    }

    /**
     * Executes the `IF-THEN` statement by evaluating the condition and executing the appropriate branch.
     *
     * @param executionContext the current execution context.
     * @throws InterpreterException if an error occurs during evaluation or execution.
     */
    @Override
    public ExecutionContext run(ExecutionContext executionContext) throws InterpreterException {
        if (this.condition == null) {
            fail(executionContext, InterpreterErrorType.EXPECTING_BOOLEAN, "IF-THEN condition is missing.");
        }
        if (this.thenStatement == null) {
            fail(executionContext, InterpreterErrorType.NOTHING_TO_RUN, "IF-THEN statement is missing.");
        }

        // Evaluate the condition
        Value conditionValue = this.condition.evaluate(executionContext);
        if (!conditionValue.isSet() || conditionValue.getType() != VariableType.BOOLEAN) {
            warn(executionContext, InterpreterErrorType.UNSET_VALUE, "Condition is not a boolean or is unset.");
        }

        if (conditionValue.isSet() && conditionValue.getValue(Boolean.class)) {
            return this.thenStatement.run(executionContext);
        } else if (this.elseStatement != null) {
            return this.elseStatement.run(executionContext);
        }

        return executionContext;
    }

    @Override
    public void generate(ThreeAddressCode code){
        // Generate code for the condition and get the resulting variable
        String conditionResult = this.condition.generate(code);

        // Generate labels
        String thenLabel = code.createLabel();
        String endLabel = code.createLabel();
        String elseLabel = (this.elseStatement != null) ? code.createLabel() : null;

        // Add conditional jump based on the condition
        if (elseLabel != null) {
            code.addRecord(new ThreeAddressRecord(
                    ThreeAddressInstruction.IFFALSE,
                    conditionResult,
                    null, // No second parameter
                    null, // No result
                    elseLabel, // Jump to ELSE if condition is false
                    "Jump to ELSE block if condition is false"
            ));
        } else {
            code.addRecord(new ThreeAddressRecord(
                    ThreeAddressInstruction.IFFALSE,
                    conditionResult,
                    null, // No second parameter
                    null, // No result
                    endLabel, // Jump to END if condition is false
                    "Jump to END block if condition is false"
            ));
        }

        // Generate code for THEN block
        code.addRecord(new ThreeAddressRecord(
                ThreeAddressInstruction.LABEL,
                thenLabel,
                null, // No second parameter
                null, // No result
                null, // No label
                "Start of THEN block"
        ));
        this.thenStatement.generate(code);

        // Add a jump to the end label if ELSE exists
        if (elseLabel != null) {
            code.addRecord(new ThreeAddressRecord(
                    ThreeAddressInstruction.GOTO,
                    null, // No parameter
                    null, // No second parameter
                    null, // No result
                    endLabel, // Jump to END
                    "Skip ELSE block"
            ));
        }

        // Generate code for ELSE block if it exists
        if (this.elseStatement != null) {
            code.addRecord(new ThreeAddressRecord(
                    ThreeAddressInstruction.LABEL,
                    elseLabel,
                    null, // No second parameter
                    null, // No result
                    null, // No label
                    "Start of ELSE block"
            ));
            this.elseStatement.generate(code);
        }

        // Add the end label
        code.addRecord(new ThreeAddressRecord(
                ThreeAddressInstruction.LABEL,
                endLabel,
                null, // No second parameter
                null, // No result
                null, // No label
                "End of IF-THEN-ELSE block"
        ));
    }


    /**
     * Returns a string representation of this node, including the `IF`, `THEN`,
     * and optional `ELSE` components.
     *
     * @return a string representation of the `IF-THEN` statement node.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("IF ");
        sb.append(this.condition != null ? this.condition.toString() : "null");
        sb.append(" THEN ");
        sb.append(this.thenStatement != null ? this.thenStatement.toString() : "null");
        if (this.elseStatement != null) {
            sb.append(" ELSE ").append(this.elseStatement.toString());
        }
        return sb.toString();
    }
}
