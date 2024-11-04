package fr.utbm.da53.token;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Represents a relational operator token in the source code.
 * Includes types such as equal, not equal, less than, etc.
 */
public class RelOpToken extends Token {

    /**
     * Enum for relational operator types.
     */
    public enum RelOpType {
        EQ,   // Equal (=)
        NQ,   // Not equal (<> or ><)
        LT,   // Less than (<)
        GT,   // Greater than (>)
        LE,   // Less than or equal (<=)
        GE    // Greater than or equal (>=)
    }

    private static final Pattern RELOP_PATTERN = Pattern.compile("=|<>|><|<=?|>=?");
    private RelOpType relOpType;

    public RelOpToken() {
    }

    public RelOpToken(String lexeme, int line, int column) {
        super(lexeme, line, column);
        this.relOpType = determineRelOpType(lexeme);
    }

    /**
     * Determines the type of relational operator based on lexeme.
     *
     * @param lexeme the lexeme to check.
     * @return the type of relational operator.
     */
    private RelOpType determineRelOpType(String lexeme) {
        switch (lexeme) {
            case "=": return RelOpType.EQ;
            case "<>": case "><": return RelOpType.NQ;
            case "<": return RelOpType.LT;
            case ">": return RelOpType.GT;
            case "<=": return RelOpType.LE;
            case ">=": return RelOpType.GE;
            default: throw new IllegalArgumentException("Invalid relational operator: " + lexeme);
        }
    }

    @Override
    public boolean isValid(String lexeme) {
        Matcher matcher = RELOP_PATTERN.matcher(lexeme);
        return matcher.matches();
    }

    @Override
    public String getTokenType() {
        return relOpType.toString();
    }

    /**
     * Gets the specific relational operator type.
     *
     * @return the relational operator type.
     */
    public RelOpType getRelOpType() {
        return relOpType;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
