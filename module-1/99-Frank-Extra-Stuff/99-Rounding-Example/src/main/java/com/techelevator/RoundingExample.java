package com.techelevator;

import java.text.DecimalFormat;   // Includes the necessary code to use the DecimalFormat class


public class RoundingExample 
{
    public static void main( String[] args )
    {
    /*
    10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
    */
        		
    double quarter = .25;
    double dime    = .10;
    double nickels = .05;
    
    double moneyFound = quarter + dime + (nickels * 2);  // should be .45
    
    System.out.println("moneyFound with no formatting: " + moneyFound);
    
    System.out.println("-------------------------------------------------------");
    /*
     * The printf() function can be used to round and format decimal values for display
     * 
     * Syntax: 
     *  
     *     printf("model of line to be displayed with placeholders for values (%-words)", values-for-placeholder);
     *     
     *     placeholders identify the datatype and formatting for values to be placed in the line.
     *     common placeholders are:
     *     
     *     %.nf - numeric value with n-decimal places - %.2f indicates a 2-decimal place value
     *     %nd  - numeric integer with n-digits - %3d - indicates a 3-digit integer
     *     %ns  - n-character string - %10s indicates a 10 character string
     *     %nS  - n-character string converted to uppercase - %10S indicates a 10 character string converted to uppercase
     *     
     *     Note: in all the above examples 'n' is the minimum size
     *     
     *     The number of values provided must match the number of placeholders in the model line to avoid errors
     *     
     *     Link to quick reference for printf(): 
     *     
     *        https://www.cs.colostate.edu/~cs160/.Summer16/resources/Java_printf_method_quick_reference.pdf
     *     
     */
    
   // Use printf() to display moneyFound with 2 rounded decimal places 
    
    System.out.printf("moneyFound with formatting via printf: %.2f\n", moneyFound);
    
    System.out.println("-------------------------------------------------------");  
  /*
   * The DecimalFormat class can be used to define an object containing how a numeric value
   * should be formatted.
   * 
   * The object can then be used with the format() method to format a value
   * 
   * You must import the java.text.DecimalFormat class to use DecimalFormat
   * 
   * To use DecimalFormat:
   * 
   * 1. Define a new DecimalFormat object passing it a string representing the desired format.
   *    Put # where you want a digit and any editing characters desired (, .) in the place you want them.
   *    
   * 2. Use the DecimalFormat object your created in #1 to invoke the format() method passing it the vale
   *    to be formatted.
   *    
   * 3. The format() method returns a string with the value passed formatted as indicated in the DecimalFormat object.
   * 
   * Note: The value passed to format() is unchanged.
   * 
   * Link to more on DecimalFormat: https://www.baeldung.com/java-decimalformat
   */
    
    DecimalFormat myFormat = new DecimalFormat("###.##");  // Define the format you want 
                                                           // # is where you want a digit - . is where you want the decimal point
                                                           // Google java DecimalFormat for more
                                                           // baeldung.com usually has good explanations and examples
    
    System.out.print("moneyFound with rounding via DecimalFormat: " );
    
    System.out.println(myFormat.format(moneyFound));       // Use the format you defined 
                                                            //    with the format method and the value
   
    System.out.println("-------------------------------------------------------");  
        
   }
}
