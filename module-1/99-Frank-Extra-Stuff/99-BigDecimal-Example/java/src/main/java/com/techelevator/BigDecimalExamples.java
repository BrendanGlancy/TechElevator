package com.techelevator;

import java.math.BigDecimal;  // import BigDecimal class
import java.math.RoundingMode;

public class BigDecimalExamples {

	public static void main(String[] args) {
/********************************************************************************************
 * BigDecimal is an alternate to double
 * 
 * BigDecimal does not have the precision issues that double has
 * 
 * BigDecimal is a good choice for money fields as precision is not lost
 *                 (double tends to be good for all other uses)
 * 
 * BigDecimal objects are initialized using String values
 * 
 * BigDecimal can be difficult to use and has it's own issues:
 * 
 *        Arithmetic and rounding are cumbersome
 *        BigDecimal operations are slower
 *        Most BigDecimal methods require BigDecimal arguments (i.e no int, double, etc)
 ******************************************************************************************** 	
 */
		BigDecimal aNum = new BigDecimal("19.95");   // Instantiate BigDecimal from a String
		BigDecimal bNum = new BigDecimal("-19.95");  // Instantiate BigDecimal from a String
		BigDecimal two  = new BigDecimal("2");       // Instantiate BigDecimal from a String
	  
		System.out.println("aNum = " + aNum); // BigDecimal will convert to a String
		System.out.println("bNum = " + bNum); // BigDecimal will convert to a String
		System.out.println("------------------------------------------------");
		System.out.println("            aNum.equals(bNum) is: " + aNum.equals(bNum)); 
		System.out.println("       aNum.eauals(bNum.abs() is: " + aNum.equals(bNum.abs())); 
		System.out.println("              aNum.toString() is: " + aNum.toString()); 
		System.out.println("         aNum.aNum.intValue() is: " + aNum.intValue());
		System.out.println("           aNum.doubleValue() is: " + aNum.doubleValue());
		System.out.println("               aNum.add(bNum) is: " + aNum.add(bNum));
		System.out.println(" aNum.add(new BigDecimal(\"1\") is: " + aNum.add(new BigDecimal("1")));
		System.out.println("          aNum.subtract(bNum) is: " + aNum.subtract(bNum));
		System.out.println("          aNum.multiply(bNum) is: " + aNum.multiply(bNum));
		System.out.println("            aNum.divide(bNum) is: " + aNum.divide(bNum));
		System.out.println("                  aNum.pow(2) is: " + aNum.pow(2));
		System.out.println("------------------------------------------------");	
		System.out.println("  aNum.setScale(1,RoundingMode.DOWN is: " + aNum.setScale(1,RoundingMode.DOWN));
		System.out.println("  aNum.setScale(1,RoundingMode.UP   is: " + aNum.setScale(1,RoundingMode.UP));

		System.out.println("------------------------------------------------");	
		aNum = new BigDecimal("19.46");
		System.out.println("aNum = " + aNum); // BigDecimal will convert to a String
		System.out.println("  aNum.setScale(1,RoundingMode.DOWN is: " + aNum.setScale(1,RoundingMode.DOWN));
		System.out.println("  aNum.setScale(1,RoundingMode.UP   is: " + aNum.setScale(1,RoundingMode.UP));
		
	}

}
