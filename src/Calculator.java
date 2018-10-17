import java.lang.Math;
import java.util.ArrayList;

/**
 * The Calculator class is used by the TextBasedCalculator class
 * to perform calculations.
 * @author Nathan Lindsey
 * @version 1.0.0
 * date September 24 2018
 */
public final class Calculator {

    private static Calculator instance = new Calculator();
	private double calculationResult = 0;
	private double memoryValue = 0;
	ArrayList<CalculationLog> actionLogs = new ArrayList<CalculationLog>();
	
	
	private Calculator() {}


	public double add(double operand1, double operand2) {
		calculationResult = operand1 + operand2;
		createLog("ADD", operand1, operand2);
		return calculationResult;

	}
	
	public double subtract(double operand1, double operand2) {
		calculationResult = operand1 - operand2;
		createLog("SUBTRACT", operand1, operand2);
		return calculationResult;

	}
	
	public double multiply(double operand1, double operand2) {
		calculationResult = operand1 * operand2;
		createLog("MULTIPLY", operand1, operand2);
		return calculationResult;
	}
	
	public double divide(double operand1, double operand2) {
		if (operand2 == 0) { //Checks if user is trying to divide by zero.
			System.out.println("Error: unable to divide by zero.");
			calculationResult = 0;
			return calculationResult;
		} else {
			calculationResult = operand1 / operand2;
			createLog("DIVIDE", operand1, operand2);
			return calculationResult;
		}

	}

	public double modulo(double operand1, double operand2) {
		calculationResult = operand1 % operand2;
		createLog("MODULO", operand1, operand2);
		return calculationResult;

	}
	
	public double raisePower(double operand1, double operand2) {
		calculationResult = Math.pow(operand1, operand2);
		createLog("EXPONENT", operand1, operand2);
		return calculationResult;

	}

	public double root(double operand1, double operand2) {
		calculationResult = Math.pow(operand1, (1 / operand2));
		createLog("ROOT", operand1, operand2);
		return calculationResult;
	}



	private void createLog(String command, double operand1, double operand2) {
		actionLogs.add(new CalculationLog(command, operand1, operand2, calculationResult));
	}

	public void printLogs() {
		for (CalculationLog log : actionLogs) {
			System.out.println(log.toString());
		}
		System.out.printf("\nCurrent value saved in memory: %s\n", memoryValue);
	}



	public static Calculator getInstance() {
	    return instance;
    }

	/**
	 * Gets the calculationResult of the most recent calculation.
	 * @return calculationResult A double for the result of calculations.
	 */
	public double getCalculationResult() {
		return calculationResult;
	}
	
	/**
	 * Returns the memory value.
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
