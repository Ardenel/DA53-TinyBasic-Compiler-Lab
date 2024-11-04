package fr.utbm.da53.token;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Represents a closing parenthesis token in the source code.
 */
public class CParentToken extends Token {

    private static final Pattern CPARENT_PATTERN = Pattern.compile("\\)");

    /**
     * Default constructor.
     */
    public CParentToken() {
    }

    /**
     * Constructs a CParentToken with a specific lexeme, line, and column.
     *
     * @param lexeme the lexeme representing the token.
     * @param line the line number where the token appears.
     * @param column the column number where the token starts.
     */
    public CParentToken(String lexeme, int line, int column) {
        super(lexeme, line, column);
    }

    @Override
    public boolean isValid(String lexeme) {
        Matcher matcher = CPARENT_PATTERN.matcher(lexeme);
        return matcher.matches();
    }

    @Override
    public String getTokenType() {
        return "CPARENT";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
