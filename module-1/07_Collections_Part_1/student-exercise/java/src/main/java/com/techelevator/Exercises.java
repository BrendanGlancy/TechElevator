package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exercises {

	/*
	 Note, for-each is preferred, and should be used when possible.
	 */

	/*
	 Given an array of Strings, return an ArrayList containing the same Strings in the same order
	 array2List( {"Apple", "Orange", "Banana"} )  ->  ["Apple", "Orange", "Banana"]
	 array2List( {"Red", "Orange", "Yellow"} )  ->  ["Red", "Orange", "Yellow"]
	 array2List( {"Left", "Right", "Forward", "Back"} )  ->  ["Left", "Right", "Forward", "Back"]
	 */
	public List<String> array2List(String[] stringArray) {
		List<String> list = new ArrayList<String>(); // create new ArrayList and iterate through it adding elements from stringArray
		for (String text:stringArray) {
			list.add(text); 
		}
		return list;
	}

	/*
	 Given a list of Strings, return an array containing the same Strings in the same order
	 list2Array( ["Apple", "Orange", "Banana"] )  ->  {"Apple", "Orange", "Banana"}
	 list2Array( ["Red", "Orange", "Yellow"] )  ->  {"Red", "Orange", "Yellow"}
	 list2Array( ["Left", "Right", "Forward", "Back"] )  ->  {"Left", "Right", "Forward", "Back"}
	 */
	public String[] list2Array(List<String> stringList) {
		String[] itemArray = new String[stringList.size()]; // new array
		itemArray = stringList.toArray(itemArray); // Our string list to an Array
		return itemArray;
	}

	/*
	 Given an array of Strings, return an ArrayList containing the same Strings in the same order
	 except for any words that contain exactly 4 characters.
	 no4LetterWords( {"Train", "Boat", "Car"} )  ->  ["Train", "Car"]
	 no4LetterWords( {"Red", "White", "Blue"} )  ->  ["Red", "White"]
	 no4LetterWords( {"Jack", "Jill", "Jane", "John", "Jim"} )  ->  ["Jim"]
	 */
	public List<String> no4LetterWords(String[] stringArray) {
		List<String> noFour = new ArrayList<String>();
		
		for (int i = 0; i < stringArray.length; i++) {  // loop through the array of Strings 
			if(stringArray[i].length() != 4) { // if the element != 4 add it to the ArrayList
				noFour.add(stringArray[i]);
			}
		}
		return noFour;
	}

	/*
	 Given an array of ints, divide each int by 2, and return an ArrayList of Doubles.
	 arrayInt2ListDouble( {5, 8, 11, 200, 97} ) -> [2.5, 4.0, 5.5, 100, 48.5]
	 arrayInt2ListDouble( {745, 23, 44, 9017, 6} ) -> [372.5, 11.5, 22, 4508.5, 3]
	 arrayInt2ListDouble( {84, 99, 3285, 13, 877} ) -> [42, 49.5, 1642.5, 6.5, 438.5]
	 */
	public List<Double> arrayInt2ListDouble(int[] intArray) {
		List<Double> halfArray = new ArrayList<Double>(intArray.length);
		for (double i : intArray) { // go through the ArrayList and divide everything in half
			
			halfArray.add(i/2); // add it to the double list
		}
		return halfArray;
	}

	/*
	 Given a List of Integers, return the largest value.
	 findLargest( [11, 200, 43, 84, 9917, 4321, 1, 33333, 8997] ) -> 33333
	 findLargest( [987, 1234, 9381, 731, 43718, 8932] ) -> 43718
	 findLargest( [34070, 1380, 81238, 7782, 234, 64362, 627] ) -> 64362
	 */
	public Integer findLargest(List<Integer> integerList) {
		return Collections.max(integerList); // return the max from integer list
	}

	/*
	 Given an array of Integers, return a List of Integers containing just the odd values.
	 oddOnly( {112, 201, 774, 92, 9, 83, 41872} ) -> [201, 9, 83]
	 oddOnly( {1143, 555, 7, 1772, 9953, 643} ) -> [1143, 555, 7, 9953, 643]
	 oddOnly( {734, 233, 782, 811, 3, 9999} ) -> [233, 811, 3, 9999]
	 */
	public List<Integer> oddOnly(Integer[] integerArray) {
		List<Integer> odds = new ArrayList<Integer>(integerArray.length); // create array list
		
		for (int i = 0; i < integerArray.length; i++) { // go through the whole array
			if (integerArray[i] % 2 == 1) { // if it's odd add it to the array
				odds.add(integerArray[i]);
			}  
		}
		return odds;
	}

	/*
	 Given a List of Integers, and an int value, return true if the int value appears two or more times in
	 the list.
	 foundIntTwice( [5, 7, 9, 5, 11], 5 ) -> true
	 foundIntTwice( [6, 8, 10, 11, 13], 8 -> false
	 foundIntTwice( [9, 23, 44, 2, 88, 44], 44) -> true
	 */
	public boolean foundIntTwice(List<Integer> integerList, int intToFind) {
		int count = 0; // define an int to keep track of how many times a number occurs
	    for (int num : integerList) {
	        if (num == intToFind) {
	            count ++; // count increase if a number occurs
	            if (count == 2) { // return true if a number occurs twice
	                return true;
	            }
	        }
	    }
	    return false; // else return false
	}

	/*
	 Given an array of Integers, return a List that contains the same Integers (as Strings). Except any multiple of 3
	should be replaced by the String "Fizz", any multiple of 5 should be replaced by the String "Buzz",
	and any multiple of both 3 and 5 should be replaced by the String "FizzBuzz"
	** INTERVIEW QUESTION **
	
	fizzBuzzList( {1, 2, 3} )  ->  [1, 2, "Fizz"]
	 fizzBuzzList( {4, 5, 6} )  ->  [4, "Buzz", 6]
	 fizzBuzzList( {7, 8, 9, 10, 11, 12, 13, 14, 15} )  ->  [7, 8, "Fizz", "Buzz", 11, "Fizz", 13, 14, "FizzBuzz"]
	
	 HINT: To convert an integer x to a string you can call x.toString() in your code (e.g. if x = 1 then x.ToString()
	 equals "1")
	 */
	public List<String> fizzBuzzList(Integer[] integerArray) {
		List<String> fizzBuzz = new ArrayList<String>();
		for (int i = 0; i < integerArray.length; i++) {
			if (integerArray[i] % 3 == 0 && integerArray[i] % 5 == 0) { // Divisible by 3 and 5 fizzBuzz
				fizzBuzz.add("FizzBuzz");
			} else if (integerArray[i] % 5 == 0) { // divisible by 5
				fizzBuzz.add("Buzz");
			} else if (integerArray[i] % 3 == 0) { // divisible by 3
				fizzBuzz.add("Fizz");
			} else if (integerArray[i] % 5 != 0 && integerArray[i] % 3 != 0) { // neither
				fizzBuzz.add(integerArray[i] + "");
			}
		}
		return fizzBuzz;
	}

	/*
	 Given two lists of Integers, interleave them beginning with the first element in the first list followed
	 by the first element of the second. Continue interleaving the elements until all elements have been interwoven.
	 Return the new list. If the lists are of unequal lengths, simply attach the remaining elements of the longer
	 list to the new list before returning it.
	 interleaveLists( [1, 2, 3], [4, 5, 6] )  ->  [1, 4, 2, 5, 3, 6]
	 */
	public List<Integer> interleaveLists(List<Integer> listOne, List<Integer> listTwo) {
		
		int i = -1;
	    for(Integer elem: listTwo) {
	        if(i < listOne.size()-1) { // if the current index is less than - 1 the size of the list
	            i += 2; // add 2 to the current index
	        } else {
	            i += 1; // add 1 to the current index
	        }
	        listOne.add(i, elem); // adds i and the current element to listOne
	    }
	    return listOne;
	}
	}


