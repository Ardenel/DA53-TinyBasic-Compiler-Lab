package fr.utbm.da53.symboltable;

/**
 * A pointer to a symbol table entry, used as a reference to an existing symbol entry.
 */
public class SymbolTablePointer {

    private SymbolTableEntry symbolTableEntry;

    /**
     * Default constructor.
     */
    public SymbolTablePointer() {
    }

    /**
     * Constructs a SymbolTablePointer with a specific SymbolTableEntry.
     *
     * @param symbolTableEntry the symbol table entry to point to.
     */
    public SymbolTablePointer(SymbolTableEntry symbolTableEntry) {
        this.symbolTableEntry = symbolTableEntry;
    }

    /**
     * Returns the symbol table entry that this pointer references.
     *
     * @return the symbol table entry.
     */
    public SymbolTableEntry getSymbolTableEntry() {
        return symbolTableEntry;
    }

    /**
     * Sets the symbol table entry that this pointer references.
     *
     * @param symbolTableEntry the new symbol table entry.
     */
    public void setSymbolTableEntry(SymbolTableEntry symbolTableEntry) {
        this.symbolTableEntry = symbolTableEntry;
    }

    // Override the toString method to provide a string representation of the pointer
    @Override
    public String toString() {
        return "SymbolTablePointer{" +
                "entry=" + symbolTableEntry +
                '}';
    }
}
