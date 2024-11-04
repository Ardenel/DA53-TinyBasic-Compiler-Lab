package fr.utbm.da53.token;

import fr.utbm.da53.symboltable.SymbolTablePointer;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Represents an identifier (ID) token in the source code.
 */
public class IDToken extends Token {

    private SymbolTablePointer symbolPointer;
    private static final Pattern ID_PATTERN = Pattern.compile("[_a-zA-Z][_a-zA-Z0-9]*");

    /**
     * Default constructor.
     */
    public IDToken() {
        super();
    }

    /**
     * Creates an identifier token with the given lexeme, line, column and symbol table pointer.
     *
     * @param lexeme         the lexeme of the token.
     * @param line           the line where the lexeme appears.
     * @param column         the column where the lexeme starts.
     * @param symbolPointer the symbol table pointer.
     */
    public IDToken(String lexeme, int line, int column, SymbolTablePointer symbolPointer) {
        super(lexeme, line, column);
        this.symbolPointer = symbolPointer;
    }

    /**
     * Gets the symbol table pointer for this identifier token.
     *
     * @return the symbol table pointer.
     */
    public SymbolTablePointer getSymbolPointer() {
        return symbolPointer;
    }

    /**
     * Sets the symbol table pointer for this identifier token.
     *
     * @param symbolPointer the new symbol table pointer.
     */
    public void setSymbolPointer(SymbolTablePointer symbolPointer) {
        this.symbolPointer = symbolPointer;
    }

    @Override
    public boolean isValid(String lexeme) {
        Matcher matcher = ID_PATTERN.matcher(lexeme);
        return matcher.matches();
    }

    @Override
    public String getTokenType() {
        return "ID";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
