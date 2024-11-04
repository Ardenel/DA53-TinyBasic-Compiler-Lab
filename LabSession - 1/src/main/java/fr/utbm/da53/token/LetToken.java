package fr.utbm.da53.token;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Represents a "LET" token in the source code.
 */
public class LetToken extends Token {

    private static final Pattern LET_PATTERN = Pattern.compile("[Ll][Ee][Tt]");

    public LetToken() {
    }

    public LetToken(String lexeme, int line, int column) {
        super(lexeme, line, column);
    }

    @Override
    public boolean isValid(String lexeme) {
        Matcher matcher = LET_PATTERN.matcher(lexeme);
        return matcher.matches();
    }

    @Override
    public String getTokenType() {
        return "LET";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
