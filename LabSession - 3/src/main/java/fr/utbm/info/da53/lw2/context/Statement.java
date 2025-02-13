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
package fr.utbm.info.da53.lw2.context;

import fr.utbm.info.da53.lw2.error.InterpreterException;
import fr.utbm.info.da53.lw2.threeaddresscode.ThreeAddressCode;
import fr.utbm.info.da53.lw2.threeaddresscode.ThreeAddressRecord;

/**
 * Statement in TinyBasic.
 * 
 * @author St&eacute;phane GALLAND &lt;stephane.galland@utbm.fr&gt;
 * @version $Name$ $Revision$ $Date$
 */
public interface Statement {

	/** Run the statement.
	 * 
	 * @param context is the current execution context.
	 * @return the context to use after the execution of the function.
	 * @throws InterpreterException when something bar occur during the execution of the statement.
	 */
	public ExecutionContext run(ExecutionContext context) throws InterpreterException;

	/**
	 * Generate the three address code for the statement.
	 * @param code the three address code to generate.
	 */
	public void generate(ThreeAddressCode code);
}
