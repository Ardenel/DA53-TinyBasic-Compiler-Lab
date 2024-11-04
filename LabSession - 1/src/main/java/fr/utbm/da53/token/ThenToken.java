package fr.utbm.da53.token;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Represents a "THEN" token in the source code.
 */
public class ThenToken extends Token {

    private static final Pattern THEN_PATTERN = Pattern.compile("[Tt][Hh][Ee][Nn]");

    public ThenToken() {
    }

    public ThenToken(String lexeme, int line, int column) {
        super(lexeme, line, column);
    }

    @Override
    public boolean isValid(String lexeme) {
        Matcher matcher = THEN_PATTERN.matcher(lexeme);
        return matcher.matches();
    }

    @Override
    public String getTokenType() {
        return "THEN";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
