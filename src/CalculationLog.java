/**
 * The CalculationLog class is used by the TextBasedCalculator classes
 * to keep a running log of all actions performed
 * by the calculator.
 * @author Nathan Lindsey
 * @version 1.0.0
 * date September 24 2018
 */

public class CalculationLog {
	private String opperand = "";
	private double value1 = 0;
	private double value2 = 0;
	private double result = 0;
	
	public CalculationLog(String command, double value1, double value2, double result) {
		this.value1 = value1;
		this.value2 = value2;
		this.result = result;
		switch (command) {
			case "ADD":
				this.opperand = "+";
				break;
			case "SUBTRACT":
				this.opperand = "-";
				break;
			case "MULTIPLY":
				this.opperand = "*";
				break;
			case "DIVIDE":
				this.opperand = "/";
				break;
			case "MODULO":
				this.opperand = "%";
				break;
			case "EXPONENT":
				this.opperand = "^";
				break;
			case "ROOT":
				this.opperand = "root";
				break;
			default:
				break;
		}
	}
	
	@Override
	public String toString() {
		return String.format("%s %s %s = %s.", this.value1, this.opperand, this.value2, this.result);
	}

}
