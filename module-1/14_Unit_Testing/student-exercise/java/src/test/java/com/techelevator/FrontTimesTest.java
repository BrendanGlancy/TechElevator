package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * Given a string and a non-negative int n, we'll say that the front of the
 * string is the first 3 chars, or whatever is there if the string is less than
 * length 3. Return n copies of the front; frontTimes("Chocolate", 2) →
 * "ChoCho" frontTimes("Chocolate", 3) → "ChoChoCho" frontTimes("Abc", 3) →
 * "AbcAbcAbc"
 */

public class FrontTimesTest {
	
	FrontTimes testMethods = new FrontTimes(); // instantiate an object with the methods to test

	@Test
	public void test_for_Chocolate_2() {
		assertEquals("Incorrect String returned from generateString", "ChoCho", testMethods.generateString("Chocolate", 2));
	}
	
	@Test
	public void test_for_Chocolate_3() {
		assertEquals("Incorrect String returned from generateString", "ChoChoCho", testMethods.generateString("Chocolate", 3));
	}
	
	@Test
	public void test_for_Abc_3() {
		assertEquals("Incorrect String returned from generateString", "AbcAbcAbc", testMethods.generateString("Abc", 3));
	}
	
	@Test
	public void test_for_Abc_0() {
		assertEquals("Incorrect String returned from generateString", "", testMethods.generateString("Abc", 0));
	}
	
	@Test
	public void test_for_null_1() {
		assertEquals("Incorrect String returned from generateString", "", testMethods.generateString(null, 1));
	}

}
