package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * Given a string, return a new string made of every other char starting with
 * the first, so "Hello" yields "Hlo". GetBits("Hello") → "Hlo" GetBits("Hi")
 * → "H" GetBits("Heeololeo") → "Hello"
 */

public class StringBitsTest {
	
	StringBits testMethods = new StringBits(); // instantiate an object with the methods to test
	
	// we don't need to do anything before or after each test so no @Before/After

	@Test
	public void test_for_Hello() {
		String expectedResult = "Hlo"; // Arrange - setup expected result 
		String testData = "Hello"; // Arrange - setup the test data
		String actualResult = testMethods.getBits(testData); // Act - test method using the object containing
		assertEquals("Incorrect String returned from getBits", expectedResult, actualResult); // Assert
	}
	
	@Test
	public void test_for_Heeololeo() {
		assertEquals("Incorrect String returned from getBits", "Hello", testMethods.getBits("Heeololeo"));
	}
	
	@Test
	public void test_for_null() {
		assertEquals("Incorrect String returned from getBits", "", testMethods.getBits(null));
	}
	
	@Test
	public void test_for_single_char() {
		assertEquals("Incorrect String returned from getBits", "a", testMethods.getBits("a"));
	}

}
