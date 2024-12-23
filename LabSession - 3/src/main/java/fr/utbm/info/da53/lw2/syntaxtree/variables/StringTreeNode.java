package fr.utbm.info.da53.lw2.syntaxtree.variables;

import fr.utbm.info.da53.lw2.context.ExecutionContext;
import fr.utbm.info.da53.lw2.error.InterpreterException;
import fr.utbm.info.da53.lw2.syntaxtree.abstractclasses.AbstractValueTreeNode;
import fr.utbm.info.da53.lw2.threeaddresscode.ThreeAddressCode;
import fr.utbm.info.da53.lw2.threeaddresscode.ThreeAddressInstruction;
import fr.utbm.info.da53.lw2.threeaddresscode.ThreeAddressRecord;
import fr.utbm.info.da53.lw2.type.Value;

/**
 * Node for a string value.
 *
 * @Author Arthur
 */
public class StringTreeNode extends AbstractValueTreeNode {

    private final String value;

    /**
     * Constructs a string value node with the specified value.
     *
     * @param value the string value.
     */
    public StringTreeNode(String value) {
        this.value = value;
    }

    /**
     * Returns the string value.
     *
     * @return the string value.
     */
    public String getValue() {
        return this.value;
    }

    /**
     * Evaluates the string value node by returning the string value.
     *
     * @param executionContext the current execution context.
     * @return the string value.
     * @throws InterpreterException if an error occurs during evaluation.
     */
    @Override
    public Value evaluate(ExecutionContext executionContext) throws InterpreterException {
        return new Value(this.value);
    }

    @Override
    public String generate(ThreeAddressCode code) {
        if (this.value == null) {
            throw new IllegalStateException("String value is null.");
        }

        // Create a temporary variable to store the string
        String tempVar = code.createTempVariable();

        // Add an assignment instruction to assign the string value to the temporary variable
        code.addRecord(new ThreeAddressRecord(
                ThreeAddressInstruction.ASSIGN, // Assignment operation
                "\"" + this.value.replace("\"", "\\\"") + "\"", // The escaped string value
                null,                           // No second parameter
                tempVar,                        // Temporary variable to hold the string
                null,                           // No label
                "Assign string value \"" + this.value + "\" to " + tempVar
        ));

        // Return the temporary variable
        return tempVar;
    }


    /**
     * Returns a string representation of the string value.
     *
     * @return the string value.
     */
    @Override
    public String toString() {
        return "\"" + this.value.replace("\"", "\\\"") + "\"";
    }

}
