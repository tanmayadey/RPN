package com.greendata.util;

import java.util.Arrays;
import java.util.Stack;

import com.greendata.pojo.InpultCalculator;

public class Util {
	
	public static boolean firstCharValCheck = false;
	
	public static boolean isNumeric(String strNum) {
	    return strNum.matches("-?\\d+(\\.\\d+)?");
	}
	
	public static Stack<String> checkFirstCharOtherThanNumber(String inputLine , Stack<String> resultStack){
		if(inputLine.trim().length() ==1 && !inputLine.equals("clear") && !inputLine.equals("undo") && !inputLine.equals("*") && 
				!inputLine.equals("/") && !inputLine.equals("+") && !inputLine.equals("-") ) {
			resultStack.add(inputLine);
			firstCharValCheck =true;
		}else if(inputLine.trim().length() ==1 && inputLine.equals("clear")) {
			resultStack.clear();
			firstCharValCheck =true;
		}else if(inputLine.trim().length() ==1 && inputLine.equals("undo")) {
			resultStack.pop();
			firstCharValCheck =true;
		}
		
		return resultStack;
	}

	public static Stack<String> addToStackFunctio(String inputLine , Stack<String> resultStack) {
		String inputArr [] = inputLine.trim().split("[ \t]+");
		if(inputArr[0].equals("clear") && !resultStack.isEmpty()) {
			resultStack.clear();
			for(String item: inputArr) {
				if(!item.equals("clear")) {
					resultStack.push(item);
				}
					
			}
		}else if(inputArr[0].equals("undo") && inputArr[1].equals("undo") && !resultStack.isEmpty()){
			resultStack.pop();
			resultStack.pop();
			for(String item: inputArr) {
				if(!item.equals("undo")) {
					resultStack.push(item);
				}
			}
			
		}else if(inputArr[0].equals("undo")  && resultStack.size()>=2){
			resultStack.pop();
			
			for(String item: inputArr) {
				if(!item.equals("undo")) {
					resultStack.push(item);
				}
			}
			
		}else {			
			resultStack.addAll(Arrays.asList(inputLine.trim().split("[ \t]+")));	
			
		}
		return resultStack;
	}

}
