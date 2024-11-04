package fr.utbm.da53.token;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Represents an end-of-file (EOF) token in the source code.
 */
public class EOFToken extends Token {

    private static final Pattern EOF_PATTERN = Pattern.compile("\\Z");  // Matches end of input

    /**
     * Default constructor.
     */
    public EOFToken() {
    }

    /**
     * Creates an end-of-file token with the given lexeme, line and column.
     *
     * @param lexeme the lexeme of the token.
     * @param line   the line where the lexeme appears.
     * @param column the column where the lexeme starts.
     */
    public EOFToken(String lexeme, int line, int column) {
        super(lexeme, line, column);
    }

    @Override
    public boolean isValid(String lexeme) {
        Matcher matcher = EOF_PATTERN.matcher(lexeme);
        return matcher.matches();
    }

    @Override
    public String getTokenType() {
        return "EOF";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
