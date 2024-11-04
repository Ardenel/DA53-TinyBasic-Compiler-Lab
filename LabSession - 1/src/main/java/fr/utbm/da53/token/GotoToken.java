package fr.utbm.da53.token;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Represents a "GOTO" token in the source code.
 */
public class GotoToken extends Token {

    private static final Pattern GOTO_PATTERN = Pattern.compile("([Gg][Oo][Tt][Oo])");

    /**
     * Default constructor.
     */
    public GotoToken() {
    }

    /**
     * Creates a "GOTO" token with the given lexeme, line and column.
     *
     * @param lexeme the lexeme of the token.
     * @param line   the line where the lexeme appears.
     * @param column the column where the lexeme starts.
     */
    public GotoToken(String lexeme, int line, int column) {
        super(lexeme, line, column);
    }

    @Override
    public boolean isValid(String lexeme) {
        Matcher matcher = GOTO_PATTERN.matcher(lexeme);
        return matcher.matches();
    }

    @Override
    public String getTokenType() {
        return "GOTO";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
