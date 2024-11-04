package fr.utbm.da53.token;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Represents a string token in the source code.
 */
public class StringToken extends Token {

    private static final Pattern STRING_PATTERN = Pattern.compile("\"((\\\\.)|[^\"\\\\])*\"");
    private String tokenString;

    /**
     * Default constructor.
     */
    public StringToken() {
    }

    /**
     * Constructs a string token with the given lexeme, line and column.
     *
     * @param lexeme the lexeme of the token.
     * @param line the line where the token appears.
     * @param column the column where the token appears.
     */
    public StringToken(String lexeme, int line, int column) {
        super(lexeme, line, column);
        this.tokenString = lexeme;
    }

    @Override
    public boolean isValid(String lexeme) {
        Matcher matcher = STRING_PATTERN.matcher(lexeme);
        return matcher.matches();
    }

    @Override
    public String getTokenType() {
        return "STRING";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
