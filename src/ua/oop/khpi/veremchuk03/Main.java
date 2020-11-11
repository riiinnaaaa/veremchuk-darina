package ua.oop.khpi.veremchuk03;
import java.util.Scanner;


public class Main {
	/**
	* An entry point - main method.
	*
	* @param args - arguments of main method
	*/
	public static void main(String[]args) {
		System.out.println("Enter text:\n");
		Scanner in = new Scanner(System.in);
		String text = in.nextLine();
		final String[] lines = Helper.DivString(text); // alternative to split method
		for (final String line : lines) {
			Helper.printSymbols(line);
			Helper.printSymbolNumbers(line);
    	}
	}
}
