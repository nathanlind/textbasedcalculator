/**
 * The CalculationLog class is used by the Calculator class
 * to keep a running log of all calculations performed
 * by the calculator.
 * @author Nathan Lindsey
 * @version 1.0.0
 * date September 24 2018
 */
public class CalculationLog {
	private String operator = "";
	private double operand1 = 0;
	private double operand2 = 0;
	private double calculationResult = 0;

    /**
     * Constructor for CalculationLog objects.
     * @param operator A string containing the type operator used in the calculation.
     * @param value1 A double containing the first operand.
     * @param value2 A double containing the second operand.
     * @param result A double containing the result of the calculation.
     */
	public CalculationLog(Operator operator, double value1, double value2, double result) {
        this.operator = operator.getOperatorSymbol();
		this.operand1 = value1;
		this.operand2 = value2;
		this.calculationResult = result;
	}

    /**
     * Overrides the inherited toString method to return the object data in a readable format.
     * @return A formatted string containing the contents of the CalculationLog object.
     */
	@Override
	public String toString() {
		return String.format("%s %s %s = %s.", this.operand1, this.operator, this.operand2, this.calculationResult);
	}

}
