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
package fr.utbm.info.da53.lw2.syntaxtree.abstractclasses;

import fr.utbm.info.da53.lw2.context.ExecutionContext;
import fr.utbm.info.da53.lw2.error.InterpreterException;
import fr.utbm.info.da53.lw2.type.Value;

/**
 * This abstract class represents any node that is representing a value
 * (number of string literal).
 * 
 * @author St&eacute;phane GALLAND &lt;stephane.galland@utbm.fr&gt;
 * @version $Name$ $Revision$ $Date$
 */
public abstract class AbstractValueTreeNode extends AbstractSyntaxTreeNode {
	
	/**
	 */
	public AbstractValueTreeNode() {
		//
	}
	
	/** Evaluate and replies the value.
	 * 
	 * @param executionContext is the current execution context.
	 * @return the value, never <code>null</code>.
	 * @throws InterpreterException when something bad occurs during the evaluation.
	 */
	public abstract Value evaluate(ExecutionContext executionContext) throws InterpreterException;
	
}
