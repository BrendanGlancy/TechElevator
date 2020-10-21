package com.techelevator;

/**************************************************************************
* Day 14 Unit testing
*
* Consider having only these three files open
***************************************************************************/

public class Lecture {

    /*
    1. Return the created array
    */
	// datatype for an array includes []
	//     return
	//      type  name      (parameters)
    public int[] returnArray() {
        int[] array = { 80, 8080, 443 };
        return array;
    }

    /*
    2. Return the first element of the array
    */
    public int returnFirstElement() {
        int[] portNumbers = { 80, 8080, 443 };
        return portNumbers[0];  // First element is at index 0
    }

    /*
    3. Return the last element of the array
    */
    public int returnLastElement() {
        int[] portNumbers = { 80, 8080, 443};
 //       return portNumbers[2];  // last element in a 3-element array is at index 2
 //       return portNumbers[portNumbers.length-1];  // index of the last element 
                                                     //   is always the arrayname.length-1
        	int lastIndex = portNumbers.length-1;    // Store the highest index value in a varaible
            return portNumbers[lastIndex];           // Use the variable as index
    }

    /*
    4. Return the first element of the array from the parameters
    */
    //                               array passed as a parameter
    //                                   data
    //                                   type  name-to-use-in-method
    public int returnFirstElementOfParam(int[] passedInArray) {
        return passedInArray[0];  // Index of the first element is always 0
    }

    /*
    5. Return the last element of the array from the parameters
    */
    public int returnLastElementOfParam(int[] passedInArray) {
        return passedInArray[passedInArray.length - 1];  // index of the last element 
                                                         //   is always the arrayname.length-1
    }

    /*
    6. Here, a variable is defined within a block. How can we get the value of that outside of the block in order to
       return it? There are a couple of different ways of doing this, what can you come up with?
    */
    public int returnVariableFromBlock(int number) {

        { // A new block with scoped variables

            int result = number * 5;

        } // the result variable disappears here

        return number; // We want to return result here. How?
    }

    /*
    7. What will the variable result be at the end of the method? Change the number in the logic expression so that
       it returns true.
    */
    public boolean returnOperationInBlock() {
        int result = 5;

        {
            int multiplier = 10;
            result *= multiplier;
        }

        return result == 1; // <-- Change the number to match result and make this be true
    }

    /*
    8. Return the only variable that is in scope at the return statement.
    */
    public double returnInScopeVariable() {
        double one = 1.0;
        {
            double three = 3.0;
            one += three;
            {
                double four = 4.0;
                three = four - one;
                one++;
            }

            double five = 5.0;
            double eight = five + three;
        }

        return 0;
    }

    /*
    9. How many times do we go through this loop? 
       Change the number in the logic expression so that it returns true.
    */
    public boolean returnCounterFromLoop() {

        int[] arrayToLoopThrough = { 3, 4, 2, 9 };

        int counter = 0; // Must be started outside the block so that have access to it after the block
        //       4                          4
        for (int i = 0; i < arrayToLoopThrough.length; i++) {
            counter++;   // 4
        }

        return counter == 4; // What should the number be to return true?
    }

    /*
    10. This loop is counting incorrectly.
        What needs to change in the loop for it to count properly?
    */
    public boolean returnCorrectCount() {
        int[] arrayToLoopThrough = { 4, 23, 9 };

        int counter = 0;

        //     Start;       Keep going while         Increment by one;
        for (int i = 0; i < arrayToLoopThrough.length; i++) {
            counter += 1;
        }

        return counter == 3;
    }

    /*
    11. This loop is counting incorrectly. 
        What needs to change in the loop for it to count properly?
    */
    public boolean returnCountCorrectTimes() {
        int[] arrayToLoopThrough = { 4, 23, 9, 4, 33 };

        int counter = 0;

        //     Start;       Keep going while         Increment by one;
        for (int i = 0; i < arrayToLoopThrough.length; i++) {
            counter = counter + 1;
        }

        return counter == 5;
    }

    /*
    12. We want this loop to only count every other item starting at zero. 
        What needs to change in the loop for it to do that?
    */
    public boolean returnSumEveryOtherNumber() {
    	//                          [0][1][2][3][4][5]
        int[] arrayToLoopThrough = { 4, 3, 4, 1, 4, 6 };

        int sum = 0;

        //     Start;       Keep going while       Increment by;
        for (int i = 0; i < arrayToLoopThrough.length; i = i + 2) {  // i=0, 2, 4, 6
            sum = sum + arrayToLoopThrough[i];
        }

        return sum == 12;
    }
}