package com.greendata.pojo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* This class will collect the input from command line
* *
* @author  Tanmaya Dey
* @version 1.0
* @since   2018-11-07 
*/

public class CommandLineCollectorPojo {
	
	public static String getInput() throws IOException {
		System.out.println("Enter your input !! ");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String inputLine = in.readLine();
		if(inputLine == null || inputLine.equals("") || inputLine.equals(" ")) {
			askForReEnter();
		}
		return inputLine;
		
	}
	
	private static void askForReEnter() throws IOException {
		System.out.println("Only space input not allowed ");
		getInput();
	}
	
	

}
