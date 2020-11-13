package com.techelevator;

/**************************************************************************
* Day 14 Unit testing
*
* Consider having only these three files open
***************************************************************************/

public class Lecture {
    /*
    1. This method is named returnNotOne and it returns an int. Change
    it so that it returns something other than a 1.
    */
    public int returnNotOne() {
        return 0;  // return this value
    }

    /*
    2. This method is named returnNotHalf and it returns a double. Change
    it so that it returns something other than a 0.5.
    */
    public double returnNotHalf() {
        return 7 / 2;   // return 3.0 - not .5  int 7 / int 2 - result int 3 - convert to double 3.0
    }

    /*
    3. This method needs to return a String. Fix it to return a valid String.
    */
    public String returnName() {
    	String aString = "Frank";
        return aString;
    }
    /*
    4. This method currently returns an int. Change it so that it returns a double.
    */
    public double returnDoubleOfTwo() {  // changed return type from int to double
        return 2;
    }

    /*
    5. This method should return the language that you're learning. Change
    it so that it does that.
    */
    public String returnNameOfLanguage() {
        return "Java";
    }

    /*
    6. This method uses an if statement to define what to return. Have it
    return true if the if statement passes.
    
    format-1 of if:  if (logical-condition) {
    	                 statements to be done if condition is true
    	             }
    	
    format-2 of if:  if (logical-condition) {
    	                 statements to be done if condition is true
    	             }
    	             else {
    	                  statements to be done if condition is false
    	             }
    
    */
    public boolean returnTrueFromIf() {
        if (true) {
            return true;   // return terminate the method - doesn't continue
        }
        // get to this point if the if false because there is not else
        return false;
    /*
     * Alternate solution
     
       if (true) {
            return true;
       }
       else {
         	return false;
       }
     */
    }

    /*
    7. This method uses an if to check to make sure that one is equal
    to one. Make sure it returns true when one equals one.
    
    in Java equals to is == (not =)
    
    */
    public boolean returnTrueWhenOneEqualsOne() {
        if (1 == 1) {
            return true;
        }

        return false;
    }

    /*
    8. This method checks a parameter passed to the method to see if it's
    greater than 5 and returns true if it is.
    */
//  access  return
// modifier type    method-name                 (parameters)    
    public boolean returnTrueWhenGreaterThanFive(int number) {
        if (number > 5) {  // use the parameter in the code for method
        	return true;
        } else {
            return false;
        }
/* alternate solution
        return (number > 5); // return the result of number > 5 (true or false)
*/
/* alternate solution
        return (number > 5 ? true : false); // return the result of number > 5 (true or false)
*/
    }

    /*
    9. If you think about it, we really don't need the if statement above.
    How can we rewrite exercise 8 to have only one line of code?
    */
    public boolean returnTrueWhenGreaterThanFiveInOneLine(int number) {
        return number > 5; // What can we put here that returns a boolean that we want?
    }

    /*
    10. This method will take a number and do the following things to it:
    * If addThree is true, we'll add three to that number
    * If addFive is true, we'll add five to that number
    * We'll then return the result
    */
    //                                                 16         true              false
    //                                                 16         false             true
    public int returnNumberAfterAddThreeAndAddFive(int number, boolean addThree, boolean addFive) {
    	
    	if (addThree) {          // if (addThree == true) is ok
            number = number + 3; // += is OK
        }

        // We can't use an else here. They could both be true, so we have to check each one.

        if (addFive) {           // if (addFive == true) is ok
            number += 5;         // number + 5 is OK instead +=
        }

        return number;
    }

    /*
    11. Write an if statement that returns "Fizz" if the parameter is 3 
               and returns an empty String for anything else.
    */
    public String returnFizzIfThree(int number) {
    	if (number == 3) {
    		return "Fizz";
    	}
        return "";
    }

    /*
    12. Now write the above using the Ternary operator ?:. If you're not sure what this is, you can Google it.
        
       	It's the only operator with three operands, hence the ternary operator
        
        condition ? result-if-true : result-false
        
        short hand for if-else statement - thing of the : as else
        
        used when you need one of two results and you can't code an if
    */
    public String returnFizzIfThreeUsingTernary(int number) {
        return (number == 3) ? "Fizz" : "";
    }
    /*
    13. Write an if/else statement that returns "Fizz" if the parameter is 3,
                                                "Buzz" if the parameter is 5 
                                                 and an empty String for anything else.
    */
    public String returnFizzOrBuzzOrNothing(int number) { 	
    	if (number == 3) {
    		return "Fizz";
    	}
    	if (number == 5) {
    		return "Buzz";
    	}    	
        return "";
    /*
     if (number == 3) {
    		return "Fizz";
    	}
    	else {
    	     if (number == 5) {
    		    return "Buzz";
    	     }    	
            else {
                  return "";
            }
        }
     */
    }

    /*
    14. Write an if statement that checks if the parameter number is either equal to or greater than 18. Return "Adult" if it is or "Minor" if it's not.
    */
    public String returnAdultOrMinor(int number) {
        if (number >= 18 ) {
            return "Adult";
        } else {
            return "Minor";
        }
    }

    /*
    15. Now, do it again with a different boolean opertion.
    */
    public String returnAdultOrMinorAgain(int number) {
        if (number == 18 || number > 18) {  // Logical or ||
            return "Adult";
        } else {
            return "Minor";
        }
    }

    /*
    16. Return as above, but also return "Teen" 
         if the number is between 13 and 17 inclusive.
    */
    public String returnAdultOrMinorOrTeen(int number) {
        if (number == 18 || number > 18) {
            return "Adult";
        } else if (number < 18 && number > 12) {  // Logical &&
            return "Teen";
        } else {
            return "Minor";
        }
    }

}