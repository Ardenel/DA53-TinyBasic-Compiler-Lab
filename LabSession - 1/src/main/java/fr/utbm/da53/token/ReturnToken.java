package fr.utbm.da53.token;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Represents a "RETURN" token in the source code.
 */
public class ReturnToken extends Token {

    private static final Pattern RETURN_PATTERN = Pattern.compile("[Rr][Ee][Tt][Uu][Rr][Nn]");

    public ReturnToken() {
    }

    public ReturnToken(String lexeme, int line, int column) {
        super(lexeme, line, column);
    }

    @Override
    public boolean isValid(String lexeme) {
        Matcher matcher = RETURN_PATTERN.matcher(lexeme);
        return matcher.matches();
    }

    @Override
    public String getTokenType() {
        return "RETURN";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
