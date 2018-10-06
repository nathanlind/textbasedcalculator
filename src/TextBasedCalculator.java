/**
 * TextBasedCalculator returns various calculation results
 * based on user input via the command line.
 * @author Nathan Lindsey
 * @version 1.0.0
 * date September 24 2018
 */

import java.util.ArrayList;
import java.util.Scanner;

public class TextBasedCalculator {
	
	/**
	 * main is the main method
	 * @param args is an array of words passed in via the command line
	 * @return nothing
	 */
	public static void main(String[] args) {
		
		String command = "";
		Scanner commandScanner = new Scanner(System.in);
		Calculator calculator = new Calculator();
		ArrayList<CalculationLog> actionLogs = new ArrayList<CalculationLog>();
		
		
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
				System.out.println(calculator.add());
				actionLogs.add(new CalculationLog(command, calculator.getCalculationValue1(), calculator.getCalculationValue2(), calculator.getCalculationResult()));
				
			} else if (command.equals("SUBTRACT")) {
				System.out.println(calculator.subtract());
				actionLogs.add(new CalculationLog(command, calculator.getCalculationValue1(), calculator.getCalculationValue2(), calculator.getCalculationResult()));
				
			} else if (command.equals("MULTIPLY")) {
				System.out.println(calculator.multiply());
				actionLogs.add(new CalculationLog(command, calculator.getCalculationValue1(), calculator.getCalculationValue2(), calculator.getCalculationResult()));
				
			} else if (command.equals("DIVIDE")) {
				System.out.println(calculator.divide());
				actionLogs.add(new CalculationLog(command, calculator.getCalculationValue1(), calculator.getCalculationValue2(), calculator.getCalculationResult()));
				
			} else if (command.equals("MODULO")) {
				System.out.println(calculator.modulo());
				actionLogs.add(new CalculationLog(command, calculator.getCalculationValue1(), calculator.getCalculationValue2(), calculator.getCalculationResult()));
				
			} else if (command.equals("EXPONENT")) {
				System.out.println(calculator.raisePower());
				actionLogs.add(new CalculationLog(command, calculator.getCalculationValue1(), calculator.getCalculationValue2(), calculator.getCalculationResult()));
				
			} else if (command.equals("ROOT")) {
				System.out.println(calculator.root());
				actionLogs.add(new CalculationLog(command, calculator.getCalculationValue1(), calculator.getCalculationValue2(), calculator.getCalculationResult()));
				
			} else if (command.equals("SAVE")) {
				calculator.setMemoryValue(calculator.getCalculationResult());
				System.out.printf("%s saved to memory. \n\n", calculator.getMemoryValue());
				
			} else if (command.equals("LOG")) {
				for (CalculationLog log : actionLogs) {
					System.out.println(log.toString());
				}
				System.out.printf("\nCurrent value saved in memory: %s\n", calculator.getMemoryValue());
				
			} else if (command.equals("HELP")) {
				System.out.println("\n**TEXT BASED CALCULATOR COMMANDS** \n\nADD \nSUBTRACT \n"
						+ "MULTIPLY \nDIVIDE \nMODULO (Returns the remainder after division.) \n"
						+ "EXPONENT (Raise base number to power.) \nROOT (Returns any root of base number.)"
						+ "\n\nPI may be entered as a value. "
						+ "\nSAVE may be entered to save last result to memory. "
						+ "\nMEM may be entered as a value to recall previously saved result. "
						+ "\nLOG returns a log of all actions performed."
						+ "\n\nOFF to quit. \n**********************************");
			}
			
		} while (!command.equals("OFF"));
		
		System.out.println("\n**Thank you for using TEXT BASED CALCULATOR.**");
		
		
		commandScanner.close();
		
	}

}
