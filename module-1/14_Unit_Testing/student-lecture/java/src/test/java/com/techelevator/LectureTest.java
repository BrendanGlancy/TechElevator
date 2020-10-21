package com.techelevator;

import org.junit.After; // The @After annotation is used to execute a method after every test
import org.junit.Assert; // The Assert class has static assertion methods for validating test results
import org.junit.Before; // The @Before annotation is used to execute a method before every test
import org.junit.Test; // The @Test annotation is used to label methods that should be run as tests
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/* Like all other Java code, unit testing code is defined within a class.
 * Each test class will typically contain all of the unit tests for a single
 * "unit" of production code.
 *
 * If the "unit" is a single class from the production code, then the
 * convention is that the test class will belong to the same package as the
 * class under test and the name of the test class is the name of the
 * production class with "Test" at the end.  For example, the test class
 * for the production class "Foo" would be "FooTest"
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING) // list the test methods in alphabetical order
public class LectureTest { // JUnit test are part of a class like everything else in Java
	// the class name should always match the Java file

	/* If a method is annotated with @Before, it will be executed immediately prior to every test.
	 * It is intended to be used when there is a repetitive setup (i.e. "Arrange") task that is
	 * performed by several tests */

	@Before // Do this before every test
	public void setup() { // Method for the @Before processing
		System.out.println("setup"); // There is really nothing we need to do so we display toShow something
	}

	/* If a method is annotated with @After, it will be executed immediately after every test.
	 * It is intended to be used when there is a repetitive cleanup task that is performed by
	 * several tests (e.g. deleting temp files, rolling back database transactions, etc) */

	@After // Do this after every test, optional like @Before if there's nothing to do before and after every test
	public void teardown() { // method for the after processing 
		System.out.println("teardown"); // theres nothing to do here so we just display teardown
	}

	/* Each test is implemented as a method with the @Test annotation. When the JUnit
	 * framework is invoked, it looks for these @Test annotations on the test class
	 * and runs such methods as tests.
	 *
	 * You will notice that the naming convention used in the test methods below
	 * deviates from standard Java method naming conventions by using underscores
	 * between words instead of camelCase. This is my own personal convention and
	 * should not be construed as a general standard or convention. You can also
	 * use camelCase for test method names. You should follow the norm at whatever
	 * development organization you join.
	 *
	 * Regardless of whether you use camelCase or underscores, your method names
	 * should be very descriptive to the point of being overly verbose. This is fine
	 * because you will never write code to invoke your test methods, they are only
	 * invoked by the Junit framework, hence descriptive trumps concise.
	 *
	 * Test methods always:
	 *     - are public
	 *     - return void
	 *     - take no arguments
	 */

	@Test // EVERY test has this 
	// Method ALWAYS public void that takes no arguments
	public void length_returns_the_number_of_characters_in_a_String() { // the naming conventions for the JUnit test method names looks_like_this descriptive
		// be as descriptive as you can no camel case all lower case
		System.out.println("length_returns_the_number_of_characters_in_a_String"); // FOR DEMONSTRATION PURPOSES ONLY, don't do this in your own tests

		/* The assertEquals method validates that two values are equal and
		 * fails the test if they are not equal */

		String theString = "Java"; // Arrange - setup initalize any data used in the test
		int length = theString.length(); // Act - execute the method to be tested with the test data
		Assert.assertEquals(4, length); // Assert - test to see if the expected result was returned by the method
	}

	@Test // SEE
	public void startsWith_returns_true_if_a_string_starts_with_the_specified_characters() {
		System.out.println("startsWith_returns_true_if_a_string_starts_with_the_specified_characters"); // FOR DEMONSTRATION PURPOSES ONLY, don't do this in your own tests

		/* The assertTrue method validates that the boolean value provided as an arugment
		 * is true and fails the test if it is false. */

		String theString = "Hello World!"; // Arrange - setup test data
		boolean startsWithHello = theString.startsWith("Hello"); // Act - run the method to be tested using test data

		/* every assert method allows the first parameter to be a String that contains a message
		 * that should be displayed when the assertion fails
		 *
		 * This is particularly helpful with assertTrue as otherwise the failure output would simply
		 * state "Expected: true Actual: false", which sometimes isn't much help in figuring out
		 * what went wrong */

						// error message if test fails, 					what to test
		Assert.assertTrue("String did not start with Hello as expected.", startsWithHello); // Assert
	}

	@Test // If you dont have this annotation JUnit doesn't know this is a test
	public void this_test_fails_every_time() { 
		System.out.println("this_test_fails_every_time"); // FOR DEMONSTRATION PURPOSES ONLY, don't do this in your own tests

		/* The fail method will cause a test to fail */

		Assert.fail("This is how I can force a test to fail");
	}

	public void this_method_is_not_a_test_because_it_does_not_have_the_Test_annotation() {
		// This method will not be run by Junit, because it's not a test
	}
}
