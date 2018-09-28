/**
 * The Calculator class is used by the TextBasedCalculator class
 * to perform calculations and handle input of values used in calculations.
 * @author Nathan Lindsey
 * @version 1.0.0
 * date September 24 2018
 */

import java.lang.Math;
import java.util.Scanner;

public class Calculator {
	
	private double value1 = 0;
	private double value2 = 0;
	private double result = 0;
	private double memoryValue = 0;
	private Scanner valueScanner = new Scanner(System.in);
	

	private void getValues() {
		inputValue1();
		inputValue2();
	}
	
	private void inputValue1() {
		System.out.print("Enter first number: ");
		
		try {
		String input = valueScanner.nextLine();
		input = input.trim().toUpperCase();
		value1 = checkForSpecial(input);
		}
		
		catch (NumberFormatException e) {
			System.out.println("Error: Please enter a number.");
			inputValue1();
		}
	}
	
	private void inputValue2() {
		System.out.print("Enter second number: ");
		
		try {
		String input = valueScanner.nextLine();
		input = input.trim().toUpperCase();
		value2 = checkForSpecial(input);
		}
		
		catch (NumberFormatException e) {
			System.out.println("Error: Please enter a number.");
			inputValue2();
		}
	}

	public double checkForSpecial(String valueCheck) {
		if (valueCheck.equals("PI")) {
			return Math.PI;
		} else if (valueCheck.equals("MEM")){
			System.out.printf("%s recalled from memory. \n\n", memoryValue);
			return memoryValue;
		}
			return Double.parseDouble(valueCheck);
	}
	
	
	
	public double add() {
		getValues();
		result = value1 + value2;
		return result;
	}
	
	public double subtract() {
		getValues();
		result = value1 - value2;
		return result;
	}
	
	public double multiply() {
		getValues();
		result = value1 * value2;
		return result;
	}
	
	public double divide() {
		getValues();
		if (value2 == 0) { //Checks if user is trying to divide by zero.
			System.out.println("Error: unable to divide by zero.");
			result = 0;
			return result;
		} else {
			result = value1 / value2;
			return result;
		}
	}

	public double modulo() {
		getValues();
		result = value1 % value2;
		return result;
	}
	
	public double raisePower() {
		getValues();
		result = Math.pow(value1,  value2);
		return result;
	}

	public double root() {
		getValues();
		result = Math.pow(value1, (1 / value2));
		return result;
	}
	
	
	/**
	 * Gets the first value to be used in calculations.
	 * @return A double for the first user value.
	 */
	public double getValue1() {
		return value1;
	}
	
	/**
	 * Gets the second value to be used in calculations.
	 * @return A double for the second user value.
	 */
	public double getValue2() {
		return value2;
	}

	/**
	 * Gets the result of the most recent calculations.
	 * @param result A double for the result of calculations.
	 */
	public double getResult() {
		return result;
	}
	
	/**
	 * Gets the memory value.
	 * @return A double containing the value saved in memory.
	 */
	public double getMemoryValue() {
		return memoryValue;
	}

	/**
	 * Sets the memory value.
	 */
	public void setMemoryValue(double memoryValue) {
		this.memoryValue = memoryValue;
	}

}

/*
} else if (valueCheck.substring((valueCheck.length() -1), valueCheck.length()).contains("e")) {
	System.out.print("Enter index of e: ");
	
	try {
		String input = commandScanner.nextLine();
		input.trim();
		double factorOfE = Double.parseDouble(input);
		double tempValue = Double.parseDouble(valueCheck.substring(0, (valueCheck.length() - 1)));
		return tempValue * (this.raisePower(10, factorOfE));
		}
		
		catch (NumberFormatException e) {
			System.out.print("Error: Please enter a number: ");
			String input = commandScanner.nextLine();
			input.trim();
			double factorOfE = Double.parseDouble(input);
			double tempValue = Double.parseDouble(valueCheck.substring(0, (valueCheck.length() - 1)));
			return tempValue * (this.raisePower(10, factorOfE));
		}
*/
