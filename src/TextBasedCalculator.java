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
	 * Calls the inputValue1 and inputValue2 methods
	 */
	private static void getOperands() {
        System.out.print("Enter first number: ");
        operand1 = inputValue();
        System.out.print("Enter second number: ");
        operand2 = inputValue();

	}

    /**
     * Gets user input for as string.  If user input is valid,
     * calls the checkForSpecial method.
     * @return A double containing a value based on user input.
     */
	private static double inputValue() {
		try {
			String input = commandScanner.nextLine();
			input = input.trim().toUpperCase();
			return checkForSpecial(input);
		}

		catch (NumberFormatException e) {
			System.out.println("Error - Please enter a number, MEM, or PI:");
			return inputValue();
		}
	}

    /**
     * Gets user input for scientific notation.  Used instead of inputValue()
     * to avoid recursive scientific notation calls.
     * @return A double containing a value based on user input.
     */
	private static double sciNotationInput() {
        try {
            String input = commandScanner.nextLine();
            input = input.trim().toUpperCase();
            return Double.parseDouble(input);
        }

        catch (NumberFormatException e) {
            System.out.println("Error - Please enter a number.");
            return sciNotationInput();
        }
    }

    /**
     *
     * @param valueCheck A string for the user input to be checked for special commands.
     * @return A double containing a value based on user input.
     */
	private static double checkForSpecial(String valueCheck) {
		if (valueCheck.equals("PI")) {
			return Math.PI;
		} else if (valueCheck.equals("MEM")) {
			System.out.printf("%s recalled from memory. \n\n", calculator.getMemoryValue());
			return calculator.getMemoryValue();
		} else if (valueCheck.equals("E")) {
		    System.out.println("SCIENTIFIC NOTATION: Enter base number: ");
		    double baseNumber = sciNotationInput();
		    System.out.println("Enter power of 10: ");
		    double powerOfTen = sciNotationInput();
		    return baseNumber * (calculator.raisePower(10, powerOfTen));
        }
		return Double.parseDouble(valueCheck);
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
				System.out.println(calculator.raisePower(operand1, operand2));
				
			} else if (command.equals("ROOT")) {
				getOperands();
				System.out.println(calculator.root(operand1, operand2));
				
			} else if (command.equals("SAVE")) {
				calculator.setMemoryValue(calculator.getCalculationResult());
				System.out.printf("%s saved to memory. \n\n", calculator.getMemoryValue());
				
			} else if (command.equals("LOG")) {
				calculator.printLogs();
				
			} else if (command.equals("HELP")) {
				System.out.println("\n**TEXT BASED CALCULATOR COMMANDS** \n\nADD \nSUBTRACT"
						+ "\nMULTIPLY \nDIVIDE \nMODULO (Returns the remainder after division.)"
						+ "\nEXPONENT (Raise first number to power of second number.) \nROOT (Returns nth root of first number by second number.)"
                        + "\n\nLOG returns a log of all actions performed."
						+ "\n\nSAVE saves the last result to memory. "
						+ "\nMEM may be entered as a value to recall previously saved result. "
                        + "\n\nPI may be entered as a value. "
                        + "\n\nE may be entered as a value for scientific notation."
						+ "\n\nOFF to quit. \n**********************************");
			} else {
				System.out.println("Command not recognized.");
			}

		} while (!command.equals("OFF"));
		
		System.out.println("\n**Thank you for using TEXT BASED CALCULATOR.**");

		commandScanner.close();
		
	}

}
