package fr.utbm.da53.symboltable;

import fr.utbm.da53.token.Token;

/**
 * Represents a symbol table entry for a token, tracking its position in the source code.
 */
public class SymbolTableEntry {

    private final Token token;
    private int firstOccurrenceLine;
    private int lastOccurrenceLine;
    private int firstOccurrenceColumn;
    private int lastOccurrenceColumn;

    /**
     * Constructs a SymbolTableEntry with the given token and occurrence information.
     *
     * @param token the token this entry represents.
     * @param firstOccurrenceLine the line of the first occurrence.
     * @param lastOccurrenceLine the line of the last occurrence.
     * @param firstOccurrenceColumn the column of the first occurrence.
     * @param lastOccurrenceColumn the column of the last occurrence.
     */
    public SymbolTableEntry(Token token, int firstOccurrenceLine, int lastOccurrenceLine, int firstOccurrenceColumn, int lastOccurrenceColumn) {
        this.token = token;
        this.firstOccurrenceLine = firstOccurrenceLine;
        this.lastOccurrenceLine = lastOccurrenceLine;
        this.firstOccurrenceColumn = firstOccurrenceColumn;
        this.lastOccurrenceColumn = lastOccurrenceColumn;
    }

    /**
     * Returns the token associated with this entry.
     *
     * @return the token for this entry.
     */
    public Token getToken() {
        return token;
    }

    // Getter and setter methods for occurrence information

    public int getFirstOccurrenceLine() {
        return firstOccurrenceLine;
    }

    public void setFirstOccurrenceLine(int firstOccurrenceLine) {
        this.firstOccurrenceLine = firstOccurrenceLine;
    }

    public int getLastOccurrenceLine() {
        return lastOccurrenceLine;
    }

    public void setLastOccurrenceLine(int lastOccurrenceLine) {
        this.lastOccurrenceLine = lastOccurrenceLine;
    }

    public int getFirstOccurrenceColumn() {
        return firstOccurrenceColumn;
    }

    public void setFirstOccurrenceColumn(int firstOccurrenceColumn) {
        this.firstOccurrenceColumn = firstOccurrenceColumn;
    }

    public int getLastOccurrenceColumn() {
        return lastOccurrenceColumn;
    }

    public void setLastOccurrenceColumn(int lastOccurrenceColumn) {
        this.lastOccurrenceColumn = lastOccurrenceColumn;
    }


    // Override the toString method to provide a string representation of the entry

    @Override
    public String toString() {
        return "SymbolTableEntry{" +
                "token=" + token +
                ", firstOccurrenceLine=" + firstOccurrenceLine +
                ", lastOccurrenceLine=" + lastOccurrenceLine +
                ", firstOccurrenceColumn=" + firstOccurrenceColumn +
                ", lastOccurrenceColumn=" + lastOccurrenceColumn +
                '}';
    }
}
