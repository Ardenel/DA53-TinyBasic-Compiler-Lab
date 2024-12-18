package fr.utbm.info.da53.lw2.syntaxtree.keywords;

import java.util.List;
import fr.utbm.info.da53.lw2.context.ExecutionContext;
import fr.utbm.info.da53.lw2.error.InterpreterErrorType;
import fr.utbm.info.da53.lw2.error.InterpreterException;
import fr.utbm.info.da53.lw2.syntaxtree.abstractclasses.AbstractStatementTreeNode;
import fr.utbm.info.da53.lw2.type.Value;

/** Represents the INPUT statement in the syntax tree.
 *
 * The INPUT statement is used to read a value from the standard input and store it in a variable.
 * When the interpreter encounters an INPUT statement, it will prompt the user to enter a value.
 * The value will be read from the standard input and stored in the specified variable.
 *
 * The INPUT statement does not have any effect on the execution context.
 * It is used to read a value from the standard input.
 *
 * @Author Arthur
 */
public class InputTreeNode extends AbstractStatementTreeNode {

    @Override
    public ExecutionContext run(ExecutionContext context) throws InterpreterException {
        return null;
    }
}