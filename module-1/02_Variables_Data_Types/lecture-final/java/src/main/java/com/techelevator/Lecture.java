package com.techelevator;

public class Lecture {

	public static void main(String[] args) {
		// variables used to hold data needed for the program
		// Data is fundamental to programming
		//    if you understand your data, programming less confusing
		//
		// in Java a variable is defined:  datatype name ;
		//                                 datatype name = initial-value;
		//
		// variable names must be unique in a program (method)
		//
		// Frequent way programmers choose datatypes, look at data to be stored:
		//
		//  if it's numeric without decimal places: int  - most common
		//      unless it can exceed +/- 2 billion: long 
		//  if it's numeric with decimal places:    double
		//
		//  if it's a single character: char
		//  if it's one or more words:  String - special datatype - more later
		//
		//  if it's true or false: boolean
		
		// if a variable is uninitialized you may get unpredictable results
		/*
		1. Create a variable to hold an int and call it numberOfExercises.
			Then set it to 26.
		*/
		int numberOfExercises = 26;
		
		System.out.println("numberOfExercises is: " + numberOfExercises);

		/*
		2. Create a variable to hold a double and call it half.
			Set it to 0.5.
		*/
		double half = .5;
		System.out.println("half is: " + half);

		/*
		3. Create a variable to hold a String and call it name.
			Set it to "TechElevator".
		*/
		String name = "TechElevator";
		System.out.println("The variable name contains the value " + name);

		/*
		4. Create a variable called seasonsOfFirefly and set it to 1.
		*/
		int seasonsOfFirefly = 1;
		System.out.println("seasonsOfFirefly: " + seasonsOfFirefly);

		/*
		5. Create a variable called myFavoriteLanguage and set it to "Java".
		*/
		String myFavoriteLanguage = "Java";
		System.out.println("myFavoriteLanguage: " + myFavoriteLanguage);

		/*
		6. Create a variable called pi and set it to 3.1416.
		*/
		double pi = 3.1416;
		System.out.println("pi=" + pi);

		/*
		7. Create and set a variable that holds your name.
		*/
		String myName = "Gabby";
		name = "Melissa";   // Change a value in a existing variable
		System.out.println("myName has: " + myName + " name has: " + name);
		/*
		8. Create and set a variable that holds the number of buttons on your mouse.
		*/
		int numMouseButtons = 2;
		/*
		9. Create and set a variable that holds the percentage of battery left on
		your phone.
		*/
		double pctBatteryLife = 0.0; 
		System.out.println("pctBatteryLife: " + pctBatteryLife);
		/*
		10. Create an int variable that holds the difference between 121 and 27.
		*/
		int diff = 121 - 27; // simple arithmetic is allowed when assigning values
		/*
		11. Create a double that holds the addition of 12.3 and 32.1.
		*/
		double sum = 12.3 + 32.1;
		/*
		12. Create a String that holds your full name.
		*/
		String fullName = "Your Full Name";
		/*
		13. Create a String that holds the word "Hello, " concatenated onto your
		name from above.
		*/
		// what the + sign does depends on the datatype of what is used with
		// + - numerics - add
		// + - String - concatenate (stick Strings together)
		
		String greeting = "Hello " + fullName;
		/*
		14. Add a " Esquire" onto the end of your full name and save it back to
		the same variable.
		*/
		greeting = greeting + " Esquire";  // You can store a variable back itself
		/*
		15. Now do the same as exercise 14, but use the += operator.
		*/
		greeting += " Esquire";
		/*
		16. Create a variable to hold "Saw" and add a 2 onto the end of it.
		*/

		/*
		17. Add a 0 onto the end of the variable from exercise 16.
		*/

		/*
		18. What is 4.4 divided by 2.2?  double / double - result is a double
		*/
		System.out.println("4.4 / 2.2 is " + 4.4 / 2.2);
		
		/*
		19. What is 5.4 divided by 2? double / int  - result is a double
		*/
		System.out.println("4.4 / 2 is " + 4.4 / 2);
		/*
		20. What is 5 divided by 2? // int / int - result is an int (quotient)
		                            // integer division results in a quotient and remainder
		*/
		System.out.println("5 / 2 is " + 5 / 2);
		/*
		21. What is 5.0 divided by 2? // double / int - result is a double
		*/
		System.out.println("5.0 / 2 is " + 5.0 / 2);
		/*
		22. What is 66.6 divided by 100.00? double / double Is the answer you get right or wrong?
			0.6659999999999999 - inaccuracy when converting double to decimal to display
			                     internally the value is OK - the problem is when it has to
			                         be converted to decimal
			                     double and float are stored a binary (base 2) values
			                     when displaying - convert to decimal (base 10) for humans
			                     the value has binary point (not decimal points)
			                     some binary point values mathematically do not convert to
			                     decimal point values exactly
		
		*/
		System.out.println("66.6 / 100.00 is " + 66.6 / 100.00);
		/*
		23. If I divide 5 by 2, what's my remainder? % operator
		*/
		System.out.println("5 % 2 is " + 5 % 2);  // expecting the value 1
		/*
		24. What is 1,000,000,000 * 3? // int * int - result is an int
		                                  3,000,000,000 is too large to fit in an int
		                                     so the result is not wrong
		                                  we need a long
		*/
		System.out.println("1,000,000,000 * 3 is " + 1000000000 * 3);
		//                                                  int  * long - result is a long
		System.out.println("1,000,000,000 * 3L is " + 1000000000 * 3L);  // L - make it a long
		/*
		25. Create a variable that holds a boolean called doneWithExercises and
		set it to false.
		*/
		boolean  doneWithExercises = false;
		/*
		26. Now set doneWithExercise to true.
		*/
		doneWithExercises = true;
	}

}
