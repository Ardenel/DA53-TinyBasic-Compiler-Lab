package fr.utbm.da53.scanner;

import java.io.IOException;
import java.io.Reader;

/**
 * A Scanner class that reads characters from an input stream and tracks line and column numbers.
 */
public class Scanner {

    private Reader fileReader;
    private int currentLine;
    private int currentColumn;
    private int nextChar;

    /**
     * Default constructor for Scanner.
     */
    public Scanner() {
    }

    /**
     * Constructs a Scanner with the specified file reader, initializing the line and column.
     *
     * @param fileReader the Reader to read characters from.
     * @throws IOException if an I/O error occurs.
     */
    public Scanner(Reader fileReader) throws IOException {
        this.fileReader = fileReader;
        this.nextChar = fileReader.read();
        this.currentLine = 1;
        this.currentColumn = 1;
    }

    // Getters and Setters

    public int getCurrentLine() {
        return currentLine;
    }

    public void setCurrentLine(int currentLine) {
        this.currentLine = currentLine;
    }

    public int getCurrentColumn() {
        return currentColumn;
    }

    public void setCurrentColumn(int currentColumn) {
        this.currentColumn = currentColumn;
    }

    /**
     * Gets the next character in the stream without advancing.
     *
     * @return the next character as a char.
     */
    public char peek() {
        return (char) nextChar;
    }

    /**
     * Reads the next character from the stream, advancing the line and column counters.
     *
     * @return the current character before advancing.
     * @throws IOException if an I/O error occurs.
     */
    public char get() throws IOException {
        char currentChar = (char) nextChar;
        nextChar = fileReader.read();

        if (currentChar == '\n') {
            currentLine++;
            currentColumn = 1;
        } else {
            currentColumn++;
        }

        return currentChar;
    }

    /**
     * Checks if there are more characters to read.
     *
     * @return true if there are more characters, false otherwise.
     */
    public boolean hasNext() {
        return nextChar != -1;
    }

    /**
     * Closes the file reader.
     *
     * @throws IOException if an I/O error occurs.
     */
    public void close() throws IOException {
        fileReader.close();
    }

    @Override
    public String toString() {
        return "Scanner{" +
                "currentLine=" + currentLine +
                ", currentColumn=" + currentColumn +
                ", nextChar=" + (char) nextChar +
                '}';
    }
}
