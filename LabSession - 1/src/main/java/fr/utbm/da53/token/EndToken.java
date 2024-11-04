package fr.utbm.da53.token;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Represents an "END" token in the source code.
 */
public class EndToken extends Token {

    private static final Pattern END_PATTERN = Pattern.compile("([Ee][Nn][Dd])");

    /**
     * Default constructor.
     */
    public EndToken() {
    }

    /**
     * Creates an "END" token with the given lexeme, line and column.
     *
     * @param lexeme the lexeme of the token.
     * @param line   the line where the lexeme appears.
     * @param column the column where the lexeme starts.
     */
    public EndToken(String lexeme, int line, int column) {
        super(lexeme, line, column);
    }


    @Override
    public boolean isValid(String lexeme) {
        Matcher matcher = END_PATTERN.matcher(lexeme);
        return matcher.matches();
    }

    @Override
    public String getTokenType() {
        return "END";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
