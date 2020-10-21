package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");
		// Array list is a type of list
		// to define: (put the datatype inside of brackets)
		// List<String> anArrayList = new ArrayList<String>;
		// ArrayList<String> anArrayList = new ArrayList<String>;
		// List<String> anArrayList = new ArrayList<String>;

		ArrayList<String> someJavaStudents = new ArrayList<>(); // Defines an array list

		someJavaStudents.add("Brendan");
		someJavaStudents.add("Doug"); // Add some elements to the Arraylist
		someJavaStudents.add("Boris");
		someJavaStudents.add("Frank");
		someJavaStudents.add("Cody");
		someJavaStudents.add("John");

		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		// Loop through the Arraylist and display the elements in it
		// .size() returns the number of element in an arraylist
		// for an array .length() works
		// .get() returns the element at the specified index in the ArrayList
		// Elements will come out based on how they were entered
		// If you want to do something with an object add a . to it

		for (int i = 0; i < someJavaStudents.size(); i++) {
			System.out.println("elemtent #" + i + ". " + someJavaStudents.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		someJavaStudents.add(3, "Seth");
		
		// insert Seth at index 3 and moved everyone else down, you can't do this with an array
		// you can also remove elements from these with .remove()
		for (int i = 0; i < someJavaStudents.size(); i++) {
			System.out.println("element #" + i + ". " + someJavaStudents.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");
		
		
		
		someJavaStudents.remove(someJavaStudents.indexOf("Frank")); // removes Frank from the list without having to use the index
		
		for (int i = 0; i < someJavaStudents.size(); i++) {
			System.out.println("element #" + i + ". " + someJavaStudents.get(i));
		}

		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");
		
		if (someJavaStudents.contains("Doug")) {
			System.out.println("He's in the list");
		} else {
			System.out.println("He's not in the list");
		}

		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		System.out.println("Brendan is index: " + someJavaStudents.indexOf("Brendan"));

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		// .toArray(new array-specifications) can turn a list into an Array
		
		
		String[] javaStudents = new String[someJavaStudents.size()]; //
		
		for (int i = 0; i < someJavaStudents.size(); i++) {
			javaStudents[i] = someJavaStudents.get(i);
		}

		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		// The ForEach loop always goes from the start of the collection to the end
		// Unlike a forloop where you can stop wherever we want
		// Must start at beginning and end at end-index 
		// You can't skip elements

		// for (datatype anElementName : collection-name)
		// go through the loop one element at a time from the start to the end
		// each time through the loop the current element will be stored in the element name specified
		// use the element name to access the current element in the loop

		// for each loop
		for (String aStudent : someJavaStudents) {
			System.out.println("element in the arraylist " + aStudent);
		}

		// Process the ArrayList using a regular for-loop
		for (int i = 0; i < someJavaStudents.size(); i++) {
			System.out.println("element #"+i+": "+someJavaStudents.get(i));
		}


	}
}
