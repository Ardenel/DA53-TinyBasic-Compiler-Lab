package fr.utbm.da53.token;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Represents an "INPUT" token in the source code.
 */
public class InputToken extends Token {

    private static final Pattern INPUT_PATTERN = Pattern.compile("[Ii][Nn][Pp][Uu][Tt]");

    public InputToken() {
    }

    public InputToken(String lexeme, int line, int column) {
        super(lexeme, line, column);
    }

    @Override
    public boolean isValid(String lexeme) {
        Matcher matcher = INPUT_PATTERN.matcher(lexeme);
        return matcher.matches();
    }

    @Override
    public String getTokenType() {
        return "INPUT";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
