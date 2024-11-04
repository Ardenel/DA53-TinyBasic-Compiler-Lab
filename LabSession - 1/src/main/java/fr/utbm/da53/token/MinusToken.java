package fr.utbm.da53.token;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Represents a minus "-" token in the source code.
 */
public class MinusToken extends Token {

    private static final Pattern MINUS_PATTERN = Pattern.compile("-");

    public MinusToken() {
    }

    public MinusToken(String lexeme, int line, int column) {
        super(lexeme, line, column);
    }

    @Override
    public boolean isValid(String lexeme) {
        Matcher matcher = MINUS_PATTERN.matcher(lexeme);
        return matcher.matches();
    }

    @Override
    public String getTokenType() {
        return "MINUS";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
