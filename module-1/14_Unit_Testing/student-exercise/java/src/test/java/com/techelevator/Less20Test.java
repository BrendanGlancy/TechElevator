package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

/*
Return true if the given non-negative number is 1 or 2 less than a multiple of 20. So for example 38
and 39 return true, but 40 returns false.
(Hint: Think "mod".)
less20(18) → true
less20(19) → true
less20(20) → false
*/

public class Less20Test {
	
	Less20 testMethods = new Less20(); // instantiate an object with the methods to test

	@Test
	public void test_for_18() {
		assertEquals("Incorrect Boolean returned from isLessThanMultipleOf20", true, testMethods.isLessThanMultipleOf20(18));
	}
	
	@Test
	public void test_for_19() {
		assertEquals("Incorrect Boolean returned from isLessThanMultipleOf20", true, testMethods.isLessThanMultipleOf20(18));
	}
	
	@Test
	public void test_for_20() {
		assertEquals("Incorrect Boolean returned from isLessThanMultipleOf20", false, testMethods.isLessThanMultipleOf20(20));
	}
	
	@Test
	public void test_for_40() {
		assertEquals("Incorrect Boolean returned from isLessThanMultipleOf20", false, testMethods.isLessThanMultipleOf20(40));
	}
	
	@Test
	public void test_for_38() {
		assertEquals("Incorrect Boolean returned from isLessThanMultipleOf20", true, testMethods.isLessThanMultipleOf20(38));
	}
	
	@Test
	public void test_for_39() {
		assertEquals("Incorrect Boolean returned from isLessThanMultipleOf20", true, testMethods.isLessThanMultipleOf20(39));
	}

}
