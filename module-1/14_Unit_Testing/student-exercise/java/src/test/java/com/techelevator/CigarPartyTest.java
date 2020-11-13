package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

/*
When squirrels get together for a party, they like to have cigars. A squirrel party is successful
when the number of cigars is between 40 and 60, inclusive. Unless it is the weekend, in which case
there is no upper bound on the number of cigars. Return true if the party with the given values is
successful, or false otherwise.
haveParty(30, false) → false
haveParty(50, false) → true
haveParty(70, true) → true
*/

public class CigarPartyTest {
	
	CigarParty testMethods = new CigarParty(); // instantiate an object with the methods to test

	@Test
	public void test_for_30_false() {
		assertEquals("Incorrect Boolean returned from haveParty", false, testMethods.haveParty(30, false));
		
	}
	
	@Test
	public void test_for_50_false() {
		assertEquals("Incorrect Boolean returned from haveParty", true, testMethods.haveParty(50, false));
		
	}
	
	@Test
	public void test_for_70_true() {
		assertEquals("Incorrect Boolean returned from haveParty", true, testMethods.haveParty(70, true));
		
	}
	
	@Test
	public void test_for_70_false() {
		assertEquals("Incorrect Boolean returned from haveParty", false, testMethods.haveParty(70, false));
		
	}
	
	@Test
	public void test_for_0_false() {
		assertEquals("Incorrect Boolean returned from haveParty", false, testMethods.haveParty(0, false));
		
	}
	
	@Test
	public void test_for_0_true() {
		assertEquals("Incorrect Boolean returned from haveParty", false, testMethods.haveParty(0, true));
		
	}
	
	

}
