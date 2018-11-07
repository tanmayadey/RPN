package com.greendata.pojo;

import java.util.ListIterator;
import java.util.Stack;

import com.greendata.operator.OperatorImpl;

public class InlineCalculator {
	static int optValPos = 0;
	static int positionForFistVal = 0;
	static int positionForSecVal =0;
	
	public static Stack<String> searchOperator(Stack<String>  resultStack) {
		 ListIterator<String> resultListIterator = resultStack.listIterator(resultStack.size());
	        while (resultListIterator.hasPrevious()) {
	            String val = resultListIterator.previous();
	            if(val.equals("*") || val.equals("/") || val.equals("+") || val.equals("-") ) {
	            	String result = getCalculated(val,resultStack);
	            	resultListIterator.remove();
	            	//resultListIterator.
	            	resultStack.remove(optValPos);
	            	resultStack.remove(positionForFistVal);
	            	resultStack.remove(positionForSecVal);
	            	resultStack.push(result);
	            	
	            }
	        }
	        
	        return resultStack;
	        
	        
	        
		
	}
	
	private static String getCalculated(String optVal,Stack<String>  resultStack) {
		
		
		int firstVal = 0 ;
		int secVal = 0;
		optValPos = resultStack.search(optVal);
		positionForFistVal = optValPos-1 ;
		positionForSecVal = optValPos-1 ;
		
		if(resultStack.get(positionForFistVal) != null) {
			firstVal =Integer.parseInt(resultStack.get(positionForFistVal));
		}
		if(resultStack.get(positionForSecVal) != null) {
			secVal =Integer.parseInt(resultStack.get(positionForSecVal));
		}
		
		
		String pushResult = calculation(optVal,firstVal,secVal);
		//resultStack.push(pushResult);
		return pushResult;
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
