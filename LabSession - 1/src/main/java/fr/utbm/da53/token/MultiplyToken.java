package fr.utbm.da53.token;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Represents a multiplication "*" token in the source code.
 */
public class MultiplyToken extends Token {

    private static final Pattern MULTIPLY_PATTERN = Pattern.compile("\\*");

    public MultiplyToken() {
    }

    public MultiplyToken(String lexeme, int line, int column) {
        super(lexeme, line, column);
    }

    @Override
    public boolean isValid(String lexeme) {
        Matcher matcher = MULTIPLY_PATTERN.matcher(lexeme);
        return matcher.matches();
    }

    @Override
    public String getTokenType() {
        return "MULTIPLY";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
