package fr.utbm.da53.token;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Represents a plus "+" token in the source code.
 */
public class PlusToken extends Token {

    private static final Pattern PLUS_PATTERN = Pattern.compile("\\+");

    public PlusToken() {
    }

    public PlusToken(String lexeme, int line, int column) {
        super(lexeme, line, column);
    }

    @Override
    public boolean isValid(String lexeme) {
        Matcher matcher = PLUS_PATTERN.matcher(lexeme);
        return matcher.matches();
    }

    @Override
    public String getTokenType() {
        return "PLUS";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
