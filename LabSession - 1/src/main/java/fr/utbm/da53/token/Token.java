package fr.utbm.da53.token;

/**
 * Abstract base class for different types of tokens in the source code.
 * Each token represents a lexeme, its line, and column position in the source file.
 */
public abstract class Token implements Comparable<Token> {

    private String lexeme;
    private int line;
    private int column;

    /**
     * Constructs a Token with a specific lexeme, line, and column.
     *
     * @param lexeme the lexeme representing the token.
     * @param line the line number where the token appears.
     * @param column the column number where the token starts.
     */
    public Token(String lexeme, int line, int column) {
        this.lexeme = lexeme;
        this.line = line;
        this.column = column;
    }

    /**
     * Default constructor for Token.
     */
    public Token() {
    }

    /**
     * Gets the lexeme of the token.
     *
     * @return the lexeme string.
     */
    public String getLexeme() {
        return lexeme;
    }

    /**
     * Sets the lexeme of the token.
     *
     * @param lexeme the lexeme string.
     */
    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }

    /**
     * Gets the line number of the token.
     *
     * @return the line number.
     */
    public int getLine() {
        return line;
    }

    /**
     * Sets the line number of the token.
     *
     * @param line the line number.
     */
    public void setLine(int line) {
        this.line = line;
    }

    /**
     * Gets the column number of the token.
     *
     * @return the column number.
     */
    public int getColumn() {
        return column;
    }

    /**
     * Sets the column number of the token.
     *
     * @param column the column number.
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * Abstract method to get the type of the token.
     *
     * @return a string representing the token type.
     */
    public abstract String getTokenType();

    /**
     * Abstract method to validate the lexeme for a specific token type.
     *
     * @param lexeme the lexeme to validate.
     * @return true if the lexeme is valid, false otherwise.
     */
    public abstract boolean isValid(String lexeme);

    /**
     * Compares two tokens based on their line and column positions.
     *
     * @param other the token to compare.
     * @return a negative integer, zero, or a positive integer as this token is less than, equal to, or greater than the other token.
     */
    @Override
    public int compareTo(Token other) {
        if (this.line == other.line) {
            return this.column - other.column;
        }
        return this.line - other.line;
    }

    /**
     * Returns a string representation of the token.
     *
     * @return a string representation of the token.
     */
    @Override
    public String toString() {
        return "Token{" +
                "lexeme='" + lexeme + '\'' +
                ", line=" + line +
                ", column=" + column +
                '}';
    }

}
