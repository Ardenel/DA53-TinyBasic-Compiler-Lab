package fr.utbm.info.da53.lw2.syntaxtree.keywords;

import fr.utbm.info.da53.lw2.context.ExecutionContext;
import fr.utbm.info.da53.lw2.error.InterpreterException;
import fr.utbm.info.da53.lw2.syntaxtree.abstractclasses.AbstractStatementTreeNode;


/**
 * Represents the END statement in the syntax tree.
 *
 * The END statement is used to terminate the execution of the program.
 * When the interpreter encounters an END statement, it will stop the
 * execution of the program and return control to the caller.
 *
 * The END statement does not have any effect on the execution context.
 * It is used to signal the end of the program.
 */

public class EndTreeNode extends AbstractStatementTreeNode {

    /**
     * Constructs an END statement tree node.
     */
    public EndTreeNode() {
    }

    /**
     * Terminates the execution of the program.
     *
     * @param context the current execution context.
     * @return the same execution context with the interpreter in the exit state.
     * @throws InterpreterException if an error occurs while terminating the program.
     */
    @Override
    public ExecutionContext run(ExecutionContext context) throws InterpreterException {
        context.getInterpreter().exit();
        return context;
    }

    /**
     * Returns a string representation of the END statement.
     *
     * @return the string "END".
     */
    @Override
    public String toString() {
        return "END";
    }
}
