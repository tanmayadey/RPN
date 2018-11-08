package com.greendata.operator;

/**
* This interface contain all operator function
* *
* @author  Tanmaya Dey
* @version 1.0
* @since   2018-11-07 
*/

public interface Operator {

	String addOperator(int a, int b);
	String subsOperator(int a, int b);
	String multiOperator(int a, int b);
	String clearOperator();
	String divOperator(int a, int b);
	String sqrt(int a);
	
}
