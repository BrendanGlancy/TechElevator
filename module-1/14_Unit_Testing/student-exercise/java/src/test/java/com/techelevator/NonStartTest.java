package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

/*
Given 2 strings, return their concatenation, except omit the first char of each. The strings will
be at least length 1.
GetPartialString("Hello", "There") → "ellohere"
GetPartialString("java", "code") → "avaode"
GetPartialString("shotl", "java") → "hotlava"
*/

public class NonStartTest {
	
	NonStart testMethods = new NonStart(); // instantiate an object with the methods to test

	@Test
	public void test_for_Hello_There() {
		assertEquals("Incorrect String returned from getPartialString", "ellohere", testMethods.getPartialString("Hello", "There"));
	}
	
	@Test
	public void test_for_java_code() {
		assertEquals("Incorrect String returned from getPartialString", "avaode", testMethods.getPartialString("java", "code"));
	}
	
	@Test
	public void test_for_shotl_java() {
		assertEquals("Incorrect String returned from getPartialString", "hotlava", testMethods.getPartialString("shotl", "java"));
	}
	
	@Test
	public void test_for_blankString() {
		assertEquals("Incorrect String returned from getPartialString", "", testMethods.getPartialString(" ", " "));
	}

}
