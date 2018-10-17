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
	
	public CalculationLog(String command, double value1, double value2, double result) {
		this.operand1 = value1;
		this.operand2 = value2;
		this.calculationResult = result;
		switch (command) {
			case "ADD":
				this.operator = "+";
				break;
			case "SUBTRACT":
				this.operator = "-";
				break;
			case "MULTIPLY":
				this.operator = "*";
				break;
			case "DIVIDE":
				this.operator = "/";
				break;
			case "MODULO":
				this.operator = "%";
				break;
			case "EXPONENT":
				this.operator = "^";
				break;
			case "ROOT":
				this.operator = "root";
				break;
			default:
				break;
		}
	}
	
	@Override
	public String toString() {
		return String.format("%s %s %s = %s.", this.operand1, this.operator, this.operand2, this.calculationResult);
	}

}
