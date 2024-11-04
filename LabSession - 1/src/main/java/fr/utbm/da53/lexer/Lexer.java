package fr.utbm.da53.lexer;

import fr.utbm.da53.scanner.Scanner;
import fr.utbm.da53.token.*;

import java.io.IOException;

public class Lexer {

    private Scanner scanner;

    /**
     * Default constructor for Lexer.
     */
    public Lexer() {
    }

    /**
     * Constructs a Lexer with the specified Scanner.
     *
     * @param scanner the Scanner to read characters from.
     */
    public Lexer(Scanner scanner) {
        this.scanner = scanner;
    }

    // Getters and Setters

    public Scanner getScanner() {
        return scanner;
    }


    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Retrieves the next token from the input stream, skipping whitespace and comments.
     *
     * @return the next identified Token, or null if none is found.
     * @throws IOException if an I/O error occurs.
     */
    public Token getNextSymbol() throws IOException {
        StringBuilder lexeme = new StringBuilder();
        char currentChar = scanner.peek();

        // Skip whitespaces
        while (currentChar == ' ' || currentChar == '\t' || currentChar == '\f'){
            scanner.get();
            currentChar = scanner.peek();
        }

        // Handle End of File
        if (currentChar == (char) -1) {
            return new EOFToken("", scanner.getCurrentLine(), scanner.getCurrentColumn());
        }

        // Handle End of Line
        if (currentChar == '\r') {
            scanner.get();
            if (scanner.peek() == '\n') {
                scanner.get();
            }
            return new CReturnToken("\n", scanner.getCurrentLine(), scanner.getCurrentColumn());
        } else if (currentChar == '\n') {
            scanner.get();
            return new CReturnToken("\n", scanner.getCurrentLine(), scanner.getCurrentColumn());
        }


        // Handle comments beginning with "REM"
        if (currentChar == 'R') {
            if (scanComment()) {
                return null;  // Skip comment content
            }
        }

        // Handle keywords, identifiers, and specific tokens
        if (Character.isLetter(currentChar) || currentChar == '_') {
            return handleIdentifiersOrKeywords(lexeme);
        }

        // Handle numbers
        if (Character.isDigit(currentChar)) {
            return handleNumber(lexeme);
        }

        // Handle single-character tokens
        return handleSingleCharacterTokens(currentChar, lexeme);
    }

    /**
     * Skips characters until the end of a line for comments starting with "REM".
     *
     * @return true if a comment was detected and processed, false otherwise.
     * @throws IOException if an I/O error occurs.
     */
    private boolean scanComment() throws IOException {
        StringBuilder commentStart = new StringBuilder();
        commentStart.append(scanner.get())
                .append(scanner.get())
                .append(scanner.get());

        if (commentStart.toString().equals("REM")) {
            char currentChar;
            do {
                currentChar = scanner.get();  // Skip characters until end of line or file
            } while (currentChar != '\n' && currentChar != (char) -1);
            return true;
        }
        return false;
    }

    /**
     * Handles the lexing of identifiers or keywords.
     *
     * @param lexeme the lexeme to populate.
     * @return a Token instance for the identified keyword or identifier.
     * @throws IOException if an I/O error occurs.
     */
    private Token handleIdentifiersOrKeywords(StringBuilder lexeme) throws IOException {
        char currentChar = scanner.peek();
        if (Character.isLetter(currentChar) || currentChar == '_') {
            while (Character.isLetterOrDigit(currentChar) || currentChar == '_') {
                lexeme.append(scanner.get());
                currentChar = scanner.peek();
            }

            String lex = lexeme.toString().toUpperCase();
            switch (lex) {
                case "PRINT":
                    return new PrintToken(lex, scanner.getCurrentLine(), scanner.getCurrentColumn());
                case "IF":
                    return new IFToken(lex, scanner.getCurrentLine(), scanner.getCurrentColumn());
                case "THEN":
                    return new ThenToken(lex, scanner.getCurrentLine(), scanner.getCurrentColumn());
                case "GOTO":
                    return new GotoToken(lex, scanner.getCurrentLine(), scanner.getCurrentColumn());
                case "GOSUB":
                    return new GosubToken(lex, scanner.getCurrentLine(), scanner.getCurrentColumn());
                case "LET":
                    return new LetToken(lex, scanner.getCurrentLine(), scanner.getCurrentColumn());
                case "INPUT":
                    return new InputToken(lex, scanner.getCurrentLine(), scanner.getCurrentColumn());
                case "RETURN":
                    return new ReturnToken(lex, scanner.getCurrentLine(), scanner.getCurrentColumn());
                case "END":
                    return new EndToken(lex, scanner.getCurrentLine(), scanner.getCurrentColumn());
                default:
                    return new IDToken(lex, scanner.getCurrentLine(), scanner.getCurrentColumn(), null);
            }
        }
        return null;
    }

    /**
     * Handles the lexing of numeric tokens.
     *
     * @param lexeme the lexeme to populate.
     * @return a NumToken if the lexeme is a valid number.
     * @throws IOException if an I/O error occurs.
     */
    private Token handleNumber(StringBuilder lexeme) throws IOException {
        char currentChar = scanner.peek();
        while (Character.isDigit(currentChar) || currentChar == '.') {
            lexeme.append(scanner.get());
            currentChar = scanner.peek();
        }
        return new NumToken(lexeme.toString(), scanner.getCurrentLine(), scanner.getCurrentColumn(), Float.parseFloat(lexeme.toString()));
    }

    /**
     * Handles single-character tokens such as operators and punctuation.
     *
     * @param currentChar the character to process.
     * @param lexeme      the lexeme to populate.
     * @return a Token instance for the detected character.
     * @throws IOException if an I/O error occurs.
     */
    private Token handleSingleCharacterTokens(char currentChar, StringBuilder lexeme) throws IOException {
        if (currentChar == '<' || currentChar == '>' || currentChar == '=') {
            return handleRelationalOperator(currentChar);
        }
        lexeme.append(scanner.get());
        switch (currentChar) {
            case '+': return new PlusToken(lexeme.toString(), scanner.getCurrentLine(), scanner.getCurrentColumn());
            case '-': return new MinusToken(lexeme.toString(), scanner.getCurrentLine(), scanner.getCurrentColumn());
            case '*': return new MultiplyToken(lexeme.toString(), scanner.getCurrentLine(), scanner.getCurrentColumn());
            case '/': return new DivideToken(lexeme.toString(), scanner.getCurrentLine(), scanner.getCurrentColumn());
            case '=': return new EqualToken(lexeme.toString(), scanner.getCurrentLine(), scanner.getCurrentColumn());
            case '(': return new OParentToken(lexeme.toString(), scanner.getCurrentLine(), scanner.getCurrentColumn());
            case ')': return new CParentToken(lexeme.toString(), scanner.getCurrentLine(), scanner.getCurrentColumn());
            case ',': return new CommaToken(lexeme.toString(), scanner.getCurrentLine(), scanner.getCurrentColumn());
            default: return null;
        }
    }

    /**
     * Handles the lexing of relational operators.
     *
     * @param currentChar the character to process.
     * @return a RelOpToken instance for the detected relational operator.
     * @throws IOException if an I/O error occurs.
     */
    private Token handleRelationalOperator(char currentChar) throws IOException {
        StringBuilder lexeme = new StringBuilder();
        lexeme.append(scanner.get());

        char nextChar = scanner.peek();

        // Check for compound relational operators
        if ((currentChar == '<' && (nextChar == '=' || nextChar == '>')) ||
                (currentChar == '>' && nextChar == '=')) {
            lexeme.append(scanner.get());  // Consume the second character
        }

        // Create the RelOpToken with the full lexeme
        return new RelOpToken(lexeme.toString(), scanner.getCurrentLine(), scanner.getCurrentColumn());
    }
}