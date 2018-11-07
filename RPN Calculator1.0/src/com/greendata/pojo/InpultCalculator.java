package com.greendata.pojo;

import java.util.Arrays;
import java.util.ListIterator;
import java.util.Stack;

import com.greendata.operator.OperatorImpl;
import com.greendata.util.Util;

public class InpultCalculator {

	static OperatorImpl operatorImpl = new OperatorImpl();
	private static Stack<String> resultStack = new Stack<String>();
	
	public static Stack<String> pushToStack(String inputLine) {		
		
		resultStack = Util.checkFirstCharOtherThanNumber(inputLine, resultStack);
		if(Util.firstCharValCheck) {
			Util.firstCharValCheck =false;
			return resultStack;
		}
		resultStack = Util.addToStackFunctio(inputLine, resultStack);
		calculate(resultStack);
		System.out.println("stack :  "+resultStack);
		return resultStack;
	}
	
	private static Stack<String> calculate(Stack<String>  resultStack) {	
		if(!resultStack.isEmpty())
			getOpearator(resultStack.peek());
		
		
		return resultStack;
	}
	
	private static void getOpearator(String peekVal) {
		
		switch (peekVal) {
		case "+":
			resultStack.pop();
			resultStack = callAddition(resultStack);
			break;
		
		case "-":
			resultStack.pop();
			resultStack = callSub(resultStack);
			break;
		case "*":
			resultStack.pop();
			resultStack = callMulti(resultStack) ;
			break;
		case "/":
			resultStack.pop();
			resultStack = callDiv(resultStack) ;
			break;
		case "clear":
			resultStack.clear();
			break;
		case "undo":
			resultStack.pop();
			break;
			
		case "sqrt":
			resultStack.pop();
			resultStack = calculateSqrt(resultStack) ;
			break;

		default:
			//end is not an operator 
			resultStack = InlineCalculator.searchOperator(resultStack);
			break;
		}
	}
	
	private static Stack<String> calculateSqrt(Stack<String>  resultStack) {
		String pushResult = operatorImpl.sqrt(Integer.parseInt(resultStack.pop().toString()));
		resultStack.push(pushResult);
		return resultStack;
	}
	
	
	
	
	private static Stack<String>  callAddition(Stack<String>  resultStack) {
		int firstVal = 0 ;
		int secVal = 0 ;
		if(resultStack.size() >1) {
			firstVal =Integer.parseInt(resultStack.pop().toString());
			secVal =Integer.parseInt(resultStack.pop().toString());
			String pushResult = operatorImpl.addOperator(firstVal,secVal);
			resultStack.push(pushResult);
		}else if(resultStack.size() == 1){
			resultStack.push("0");
		}
		return resultStack;
	}
	
	private static Stack<String> callSub(Stack<String>  resultStack) {
		int firstVal = 0 ;
		int secVal = 0 ;
		if(resultStack.size() >1) {
			secVal =Integer.parseInt(resultStack.pop().toString());
			firstVal =Integer.parseInt(resultStack.pop().toString());
			String pushResult = operatorImpl.subsOperator(firstVal,secVal);
			resultStack.push(pushResult);
		}else if(resultStack.size() == 1){
			resultStack.push("0");
		}
		return resultStack;
	}
	
	private static Stack<String> callMulti(Stack<String>  resultStack) {
		int firstVal = 0 ;
		int secVal = 0 ;
		if(resultStack.size() >1) {
			firstVal =Integer.parseInt(resultStack.pop().toString());
			secVal =Integer.parseInt(resultStack.pop().toString());
			String pushResult = operatorImpl.multiOperator(firstVal,secVal);
			resultStack.push(pushResult);
		}else if(resultStack.size() == 1){
			resultStack.push("0");
		}
		return resultStack;
	}
	private static Stack<String> callDiv(Stack <String>  resultStack) {
		int firstVal = 0 ;
		int secVal = 0 ;
		if(resultStack.size() >1) {
			secVal =Integer.parseInt(resultStack.pop().toString());
			firstVal =Integer.parseInt(resultStack.pop().toString());
			String pushResult = operatorImpl.divOperator(firstVal,secVal);
			resultStack.push(pushResult);
		}else if(resultStack.size() == 1){
			resultStack.push("0");
		}
		return resultStack;
	}
}
