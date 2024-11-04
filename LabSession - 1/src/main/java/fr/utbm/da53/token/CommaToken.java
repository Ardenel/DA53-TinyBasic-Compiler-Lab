package fr.utbm.da53.token;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Represents a comma token in the source code.
 */
public class CommaToken extends Token {

    private static final Pattern COMMA_PATTERN = Pattern.compile(",");

    /**
     * Default constructor.
     */
    public CommaToken() {
    }

    /**
     * Constructs a CommaToken with a specific lexeme, line, and column.
     *
     * @param lexeme the lexeme representing the token.
     * @param line the line number where the token appears.
     * @param column the column number where the token starts.
     */
    public CommaToken(String lexeme, int line, int column) {
        super(lexeme, line, column);
    }

    @Override
    public boolean isValid(String lexeme) {
        Matcher matcher = COMMA_PATTERN.matcher(lexeme);
        return matcher.matches();
    }

    @Override
    public String getTokenType() {
        return "COMMA";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

