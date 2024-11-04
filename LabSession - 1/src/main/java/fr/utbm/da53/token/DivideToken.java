package fr.utbm.da53.token;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Represents a division operator token in the source code.
 */
public class DivideToken extends Token {

    private static final Pattern DIVIDE_PATTERN = Pattern.compile("/");

    /**
     * Default constructor.
     */
    public DivideToken() {
    }

    /**
     * Constructs a DivideToken with a specific lexeme, line, and column.
     *
     * @param lexeme the lexeme representing the token.
     * @param line the line number where the token appears.
     * @param column the column number where the token starts.
     */
    public DivideToken(String lexeme, int line, int column) {
        super(lexeme, line, column);
    }

    @Override
    public boolean isValid(String lexeme) {
        Matcher matcher = DIVIDE_PATTERN.matcher(lexeme);
        return matcher.matches();
    }

    @Override
    public String getTokenType() {
        return "DIVIDE";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
