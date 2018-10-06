import java.lang.Math;
import java.util.Scanner;

/**
 * The Calculator class is used by the TextBasedCalculator class
 * to perform calculations and handle input of values used in calculations.
 * @author Nathan Lindsey
 * @version 1.0.0
 * date September 24 2018
 */
public class Calculator {
	
	private double calculationValue1 = 0;
	private double calculationValue2 = 0;
	private double calculationResult = 0;
	private double memoryValue = 0;
	private Scanner valueScanner = new Scanner(System.in);
	
	
	public Calculator() {
		
	}
	

	private void getValues() {
		inputValue1();
		inputValue2();
	}
	
	private void inputValue1() {
		System.out.print("Enter first number: ");

		try {
		String input = valueScanner.nextLine();
		input = input.trim().toUpperCase();
		calculationValue1 = checkForSpecial(input);
		}

		catch (NumberFormatException e) {
			System.out.println("Error - Please enter a number, MEM, or PI:");
			inputValue1();
		}
	}
	
	private void inputValue2() {
		System.out.print("Enter second number: ");

		try {
		String input = valueScanner.nextLine();
		input = input.trim().toUpperCase();
		calculationValue2 = checkForSpecial(input);
		}

		catch (NumberFormatException e) {
			System.out.println("Error - Please enter a number, MEM, or PI:");
			inputValue2();
		}
	}

	private double checkForSpecial(String valueCheck) {
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
		calculationResult = calculationValue1 + calculationValue2;
		return calculationResult;
	}
	
	public double subtract() {
		getValues();
		calculationResult = calculationValue1 - calculationValue2;
		return calculationResult;
	}
	
	public double multiply() {
		getValues();
		calculationResult = calculationValue1 * calculationValue2;
		return calculationResult;
	}
	
	public double divide() {
		getValues();
		if (calculationValue2 == 0) { //Checks if user is trying to divide by zero.
			System.out.println("Error: unable to divide by zero.");
			calculationResult = 0;
			return calculationResult;
		} else {
			calculationResult = calculationValue1 / calculationValue2;
			return calculationResult;
		}
	}

	public double modulo() {
		getValues();
		calculationResult = calculationValue1 % calculationValue2;
		return calculationResult;
	}
	
	public double raisePower() {
		getValues();
		calculationResult = Math.pow(calculationValue1, calculationValue2);
		return calculationResult;
	}

	public double root() {
		getValues();
		calculationResult = Math.pow(calculationValue1, (1 / calculationValue2));
		return calculationResult;
	}
	
	
	/**
	 * Gets the first value to be used in calculations.
	 * @return A double for the first user value.
	 */
	public double getCalculationValue1() {
		return calculationValue1;
	}
	
	/**
	 * Gets the second value to be used in calculations.
	 * @return A double for the second user value.
	 */
	public double getCalculationValue2() {
		return calculationValue2;
	}

	/**
	 * Gets the calculationResult of the most recent calculations.
	 * @return calculationResult A double for the calculationResult of calculations.
	 */
	public double getCalculationResult() {
		return calculationResult;
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
	 * @param memoryValue A double for the value to be stored in memory.
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
