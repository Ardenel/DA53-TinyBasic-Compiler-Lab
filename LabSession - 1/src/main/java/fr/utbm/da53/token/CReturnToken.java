package fr.utbm.da53.token;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Represents a carriage return token in the source code.
 */
public class CReturnToken extends Token {

    private static final Pattern CRETURN_PATTERN = Pattern.compile("[\\n\\r]");

    /**
     * Default constructor.
     */
    public CReturnToken() {
    }

    /**
     * Constructs a CReturnToken with a specific lexeme, line, and column.
     *
     * @param lexeme the lexeme representing the token.
     * @param line the line number where the token appears.
     * @param column the column number where the token starts.
     */
    public CReturnToken(String lexeme, int line, int column) {
        super(lexeme, line, column);
    }

    @Override
    public boolean isValid(String lexeme) {
        Matcher matcher = CRETURN_PATTERN.matcher(lexeme);
        return matcher.matches();
    }

    @Override
    public String getTokenType() {
        return "CR";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
