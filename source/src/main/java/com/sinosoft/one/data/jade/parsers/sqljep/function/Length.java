/*****************************************************************************
      SQLJEP - Java SQL Expression Parser 0.2
      November 1 2006
         (c) Copyright 2006, Alexey Gaidukov
      SQLJEP Author: Alexey Gaidukov

      SQLJEP is based on JEP 2.24 (http://www.singularsys.com/jep/)
           (c) Copyright 2002, Nathan Funk
 
      See LICENSE.txt for license information.
*****************************************************************************/

package com.sinosoft.one.data.jade.parsers.sqljep.function;

import com.sinosoft.one.data.jade.parsers.sqljep.function.PostfixCommand;
import com.sinosoft.one.data.jade.parsers.sqljep.ASTFunNode;
import com.sinosoft.one.data.jade.parsers.sqljep.JepRuntime;
import com.sinosoft.one.data.jade.parsers.sqljep.ParseException;

public class Length extends PostfixCommand {
	final public int getNumberOfParameters() {
		return 1;
	}
	
	public Comparable<?>[] evaluate(ASTFunNode node, JepRuntime runtime) throws ParseException {
		node.childrenAccept(runtime.ev, null);
		Comparable<?>  param = runtime.stack.pop();
		return new Comparable<?>[]{param};
	}

	public static Integer length(Comparable<?>  param) throws ParseException {
		if (param == null) {
			return null;
		}
		return param.toString().length();
	}

	public Comparable<?> getResult(Comparable<?>... comparables)
			throws ParseException {
		return length(comparables[0]);
	}
}

