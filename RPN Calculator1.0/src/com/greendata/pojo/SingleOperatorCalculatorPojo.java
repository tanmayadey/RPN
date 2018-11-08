package com.greendata.pojo;


import java.util.Stack;

import com.greendata.operator.OperatorImpl;
import com.greendata.util.Util;

/**
* This class will push the input to the Stack and calculate according to operator present in input
* *
* @author  Tanmaya Dey
* @version 1.0
* @since   2018-11-07 
*/

public class SingleOperatorCalculatorPojo {

	static OperatorImpl operatorImpl = new OperatorImpl();
	private static Stack<String> resultStack = new Stack<String>();
	
	
	 /**
	   * This method is used to push the input into Stack
	   * @param inputLine This is command line input
	   * @return stack This returns new stack with calculated value
	   */
	
	public static Stack<String> pushToStackToGetResult(String inputLine) {		
		
		resultStack = Util.checkFirstCharOtherThanNumber(inputLine, resultStack);
		if(Util.firstCharValCheck) {
			Util.firstCharValCheck =false;
			return resultStack;
		}
		resultStack = Util.addToStackFunctio(inputLine, resultStack);
		if(Util.checkMulipleOperator(resultStack)) {
			MultipleOperatorCalculatorPojo.multiOperatorCalculation(resultStack);
		}else {
			calculate(resultStack);
		}
		System.out.println("stack :  "+resultStack);
		return resultStack;
	}
	
	private static Stack<String> calculate(Stack<String>  resultStack) {	
		if(!resultStack.isEmpty())
			getOpearator(resultStack.peek());
		
		
		return resultStack;
	}
	
	 /**
	   * This method is a decision checker on basis of operator
	   * @param peekVal This is input operator 
	   */
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
			resultStack = MultipleOperatorCalculatorPojo.multiOperatorCalculation(resultStack);
			break;
		}
	}
	
	private static Stack<String> calculateSqrt(Stack<String>  resultStack) {
		String pushResult = operatorImpl.sqrt(Integer.parseInt(resultStack.pop().toString()));
		resultStack.push(pushResult);
		return resultStack;
	}
	
	
	/**
	   * This method will find the right and left side value of a operator which named as firstVal and secVal
	   * then call the addition method
	   * @param resultStack This is command line input 
	   */
	
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
	/**
	   * This method will find the right and left side value of a operator which named as firstVal and secVal
	   * then call the subtraction method
	   * @param resultStack This is command line input 
	   */
	
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
	/**
	   * This method will find the right and left side value of a operator which named as firstVal and secVal
	   * then call the multiplication method
	   * @param resultStack This is command line input 
	   */
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
	/**
	   * This method will find the right and left side value of a operator which named as firstVal and secVal
	   * then call the division method
	   * @param resultStack This is command line input 
	   */
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
