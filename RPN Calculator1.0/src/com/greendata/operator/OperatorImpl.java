package com.greendata.operator;

public class OperatorImpl implements Operator {

	@Override
	public String addOperator(int a, int b) {
		// TODO Auto-generated method stub
		return String.valueOf(a+b);
	}

	@Override
	public String subsOperator(int a, int b) {
		// TODO Auto-generated method stub
		return String.valueOf(a-b);
	}

	@Override
	public String multiOperator(int a, int b) {
		// TODO Auto-generated method stub
		return String.valueOf(a*b);
	}

	@Override
	public String clearOperator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String divOperator(int a, int b) {
		// TODO Auto-generated method stub
		return String.valueOf(a/b);
	}

	@Override
	public String sqrt(int a) {
		// TODO Auto-generated method stub
		return String.valueOf(Math.sqrt(a));
	}

	

}
