package fr.utbm.da53.token;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Represents an opening parenthesis "(" token in the source code.
 */
public class OParentToken extends Token {

    private static final Pattern OPARENT_PATTERN = Pattern.compile("\\(");

    public OParentToken() {
    }

    public OParentToken(String lexeme, int line, int column) {
        super(lexeme, line, column);
    }

    @Override
    public boolean isValid(String lexeme) {
        Matcher matcher = OPARENT_PATTERN.matcher(lexeme);
        return matcher.matches();
    }

    @Override
    public String getTokenType() {
        return "OPARENT";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
