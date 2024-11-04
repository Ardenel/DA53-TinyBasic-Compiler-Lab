package fr.utbm.da53;

import fr.utbm.da53.lexer.Lexer;
import fr.utbm.da53.scanner.Scanner;
import fr.utbm.da53.symboltable.SymbolTable;
import fr.utbm.da53.token.Token;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Main class for running the Lexer on an input file, displaying tokens in console output,
 * and managing the Symbol Table.
 */
public class Main {
    public static void main(String[] args) {
        String inputFilePath = "src/main/resources/input.txt";
        String outputFilePath = "src/main/resources/lexerOutput.txt";

        // Process input file and write output to file
        try (FileReader fileReader = new FileReader(inputFilePath);
             PrintWriter outputWriter = new PrintWriter(new FileWriter(outputFilePath))) {

            // Initialize Scanner, Lexer, and Symbol Table
            Scanner scanner = new Scanner(fileReader);
            Lexer lexer = new Lexer(scanner);
            SymbolTable symbolTable = new SymbolTable();

            Token token = lexer.getNextSymbol();

            // Process tokens until EOF
            while (!token.getTokenType().equals("EOF")) {

                // Format token output
                String tokenOutput = formatTokenOutput(token);
                //System.out.println("Token: " + token);
                System.out.print(tokenOutput);
                outputWriter.print(tokenOutput);

                // Add token to symbol table
                symbolTable.addSymbol(token, token.getLine(), token.getLine(), token.getColumn(), token.getColumn());

                token = lexer.getNextSymbol();
            }

            //System.out.println("\n\nSymbol Table:");
            //symbolTable.displayEntries();

            scanner.close();

        } catch (IOException e) {
            System.err.println("An error occurred while processing the file: " + e.getMessage());
        }
    }

    /**
     * Formats the output for a given token based on its type and lexeme.
     *
     * @param token the token to format.
     * @return a string formatted as <TOKEN_TYPE,LEXEME> for display.
     */
    private static String formatTokenOutput(Token token) {
        String lexeme = token.getLexeme();
        String tokenType = token.getTokenType();

        // Format output based on token type and lexeme
        switch (tokenType) {
            case "CR":
                return "<CR>\n";
            case "ID":
                return "<ID," + lexeme + "> ";
            case "RELOP":
                return "<RELOP," + lexeme + "> ";
            case "OP":
                return "<OP," + lexeme + "> ";
            case "NUM":
                return "<NUM," + lexeme + "> ";
            case "STRING":
                return "<STRING,\"" + lexeme + "\"> ";
            default:
                return "<" + tokenType + "> ";
        }
    }
}
