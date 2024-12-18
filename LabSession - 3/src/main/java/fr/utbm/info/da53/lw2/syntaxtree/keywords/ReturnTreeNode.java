package fr.utbm.info.da53.lw2.syntaxtree.keywords;

import fr.utbm.info.da53.lw2.context.ExecutionContext;
import fr.utbm.info.da53.lw2.error.InterpreterErrorType;
import fr.utbm.info.da53.lw2.error.InterpreterException;
import fr.utbm.info.da53.lw2.syntaxtree.abstractclasses.AbstractStatementTreeNode;

/**
 * Represents the RETURN statement in the syntax tree.
 *
 * The RETURN statement is used to terminate the execution of a subroutine.
 * When the interpreter encounters a RETURN statement, it will stop the
 * execution of the subroutine and return control to the caller.
 *
 * The RETURN statement does not have any effect on the execution context.
 * It is used to signal the end of the subroutine.
 */
public class ReturnTreeNode extends AbstractStatementTreeNode {

    /**
     * Constructs a RETURN statement tree node.
     */
    public ReturnTreeNode(){

    }

    /**
     * Terminates the execution of the subroutine.
     *
     * @param context the current execution context.
     * @return the parent execution context with the interpreter in the exit state.
     * @throws InterpreterException if an error occurs while terminating the subroutine.
     */
    @Override
    public ExecutionContext run(ExecutionContext context) throws InterpreterException {
        ExecutionContext parent = context.getParent();
        if (parent == null) {
            fail(context, InterpreterErrorType.RETURN_OUTSIDE_SUB);
        }
        context.close();
        return parent;

    }

    /**
     * Returns a string representation of the RETURN statement.
     *
     * @return the string "RETURN".
     */
    @Override
    public String toString() {
        return "RETURN";
    }
}
