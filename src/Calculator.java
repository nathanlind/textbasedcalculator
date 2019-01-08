import java.util.ArrayList;

/**
 * The Calculator class is configured as a Singleton and is
 * used by the TextBasedCalculator class to perform calculations.
 * @author Nathan Lindsey
 * @version 1.0.0
 * date September 24 2018
 */
public final class Calculator {

    private static Calculator instance = new Calculator();
	private double calculationResult = 0;
	private double memoryValue = 0;
	private ArrayList<CalculationLog> actionLogs = new ArrayList<CalculationLog>();

    /**
     * Private constructor configuring the Calculator class as a Singleton.
     */
	private Calculator() {}

	/**
	 * add: Calculates the sum of two numbers and calls createLog() method to generate a log of this action.
	 * @param operand1 A double containing the first value to be used in calculation.
	 * @param operand2 A double containing the second value to be used in calculation.
	 * @return calculationResult A double containing the sum of operand1 & operand2.
	 */
	public double add(double operand1, double operand2) {
		calculationResult = operand1 + operand2;
		createLog(Operator.ADD, operand1, operand2);
		return calculationResult;
	}

	/**
	 * subtract: Calculates the difference of two numbers and calls createLog() method to generate a log of this action.
	 * @param operand1 A double containing the first value to be used in calculation.
	 * @param operand2 A double containing the second value to be used in calculation.
	 * @return calculationResult A double containing the difference of operand1 & operand2.
	 */
	public double subtract(double operand1, double operand2) {
		calculationResult = operand1 - operand2;
		createLog(Operator.SUBTRACT, operand1, operand2);
		return calculationResult;
	}

	/**
	 * multiply: Calculates the product of two numbers and calls createLog() method to generate a log of this action.
	 * @param operand1 A double containing the first value to be used in calculation.
	 * @param operand2 A double containing the second value to be used in calculation.
	 * @return calculationResult A double containing the product of operand1 & operand2.
	 */
	public double multiply(double operand1, double operand2) {
		calculationResult = operand1 * operand2;
		createLog(Operator.MULTIPLY, operand1, operand2);
		return calculationResult;
	}

	/**
	 * divide: Calculates the quotient of two numbers and calls createLog() method to generate a log of this action.
	 * If user attempts to divide by zero, the method will print an error message,
	 * set calculation result to 0, and no call to createLog will be made.
     * @param operand1 A double containing the value to be used as the dividend.
     * @param operand2 A double containing the value to be used as the divisor.
     * @return calculationResult A double containing the quotient of operand1 & operand2.
     */
	public double divide(double operand1, double operand2) {
		if (operand2 == 0) { //Checks if user is trying to divide by zero.
			System.out.println("Error: unable to divide by zero.");
			calculationResult = 0;
			return calculationResult;
		} else {
			calculationResult = operand1 / operand2;
			createLog(Operator.DIVIDE, operand1, operand2);
			return calculationResult;
		}
	}

	/**
	 * modulo: Calculates the remainder of dividing two numbers and calls createLog() method to generate a log of this action.
	 * @param operand1 A double containing the value to be used as the dividend.
	 * @param operand2 A double containing the value to be used as the divisor.
	 * @return calculationResult A double containing the remainder of dividing operand1 by operand2.
	 */
	public double modulo(double operand1, double operand2) {
		calculationResult = operand1 % operand2;
		createLog(Operator.MODULO, operand1, operand2);
		return calculationResult;
	}

	/**
	 * exponent: Calculates the result of raising a number to the power of another number,
     * and calls createLog() method to generate a log of this action.
	 * @param operand1 A double containing the value to be used as the base number.
	 * @param operand2 A double containing the value to be used as the exponent.
	 * @return calculationResult A double containing the power of operand1 by operand2.
	 */
	public double exponent(double operand1, double operand2) {
		calculationResult = Math.pow(operand1, operand2);
		createLog(Operator.EXPONENT, operand1, operand2);
		return calculationResult;
	}

    /**
     * root: Calculates the nth root of a number, and calls createLog() method to generate
	 * a log of this action.
     * @param operand1 A double containing the value to be used as the base number.
     * @param operand2 A double containing the value to be used as the root degree.
     * @return calculationResult A double containing the root of operand1 by operand2.
     */
	public double root(double operand1, double operand2) {
		calculationResult = Math.pow(operand1, (1 / operand2));
		createLog(Operator.ROOT, operand1, operand2);
		return calculationResult;
	}

    /**
     * createLog: Creates a new CalculationLog object and adds it to the actionLogs ArrayList.
     * @param operator A string containing the calculation operator.
     * @param operand1 A double containing the first value used in the calculation.
     * @param operand2 A double containing the second value used in the calculation.
	 * @return nothing
     */
	private void createLog(Operator operator, double operand1, double operand2) {
		actionLogs.add(new CalculationLog(operator, operand1, operand2, calculationResult));
	}

    /**
     * printLogs: Uses an enhanced for to call the toString method on each object in the actionLogs ArrayList
     * in the order they were created.
	 * @return nothing
     */
	public void printLogs() {
		for (CalculationLog log : actionLogs) {
			System.out.println(log.toString());
		}
		System.out.printf("\nCurrent value saved in memory: %s\n", memoryValue);
	}

    /**
     * getInstance: Gets the only object available.
     * @return the Calculator object.
     */
	public static Calculator getInstance() {
	    return instance;
    }

	/**
	 * getCalculationResult: Gets the result of the most recent calculation.
	 * @return calculationResult A double for the result of calculations.
	 */
	public double getCalculationResult() {
		return calculationResult;
	}
	
	/**
	 * getMemoryValue: Returns the memory value.
	 * @return A double containing the value saved in memory.
	 */
	public double getMemoryValue() {
		return memoryValue;
	}

	/**
	 * setMemoryValue: Sets the memory value.
	 * @param memoryValue A double for the value to be stored in memory.
	 * @return nothing
	 */
	public void setMemoryValue(double memoryValue) {
		this.memoryValue = memoryValue;
	}
}
