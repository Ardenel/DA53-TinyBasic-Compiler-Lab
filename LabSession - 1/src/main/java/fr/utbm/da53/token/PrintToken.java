package fr.utbm.da53.token;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Represents a "PRINT" token in the source code.
 */
public class PrintToken extends Token {

    private static final Pattern PRINT_PATTERN = Pattern.compile("[Pp][Rr][Ii][Nn][Tt]");

    public PrintToken() {
    }

    public PrintToken(String lexeme, int line, int column) {
        super(lexeme, line, column);
    }

    @Override
    public boolean isValid(String lexeme) {
        Matcher matcher = PRINT_PATTERN.matcher(lexeme);
        return matcher.matches();
    }

    @Override
    public String getTokenType() {
        return "PRINT";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
