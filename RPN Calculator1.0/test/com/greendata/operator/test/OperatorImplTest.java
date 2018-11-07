package com.greendata.operator.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.greendata.operator.OperatorImpl;

class OperatorImplTest {

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
	void testAddOperator() {
		assertEquals("4", new OperatorImpl().addOperator(1, 3));
	}

	@Test
	void testSubsOperator() {
		assertEquals("-2", new OperatorImpl().subsOperator(1, 3));
	}

	@Test
	void testMultiOperator() {
		assertEquals("3", new OperatorImpl().multiOperator(1, 3));
	}

	@Test
	void testClearOperator() {
		//fail("Not yet implemented");
	}

	@Test
	void testDivOperator() {
		assertEquals("2", new OperatorImpl().divOperator(4, 2));
	}

}
