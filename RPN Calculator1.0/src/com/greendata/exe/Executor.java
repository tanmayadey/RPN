package com.greendata.exe;

import java.io.IOException;

import com.greendata.pojo.InpultCalculator;
import com.greendata.pojo.InputCalector;


public class Executor {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to RPN Calculator!!");
		System.out.println("Please enter your number separated by spaces inculding oparator");
		
		try {
			 for (;;) {
				String input = InputCalector.getInput();
				InpultCalculator.pushToStack(input);
			 }
		}catch(Exception e) {
			System.out.println("In Valid sequence");
			
		}
		
	}

}
