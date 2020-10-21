package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");
		// ArrayList is a type of List
		// to define: (put the datatype of objects to be stored inside <>
		//     List<String> anArrayList = new ArrayList<String>();
		//     -or-
	    //     ArrayList<String> anArrayList = new ArrayList<String>();
	    //     -or-
	    //     ArrayList<String> anArrayList = new ArrayList<>();    // Popular method
		
		ArrayList<String> someJavaStudents = new ArrayList<>(); // Define an ArrayList of String

		someJavaStudents.add("Bri");     // Add an element to the ArrayList
		someJavaStudents.add("Amanda");  // Add an element to the ArrayList
		someJavaStudents.add("Semih");   // Add an element to the ArrayList
		someJavaStudents.add("Ashley");  // Add an element to the ArrayList
		someJavaStudents.add("John");    // Add an element to the ArrayList
		someJavaStudents.add("Cody");    // Add an element to the ArrayList
		
		System.out.println("####################");
		System.out.println("Lists are ordered based on when they were entered");
		System.out.println("####################");
		
		// Loop through the ArrayList and display elements
		// .size returns the numbers of elements in the ArrayList
		// .get(index) returns the element at the specified index in the ArrayList
		
		for(int i=0; i < someJavaStudents.size(); i++) {
			System.out.println("element #"+i+": " + someJavaStudents.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");

		someJavaStudents.add("John");
		
		for(int i=0; i < someJavaStudents.size(); i++) {
			System.out.println("element #"+i+": " + someJavaStudents.get(i));
		}


		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		someJavaStudents.add(3, "Seth");  // Insert Seth at index 3 and move every down one 

	
		for(int i=0; i < someJavaStudents.size(); i++) {
			System.out.println("element #"+i+": " + someJavaStudents.get(i));
		}
		someJavaStudents.add("Frank");   // Insert "Frank" 
		
		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		someJavaStudents.remove(5);   // Remove the element at index 4
		
		// remove an entry whose index is unknown - we know the value
		someJavaStudents.remove(someJavaStudents.indexOf("Frank"));  // nest methods if needed
		
		for(int i=0; i < someJavaStudents.size(); i++) {
			System.out.println("element #"+i+": " + someJavaStudents.get(i));
		}
		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		if (someJavaStudents.contains("Douglas")) {
			System.out.println("Douglas IS in the list");
		}
		else {
			System.out.println("Douglas IS NOT the list");
		}

		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		System.out.println("Bri is at index #" + someJavaStudents.indexOf("Bri") + " the list");
		System.out.println("Yoav is at index #" + someJavaStudents.indexOf("Yoav") + " the list");

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		// .toArray(new array-specification)
		//         (new datatype[#-elements-in-array])
		//         (new datatype[listname.size()])
		
		String[] strJavaStudents = someJavaStudents.toArray(new String[someJavaStudents.size()]);
		
		for (int i=0; i < strJavaStudents.length; i++) {
			System.out.println("array element #"+i+": " + strJavaStudents[i]);
		}
		// Alternate method to copy an ArrayList to an array
		System.out.println("-----------------------------------------------------------");
		String[] javaStudents = new String[someJavaStudents.size()];  // Create an array the size of the ArrayList
		
		// Copy the ArrayList into the new array
		for (int i=0; i < someJavaStudents.size(); i++) {  // Loop through ArrayList one element at a time
			javaStudents[i] = someJavaStudents.get(i);     // Assign an ArrayList element to the corresponding array element
		}
		// Display the new array to be sure it was copied correctly
		for (int i=0; i < javaStudents.length; i++) {
			System.out.println("array element #"+i+": " + javaStudents[i]);
		}
		
		System.out.println("####################");
		System.out.println("Primitive Wrappers - Creating Object for primitives");
		System.out.println("So primitive values can be used where only objects are allows");
		System.out.println("####################");

		/* Every primitive has a "Wrapper" class to use it as an Object */
		/* primitive - Wrapper
		 *  int      - Integer
		 *  double   - Double
		 *  float    - Float
		 *  boolean  - Boolean
		 *  char     - Character
		 */
		Integer int1 = new Integer(6);      // Integer Object with the value 6
		Integer int2 = new Integer(16);     // Integer Object with the value 16
		Integer int3 = new Integer("61");   // Integer Object with the value 61 (automatic convert from String)
		
		ArrayList<Integer> intList = new ArrayList<Integer>();
		
		intList.add(int1);
		intList.add(int2);
		intList.add(int3);	 
		
		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		Collections.sort(someJavaStudents); //Sort() modifies the original list, doesn't require assignment
		for (int i = 0; i < someJavaStudents.size(); i++) {
			System.out.println(someJavaStudents.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		Collections.reverse(someJavaStudents); //Reverse() modifies the original list, doesn't require assignment
		for (int i = 0; i < someJavaStudents.size(); i++) {
			System.out.println(someJavaStudents.get(i));
		}

		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		// foreach loop - Always goes from the start of the collection to end
		//                (can't start anywhere but beginning
		//                   or  end before the end
		//                 and can't skip elements)
		//
		//   for (datatype anElementName : collection-name)
		//
		//   go the collection one element at a time from the start to the end
		//   each time through the loop the current element will be stored in the element name specified
		//   use the element name specified to access the current element while in the loop
		
		// Process the ArrayList using for-each
		
		System.out.println("\nDisplay using regualar foreach-loop");
		
		for (String aStudent : someJavaStudents) {                       // In the loop aStudent will be the current element
			System.out.println("element in the ArrayList: " + aStudent); // Cannot display index, because for each doesn't know
		}
		System.out.println("\nDisplay using regular for-loop");
		// Process the ArrayList using a regular for-loop
		for(int studentNumber=0; studentNumber < someJavaStudents.size(); studentNumber++) {
			System.out.println("element #"+studentNumber+": " + someJavaStudents.get(studentNumber));
		}
	}
}
