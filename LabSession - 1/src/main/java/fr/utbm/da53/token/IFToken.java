package fr.utbm.da53.token;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Represents an "IF" token in the source code.
 */
public class IFToken extends Token {

    private static final Pattern IF_PATTERN = Pattern.compile("[Ii][Ff]");

    public IFToken() {
    }

    public IFToken(String lexeme, int line, int column) {
        super(lexeme, line, column);
    }

    @Override
    public boolean isValid(String lexeme) {
        Matcher matcher = IF_PATTERN.matcher(lexeme);
        return matcher.matches();
    }

    @Override
    public String getTokenType() {
        return "IF";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
