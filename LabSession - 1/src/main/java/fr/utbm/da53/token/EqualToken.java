package fr.utbm.da53.token;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Represents an equals "=" token in the source code.
 */
public class EqualToken extends Token {

    private static final Pattern EQUAL_PATTERN = Pattern.compile("=");

    /**
     * Default constructor.
     */
    public EqualToken() {
    }

    /**
     * Creates an equals "=" token with the given lexeme, line and column.
     *
     * @param lexeme the lexeme of the token.
     * @param line   the line where the lexeme appears.
     * @param column the column where the lexeme starts.
     */
    public EqualToken(String lexeme, int line, int column) {
        super(lexeme, line, column);
    }

    @Override
    public boolean isValid(String lexeme) {
        Matcher matcher = EQUAL_PATTERN.matcher(lexeme);
        return matcher.matches();
    }

    @Override
    public String getTokenType() {
        return "EQUAL";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
