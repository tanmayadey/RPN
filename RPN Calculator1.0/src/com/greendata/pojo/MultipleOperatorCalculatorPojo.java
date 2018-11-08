package com.greendata.pojo;

import java.util.*;
import java.util.Stack;



import com.greendata.operator.OperatorImpl;


/**
* This class will calculate the input that present in the stack, if the stack not end with with a operator 
* Or if more than one Operator present in stack
* * Example 3 4 5 * * 6 5
* @author  Tanmaya Dey
* @version 1.0
* @since   2018-11-07 
*/

public class MultipleOperatorCalculatorPojo {
	static int optValPos = 0;
	static int positionForFirstVal = 0;
	static int positionForSecVal =0;
	
	public static Stack<String> multiOperatorCalculation(Stack<String>  resultStack) {
		Iterator<String> resultIterator = resultStack.iterator();
		Stack<String> dupResultStack = new Stack<String>();
		 //ListIterator<String> resultListIterator = resultStack.listIterator(resultStack.size());
	        while (resultIterator.hasNext()) {
	            String val = resultIterator.next();
	            dupResultStack.push(val);
	            if(val.equals("*") || val.equals("/") || val.equals("+") || val.equals("-") ) {
	            	dupResultStack = getCalculatedValue(val,dupResultStack);
	            }
	        }
	        
	        return dupResultStack;
	        
	        
	        
		
	}
	
	private static Stack<String> getCalculatedValue(String optVal,Stack<String>  dupResultStack) {
		
		
		int firstVal = 0 ;
		int secVal = 0;
		optValPos = dupResultStack.search(optVal);
		positionForFirstVal = optValPos+1 ;
		positionForSecVal = optValPos+2 ;
		dupResultStack.pop();
		firstVal =Integer.parseInt(dupResultStack.pop());
		secVal =Integer.parseInt(dupResultStack.pop());
		
		/*if(dupResultStack.get(positionForFirstVal) != null) {
			firstVal =Integer.parseInt(dupResultStack.get(positionForFirstVal));
		}
		if(dupResultStack.get(positionForSecVal) != null) {
			secVal =Integer.parseInt(dupResultStack.get(positionForSecVal));
		}*/
		
		
		String pushResult = calculation(optVal,firstVal,secVal);
		dupResultStack.push(pushResult);
		//resultStack.push(pushResult);
		return dupResultStack;
	}
	
	private static String  calculation (String opt, int fVal, int secval) {
		OperatorImpl operatorImpl = new OperatorImpl();
		switch (opt) {
		case "+":
			 return operatorImpl.addOperator(fVal,secval);
		case "-":
			return  operatorImpl.subsOperator(fVal,secval);
		case "*":
			return operatorImpl.multiOperator(fVal,secval);
		case "/":
			return operatorImpl.divOperator(fVal,secval);
			

		default:
			return "";
		}
	}

}
