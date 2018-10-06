/**
 * The CalculationLog class is used by the TextBasedCalculator classes
 * to keep a running log of all actions performed
 * by the calculator.
 * @author Nathan Lindsey
 * @version 1.0.0
 * date September 24 2018
 */
public class CalculationLog {
	private String operand = "";
	private double calculationValue1 = 0;
	private double calculationValue2 = 0;
	private double calculationResult = 0;
	
	public CalculationLog(String command, double value1, double value2, double result) {
		this.calculationValue1 = value1;
		this.calculationValue2 = value2;
		this.calculationResult = result;
		switch (command) {
			case "ADD":
				this.operand = "+";
				break;
			case "SUBTRACT":
				this.operand = "-";
				break;
			case "MULTIPLY":
				this.operand = "*";
				break;
			case "DIVIDE":
				this.operand = "/";
				break;
			case "MODULO":
				this.operand = "%";
				break;
			case "EXPONENT":
				this.operand = "^";
				break;
			case "ROOT":
				this.operand = "root";
				break;
			default:
				break;
		}
	}
	
	@Override
	public String toString() {
		return String.format("%s %s %s = %s.", this.calculationValue1, this.operand, this.calculationValue2, this.calculationResult);
	}

}
