/* 
 * $Id$
 * 
 * Copyright (c) 2012-2021 Stephane GALLAND.
 * 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fr.utbm.info.da53.lw2.syntaxtree.operator;

import fr.utbm.info.da53.lw2.context.ExecutionContext;
import fr.utbm.info.da53.lw2.error.InterpreterErrorType;
import fr.utbm.info.da53.lw2.error.InterpreterException;
import fr.utbm.info.da53.lw2.syntaxtree.abstractclasses.AbstractBinaryOperatorTreeNode;
import fr.utbm.info.da53.lw2.syntaxtree.abstractclasses.AbstractValueTreeNode;
import fr.utbm.info.da53.lw2.threeaddresscode.ThreeAddressCode;
import fr.utbm.info.da53.lw2.threeaddresscode.ThreeAddressInstruction;
import fr.utbm.info.da53.lw2.threeaddresscode.ThreeAddressRecord;
import fr.utbm.info.da53.lw2.type.Value;
import fr.utbm.info.da53.lw2.type.VariableType;

/**
 * Represents a binary addition operation in the syntax tree.
 *
 * The left and right operands are evaluated, and their values
 * are added together. The result is a new value representing
 * the sum of the operands.
 *
 * @author Arthur
 */
public class AdditionTreeNode extends AbstractBinaryOperatorTreeNode {

	/**
	 * Constructs an addition tree node with the specified operands.
	 *
	 * @param leftOperand  the left operand of the addition.
	 * @param rightOperand the right operand of the addition.
	 */
	public AdditionTreeNode(AbstractValueTreeNode leftOperand, AbstractValueTreeNode rightOperand) {
		super(leftOperand, rightOperand);
	}

	/**
	 * Default constructor for creating an empty addition tree node.
	 * Operands should be set later using {@link #setOperands}.
	 */
	public AdditionTreeNode() {
		super();
	}

	/**
	 * Computes the result of adding the left and right operand values.
	 *
	 * @param context the current execution context.
	 * @param left  the evaluated value of the left operand.
	 * @param right the evaluated value of the right operand.
	 * @return the result of adding the left and right operand values.
	 * @throws InterpreterException if the operand types are incompatible with addition.
	 */
	@Override
	protected Value compute(ExecutionContext context, Value left, Value right) throws InterpreterException {
		if (left.getType() != VariableType.NUMBER || right.getType() != VariableType.NUMBER) {
			fail(context, InterpreterErrorType.EXPECTING_NUMBER,
					"Addition operands (" + getOperatorString() + ") be numbers: " + left + ", " + right);
		}

		// Perform addition on numeric values
		Number result = left.getValue(Number.class).doubleValue() + right.getValue(Number.class).doubleValue();
		return new Value(result);
	}

	@Override
	public String generate(ThreeAddressCode code) {
		// Generate code for the left operand and get the resulting temporary variable
		String leftResult = getLeftOperand().generate(code);

		// Generate code for the right operand and get the resulting temporary variable
		String rightResult = getRightOperand().generate(code);

		// Create a temporary variable for the result of the addition
		String result = code.createTempVariable();

		// Add an ADDITION instruction to the three-address code
		code.addRecord(new ThreeAddressRecord(
				ThreeAddressInstruction.ADDITION,
				leftResult,   // Left operand
				rightResult,  // Right operand
				result,       // Result variable
				null,         // No label
				"Compute the sum of " + leftResult + " and " + rightResult
		));

		// Return the result variable
		return result;
	}


	/**
	 * Returns the operator string for addition ("+").
	 *
	 * @return the string representing the addition operator.
	 */
	@Override
	public String getOperatorString() {
		return "+";
	}

	/**
	 * Returns a string representation of this node, including its operands and operator.
	 *
	 * @return a string representation of the addition tree node.
	 */
	@Override
	public String toString() {
		return "(" + getLeftOperand().toString() + " + " + getRightOperand().toString() + ")";
	}
}
