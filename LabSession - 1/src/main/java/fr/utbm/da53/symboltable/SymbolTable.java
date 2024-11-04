package fr.utbm.da53.symboltable;

import fr.utbm.da53.token.Token;

import java.util.Map;
import java.util.TreeMap;

/**
 * Represents a symbol table containing tokens and their entries.
 */
public class SymbolTable {

    private Map<Token, SymbolTableEntry> symbolTable;

    /**
     * Constructs an empty SymbolTable.
     */
    public SymbolTable() {
        this.symbolTable = new TreeMap<>();
    }

    /**
     * Retrieves the current symbol table map.
     *
     * @return the symbol table map containing tokens and their entries.
     */
    public Map<Token, SymbolTableEntry> getSymbolTable() {
        return symbolTable;
    }

    /**
     * Sets a new symbol table map.
     *
     * @param symbolTable a map of tokens and their symbol table entries.
     */
    public void setSymbolTable(Map<Token, SymbolTableEntry> symbolTable) {
        this.symbolTable = symbolTable;
    }

    /**
     * Adds a new symbol to the table or updates an existing symbol's last occurrence.
     *
     * @param token the token to add.
     * @param firstOccurrenceLine the line of the first occurrence.
     * @param lastOccurrenceLine the line of the last occurrence.
     * @param firstOccurrenceColumn the column of the first occurrence.
     * @param lastOccurrenceColumn the column of the last occurrence.
     */
    public void addSymbol(Token token, int firstOccurrenceLine, int lastOccurrenceLine, int firstOccurrenceColumn, int lastOccurrenceColumn) {
        if (!containsSymbol(token)) {
            SymbolTableEntry entry = new SymbolTableEntry(token, firstOccurrenceLine, lastOccurrenceLine, firstOccurrenceColumn, lastOccurrenceColumn);
            symbolTable.put(token, entry);
        } else {
            SymbolTableEntry entry = getSymbol(token);
            entry.setLastOccurrenceLine(lastOccurrenceLine);
            entry.setLastOccurrenceColumn(lastOccurrenceColumn);
        }
    }

    /**
     * Retrieves the symbol table entry for a given token.
     *
     * @param token the token to search for.
     * @return the symbol table entry associated with the token, or null if not found.
     */
    public SymbolTableEntry getSymbol(Token token) {
        return symbolTable.get(token);
    }

    /**
     * Checks if a token is already in the symbol table.
     *
     * @param token the token to search for.
     * @return true if the token is in the table, false otherwise.
     */
    public boolean containsSymbol(Token token) {
        return symbolTable.containsKey(token);
    }

    /**
     * Removes a symbol from the table.
     *
     * @param token the token to remove.
     */
    public void removeSymbol(Token token) {
        symbolTable.remove(token);
    }

    /**
     * Prints the entries in the symbol table to the standard output.
     */
    public void displayEntries() {
        int i = 1;
        for (Map.Entry<Token, SymbolTableEntry> entry : symbolTable.entrySet()) {
            System.out.println("Entry " + i + ": " + entry.getValue());
            i++;
        }
    }
}
