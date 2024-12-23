package fr.utbm.info.da53.lw2.syntaxtree.variables;

import fr.utbm.info.da53.lw2.context.ExecutionContext;
import fr.utbm.info.da53.lw2.error.InterpreterErrorType;
import fr.utbm.info.da53.lw2.error.InterpreterException;
import fr.utbm.info.da53.lw2.syntaxtree.abstractclasses.AbstractValueTreeNode;
import fr.utbm.info.da53.lw2.threeaddresscode.ThreeAddressCode;
import fr.utbm.info.da53.lw2.type.Value;

/**
 * Node for an identifier.
 *
 * @Author Arthur
 */
public class IdentifierTreeNode extends AbstractValueTreeNode {

    private String identifier;

    /**
     * Constructs an identifier node with the specified identifier.
     *
     * @param identifier the identifier to set.
     */
    public IdentifierTreeNode(String identifier) {
        this.identifier = identifier;
    }

    /**
     * Default constructor for creating an empty identifier node.
     * The identifier should be set later using {@link #setIdentifier}.
     */
    public IdentifierTreeNode() {
    }

    /**
     * Sets the identifier.
     *
     * @param identifier the identifier to set.
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /**
     * Returns the identifier.
     *
     * @return the identifier.
     */
    public String getIdentifier() {
        return this.identifier;
    }

    /**
     * Evaluates the identifier by fetching its value from the execution context.
     *
     * @param executionContext the current execution context.
     * @return the value of the identifier.
     * @throws InterpreterException if the identifier is not found in the execution context.
     */
    @Override
    public Value evaluate(ExecutionContext executionContext) throws InterpreterException {
        Value value = executionContext.getSymbolTableEntry(this.identifier).getValue();
        if (value == null) {
            fail(executionContext, InterpreterErrorType.UNSET_VALUE, "Undefined identifier: " + this.identifier);
        }
        return value;
    }

    @Override
    public String generate(ThreeAddressCode code) {
        if (this.identifier == null || this.identifier.isEmpty()) {
            throw new IllegalStateException("Identifier is missing or not set.");
        }

        // Check if the identifier exists in the symbol table
        if (code.getSymbolTable().get(this.identifier) == null) {
            throw new IllegalStateException("Undefined identifier: " + this.identifier);
        }

        // Return the identifier as it directly refers to the variable
        return this.identifier;
    }


    /**
     * Returns the string representation of an identifier.
     * @return the string representation.
     */
    @Override
    public String toString() {
        return this.identifier;
    }
}