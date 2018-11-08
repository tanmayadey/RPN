package com.greendata.exe;

import java.io.IOException;

import com.greendata.pojo.SingleOperatorCalculatorPojo;
import com.greendata.pojo.CommandLineCollectorPojo;
/**
* The RPN Calculator program implements an command line application to calculate values
* displays Result to the standard output.
*
* @author  Tanmaya Dey
* @version 1.0
* @since   2018-11-07 
*/

public class Executor {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to RPN Calculator!!");
		System.out.println("Please enter your number separated by spaces including operator");
		
		try {
			 for (;;) {// define infinite loop to ask next output
				String input = CommandLineCollectorPojo.getInput();
				SingleOperatorCalculatorPojo.pushToStackToGetResult(input);
			 }
		}catch(Exception e) {
			System.out.println("InValid sequence");
			
		}
		
	}

}
