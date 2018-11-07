/**
 * The Operator Enum is used to enforce the types of operators being
 * sent from the Calculator class to the CalculationLog when a new actionLog
 * is created.
 * @author Nathan Lindsey
 * @version 1.0.0
 * date October 20th, 2018
 */
public enum Operator {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    MODULO("%"),
    EXPONENT("^"),
    ROOT("√");

    private final String operatorSymbol;

    /**
     * Enum constructor to initialize instance fields.
     * @param operatorSymbol A String containing the name of the specific operator symbol.
     * @return nothing
     */
    Operator(String operatorSymbol) {
        this.operatorSymbol = operatorSymbol;
    }

    /**
     * getOperatorSymbol: Returns value for the appropriate enum.
     * @return A string containing an operator symbol.
     */
    public String getOperatorSymbol() {
    	return operatorSymbol;
    }
}

