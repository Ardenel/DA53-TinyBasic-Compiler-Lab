package fr.utbm.da53.token;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Represents a numeric token in the source code.
 */
public class NumToken extends Token {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+(\\.[0-9]+)?");
    private float tokenValue;

    public NumToken() {
    }

    /**
     * Creates a new numeric token with the given lexeme, line, column and value.
     *
     * @param lexeme the lexeme of the token.
     * @param line the line where the token is located.
     * @param column the column where the token is located.
     * @param tokenValue the numeric value of the token.
     */
    public NumToken(String lexeme, int line, int column, float tokenValue) {
        super(lexeme, line, column);
        this.tokenValue = tokenValue;
    }

    /**
     * Gets the numeric value of the token.
     *
     * @return the numeric value of the token.
     */
    public float getTokenValue() {
        return tokenValue;
    }

    /**
     * Sets the numeric value of the token.
     *
     * @param tokenValue the numeric value to set.
     */
    public void setTokenValue(float tokenValue) {
        this.tokenValue = tokenValue;
    }

    @Override
    public boolean isValid(String lexeme) {
        Matcher matcher = NUMBER_PATTERN.matcher(lexeme);
        return matcher.matches();
    }

    @Override
    public String getTokenType() {
        return "NUM";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
