package fr.utbm.info.da53.lw2.threeaddresscode;

public enum ThreeAddressInstruction {
    PRINT,      // Output a value
    IFTRUE,     // Conditional jump if true
    IFFALSE,    // Conditional jump if false
    GOTO,       // Unconditional jump
    GOSUB,      // Jump to a subroutine
    RETURN,     // Return from a subroutine
    END,        // End of the program
    INPUT,      // Read a value
    ASSIGN,     // Assign a value to a variable
    LABEL,      // Define a label (target for jumps)
    ADDITION,   // Arithmetic addition
    SUBTRACTION,   // Arithmetic subtraction
    MULTIPLICATION,   // Arithmetic multiplication
    DIVISION,  // Arithmetic division
    GT,        // Greater than
    GE,         // Greater or equal
    LT,         // Less than
    LE,         // Less or equal
    EQ,         // Equal
    NE,         // Not equal
}
