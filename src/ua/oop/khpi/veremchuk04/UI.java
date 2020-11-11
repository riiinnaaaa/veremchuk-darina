package ua.oop.khpi.veremchuk04;

import java.util.Scanner;

public class UI {
	 private UI() {
	    }
	    /** Gets values from user. */
	    private static Scanner scan = new Scanner(System.in);
	    /** User's choice in main menu. */
	    private static int choice;
	    static int getChoice() {
	        return choice;
	    }
	    
	   /**
	    * The method that printing a dialog menu
	    */
	    static void mainMenu() {
	        System.out.format("%n1. Enter values.%n");
	        System.out.format("2. Print values.%n");
	        System.out.format("3. Task completion.%n");
	        System.out.format("4. Print result.%n");
	        System.out.format("0. Exit.%n");
	        System.out.format("Enter your choose: ");
	    }
	    /**
	     * The method that scans our choice
	     */
	    static void enterChoice() {
	        choice = scan.nextInt();
	        scan.nextLine();
	    }
	    
	  /**
	   * The method that adding a values in the text
	   * 
	   * @return text of our values
	   */
	    
	    public static String enterValues()
		{
			 System.out.println("Enter text:\n");
			  Scanner in = new Scanner(System.in);
			  String text = in.nextLine();
			  return text;
		}
		
	    /**
	     * The method that printing our input data
	     * 
	     * @param text that we have entered
	     */
		public static void printText(String text) {
			System.out.println("Entered text:" + text);
		}
	    
       
}


