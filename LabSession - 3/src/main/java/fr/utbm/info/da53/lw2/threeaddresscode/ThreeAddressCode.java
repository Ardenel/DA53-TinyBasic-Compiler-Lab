package fr.utbm.info.da53.lw2.threeaddresscode;

import fr.utbm.info.da53.lw2.symbol.SymbolTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeAddressCode {

    private final List<ThreeAddressRecord> code;
    private final Map<Integer, Integer> lineMappings; // Tiny Basic line -> TAC line
    private final SymbolTable symbolTable; // Reuse your SymbolTable class
    private int tempVarCounter; // Counter for generating unique temporary variables
    private int labelCounter; // Counter for generating unique labels

    public ThreeAddressCode(SymbolTable symbolTable) {
        this.code = new ArrayList<>();
        this.lineMappings = new HashMap<>();
        this.symbolTable = symbolTable;
        this.tempVarCounter = 0;
        this.labelCounter = 0;
    }


    public List<ThreeAddressRecord> getCode() {
        return code;
    }

    public Integer getLineMapping(int tinyBasicLine) {
        return this.lineMappings.get(tinyBasicLine);
    }

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    public int getTempVarCounter() {
        return tempVarCounter;
    }

    public void setTempVarCounter(int tempVarCounter) {
        this.tempVarCounter = tempVarCounter;
    }

    public int getLabelCounter() {
        return labelCounter;
    }

    public void setLabelCounter(int labelCounter) {
        this.labelCounter = labelCounter;
    }


    @Override
    public String toString() {
        return "ThreeAddressCode{" +
                "code=" + code +
                ", lineMappings=" + lineMappings +
                ", symbolTable=" + symbolTable +
                ", tempVarCounter=" + tempVarCounter +
                ", labelCounter=" + labelCounter +
                '}';
    }

    /**
     * Add a new record to the three-address code
     *
     * @param record The record to add
     */
    public void addRecord(ThreeAddressRecord record) {
        this.code.add(record);
    }

    /**
     * Create a new temporary variable
     *
     * @return The name of the new temporary variable
     */
    public String createTempVariable() {
        String tempVar = "t" + tempVarCounter++;
        symbolTable.declare(tempVar, tempVarCounter); // Register it in the symbol table
        return tempVar;
    }

    /**
     * Create a new label
     *
     * @return The name of the new label
     */
    public String createLabel() {
        return "L" + labelCounter++;
    }

    /**
     * Map a Tiny Basic line to a TAC line
     * @param tinyBasicLine The Tiny Basic line
     * @param tacLine The TAC line
     */
    public void mapLine(int tinyBasicLine, int tacLine) {
        this.lineMappings.put(tinyBasicLine, tacLine);
    }

}
