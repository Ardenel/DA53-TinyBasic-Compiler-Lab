package fr.utbm.da53.token;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Represents a "GOSUB" token in the source code.
 */
public class GosubToken extends Token {

    private static final Pattern GOSUB_PATTERN = Pattern.compile("([Gg][Oo][Ss][Uu][Bb])");

    /**
     * Default constructor.
     */
    public GosubToken() {
    }

    /**
     * Creates a "GOSUB" token with the given lexeme, line and column.
     *
     * @param lexeme the lexeme of the token.
     * @param line   the line where the lexeme appears.
     * @param column the column where the lexeme starts.
     */
    public GosubToken(String lexeme, int line, int column) {
        super(lexeme, line, column);
    }

    @Override
    public boolean isValid(String lexeme) {
        Matcher matcher = GOSUB_PATTERN.matcher(lexeme);
        return matcher.matches();
    }

    @Override
    public String getTokenType() {
        return "GOSUB";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
