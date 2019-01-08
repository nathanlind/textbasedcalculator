import java.util.Scanner;

/**
 * TextBasedCalculator returns various calculation results
 * based on user input via the command line.
 * @author Nathan Lindsey
 * @version 1.0.0
 * date September 24 2018
 */
public class TextBasedCalculator {

	private static double operand1 = 0;
	private static double operand2 = 0;
	private static Scanner commandScanner = new Scanner(System.in);
	private static Calculator calculator = Calculator.getInstance();

	/**
	 * getOperands: Calls the getUserInput() method to get values to send to the calculator.
	 * @return nothing
	 */
	private static void getOperands() {
        System.out.print("Enter first number: ");
        operand1 = getUserInput();
        System.out.print("Enter second number: ");
        operand2 = getUserInput();
	}

    /**
     * getUserInput: Gets user input as string.  Checks for special commands such as PI,
     * MEM, or E and calls the appropriate methods to handle them.
     * @return A double containing a value based on user input.
     */
	private static double getUserInput() {
		try {
			String input = commandScanner.nextLine();
			input = input.trim().toUpperCase();
			if (input.equals("PI") || input.equals("MEM")) {
				return handlePiOrMem(input);
			} else if (input.equals("E")) {
				return handleSciNotation(input);
			}
			return Double.parseDouble(input);
		} catch (NumberFormatException e) {
			System.out.println("Error - Please enter a number, MEM, PI, or E:");
			return getUserInput();
		}
	}

    /**
     * handlePiOrMem: Handles user input of PI or MEM as a value. Returns Math.PI for PI
     * or the value saved in calculator's memory for MEM.
     * @param input A string containing user input from command line.
     * @return A double containing a value based on user input
     */
	private static double handlePiOrMem(String input) {
		if (input.equals("PI")) {
			return Math.PI;
		} else if (input.equals("MEM")) {
			System.out.printf("%s recalled from memory. \n\n", calculator.getMemoryValue());
			return calculator.getMemoryValue();
		}
		return Double.parseDouble(input);
	}

    /**
     * handleSciNotation: Handles user input of E for scientific notation.  Calls the
     * getSciNotationInput() method to get base value and power of E.
     * @param input A string containing user input from command line.
     * @return A double containing the result of scientific notation.
     */
	private static double handleSciNotation(String input) {
		if (input.equals("E")) {
			System.out.println("SCIENTIFIC NOTATION: Enter base number (PI or MEM may be used): ");
			double baseNumber = getSciNotationInput();
			System.out.println("Enter power of 10 (PI or MEM may be used): ");
			double powerOfTen = getSciNotationInput();
			return baseNumber * (calculator.exponent(10, powerOfTen));
		}
		return Double.parseDouble(input);
	}

	/**
	 * getSciNotationInput: Gets user input for scientific notation.  Used in this case
     * instead of getUserInput() to avoid repeated inputs of E.
	 * @return A double containing a value based on user input.
	 */
	private static double getSciNotationInput() {
		try {
			String input = commandScanner.nextLine();
			input = input.trim().toUpperCase();
			if (input.equals("PI") || input.equals("MEM")) {
				return handlePiOrMem(input);
			}
			return Double.parseDouble(input);
		} catch (NumberFormatException e) {
			System.out.println("Error - Please enter a number, PI, or MEM.");
			return getSciNotationInput();
		}
	}

	/**
	 * main is the main method
	 * @param args an array of words passed in via the command line
	 * @return nothing
	 */
	public static void main(String[] args) {

		String command = "";

		System.out.println("Type ON to begin.");

		do {
			command = commandScanner.nextLine();
			command = command.trim().toUpperCase();
		} while (!command.equals("ON"));
		
		System.out.println("**Welcome to TEXT BASED CALCULATOR.**");
		
		do {
			System.out.println("\nEnter command or type HELP to see options.");
			
			command = commandScanner.nextLine();
			command = command.trim().toUpperCase();

			if (command.equals("ADD")) {
				getOperands();
				System.out.println(calculator.add(operand1, operand2));
				
			} else if (command.equals("SUBTRACT")) {
				getOperands();
				System.out.println(calculator.subtract(operand1, operand2));
				
			} else if (command.equals("MULTIPLY")) {
				getOperands();
				System.out.println(calculator.multiply(operand1, operand2));
				
			} else if (command.equals("DIVIDE")) {
				getOperands();
				System.out.println(calculator.divide(operand1, operand2));
				
			} else if (command.equals("MODULO")) {
				getOperands();
				System.out.println(calculator.modulo(operand1, operand2));
				
			} else if (command.equals("EXPONENT")) {
				getOperands();
				System.out.println(calculator.exponent(operand1, operand2));
				
			} else if (command.equals("ROOT")) {
				getOperands();
				System.out.println(calculator.root(operand1, operand2));
				
			} else if (command.equals("SAVE")) {
				calculator.setMemoryValue(calculator.getCalculationResult());
				System.out.printf("%s saved to memory. \n\n", calculator.getMemoryValue());
				
			} else if (command.equals("PRINT")) {
				calculator.printLogs();
				
			} else if (command.equals("HELP")) {
				System.out.println("\n**TEXT BASED CALCULATOR COMMANDS** \n\nADD \nSUBTRACT"
						+ "\nMULTIPLY \nDIVIDE \nMODULO (Returns the remainder after division.)"
						+ "\nEXPONENT (Raise first number to power of second number.) \nROOT (Returns nth root of first number by second number.)"
                        + "\n\nPRINT returns a log of all actions performed and the current value saved to memory."
						+ "\nSAVE saves the last result to memory. "
						+ "\nMEM may be entered as a value to recall previously saved result. "
                        + "\nPI may be entered as a value. "
                        + "\nE may be entered as a value for scientific notation."
						+ "\nOFF to quit. \n\n**********************************");
			} else {
				System.out.println("Command not recognized.");
			}

		} while (!command.equals("OFF"));
		
		System.out.println("\n**Thank you for using TEXT BASED CALCULATOR.**");

		commandScanner.close();
		
	}

}
