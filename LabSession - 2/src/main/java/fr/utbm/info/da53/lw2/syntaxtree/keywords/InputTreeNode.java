package fr.utbm.info.da53.lw2.syntaxtree.keywords;

import java.util.List;
import fr.utbm.info.da53.lw2.context.ExecutionContext;
import fr.utbm.info.da53.lw2.error.InterpreterErrorType;
import fr.utbm.info.da53.lw2.error.InterpreterException;
import fr.utbm.info.da53.lw2.type.Value;

/** Represents the INPUT statement in the syntax tree.
 *
 * The INPUT statement is used to read a value from the standard input and store it in a variable.
 * When the interpreter encounters an INPUT statement, it will prompt the user to enter a value.
 * The value will be read from the standard input and stored in the specified variable.
 *
 * The INPUT statement does not have any effect on the execution context.
 * It is used to read a value from the standard input.
 *
 * @Author Arthur
 */
public class InputTreeNode {

    private List<String> variables; // List of variable names to read input for

    /**
     * Constructs an `INPUT` statement node with the specified variables.
     *
     * @param variables the list of variable names to store input.
     */
    public InputTreeNode(List<String> variables) {
        this.variables = variables;
    }

    /**
     * Default constructor for creating an empty `INPUT` statement node.
     * The variables should be set later using {@link #setVariables}.
     */
    public InputTreeNode() {
        super();
    }

    /**
     * Sets the list of variables to store input.
     *
     * @param variables the list of variable names.
     */
    public void setVariables(List<String> variables) {
        this.variables = variables;
    }

    /**
     * Returns the list of variables to store input.
     *
     * @return the list of variable names.
     */
    public List<String> getVariables() {
        return this.variables;
    }

    /**
     * Executes the `INPUT` statement by reading values from the standard input
     * and storing them in the specified variables.
     *
     * @param executionContext the current execution context.
     * @throws InterpreterException if an error occurs during input or execution.
     */
    @Override
    public ExecutionContext run(ExecutionContext executionContext) throws InterpreterException {
        if (this.variables == null || this.variables.isEmpty()) {
            fail(executionContext, InterpreterErrorType.UNDEFINED_VARIABLE, "No variables provided for INPUT statement.");
        }

        for (String variable : this.variables) {
            try {
                // Prompt user for input
                executionContext.getInterpreter().getStandardOutput().print("Enter value for " + variable + ": ");
                String input = executionContext.getInterpreter().getStandardInput().readLine();

                // Convert input to a Value and store it in the context
                Value value = Value.parse(input); // Assuming Value has a `parse` method
                executionContext.getSymbolTable().set(variable, value);

            } catch (Exception e) {
                fail(executionContext, InterpreterErrorType.INPUT_ERROR, "Failed to read input for variable " + variable + ": " + e.getMessage());
            }
        }

        return executionContext;
    }

    /**
     * Returns a string representation of this node, including the `INPUT` keyword
     * and the list of variables.
     *
     * @return a string representation of the `INPUT` statement node.
     */
    @Override
    public String toString() {
        return "INPUT " + (this.variables != null ? String.join(", ", this.variables) : "null");
    }
}

}
