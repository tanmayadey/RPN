package com.greendata.pojo.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.greendata.pojo.SingleOperatorCalculatorPojo;

class InpultCalculatorTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testPushToStack() {
		Stack<String> result = SingleOperatorCalculatorPojo.pushToStackToGetResult("6 7 +");
		assertEquals("13", result.peek().toString());
		
	}
	@Test
	void testPushToStackClear() {
		Stack<String> result = SingleOperatorCalculatorPojo.pushToStackToGetResult("clear");
		assertEquals(true, result.isEmpty());
		
	}
	
	@Test
	void testPushToStackUndo() {
		Stack<String> result = SingleOperatorCalculatorPojo.pushToStackToGetResult("7 8 9 +");
		result = SingleOperatorCalculatorPojo.pushToStackToGetResult("undo");
		assertEquals(false, result.contains("+"));
		
	}
	
	@Test
	void testPushToStackMinus() {
		Stack<String> result = SingleOperatorCalculatorPojo.pushToStackToGetResult("7 8 9 -");
		//result = InpultCalculator.pushToStack("undo");
		//assertEquals(false, result.contains("+"));
		
	}
	

}
