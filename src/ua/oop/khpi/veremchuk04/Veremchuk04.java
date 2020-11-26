package ua.oop.khpi.veremchuk04;

public class Veremchuk04 {
	
	/**
     * An entry point - main method.
     * @param args - arguments of main method
     */
	
public static void main(String[]args) {
	
	 
	ArgsHandler handler = new ArgsHandler(args);
    if (!handler.empty()) {
        handler.execute();
    }
    
    final int exit = 0;
    final int setValues = 1;
    final int getValues = 2;
    final int execute2 = 3;
    final int printResult = 4;
    String word = null;
    
    /**
     *  Our dialog menu with checking of input argumet's of program 
     */
    do {
        UI.mainMenu();
        UI.enterChoice();
        switch (UI.getChoice()) {
            case exit:
                if (ArgsHandler.isDebug()) {
                    System.out.println("\nYou chosen 0. Exiting...");
                    System.out.format("%n############################################################### DEBUG #############################################################");
                }
                break;
            case setValues:
                if (ArgsHandler.isDebug()) {
                	System.out.format("%n############################################################### DEBUG #############################################################");
                    System.out.println("\nYou chosen 1. Setting values...");
                }
                word = UI.enterValues();
                break;
            case getValues:
                if (ArgsHandler.isDebug()) {
                	System.out.format("%n############################################################### DEBUG #############################################################");
                    System.out.println("\nYou chosen 2. Getting values...");
                }
                if (word != null ) {
                    UI.printText(word);
                } else {
                    System.out.format("%nFirst you need to add values.");
                }
                break;        
            case execute2:
                if (ArgsHandler.isDebug()) {
                	System.out.format("%n############################################################### DEBUG #############################################################");
                    System.out.println("\nYou chosen 3. Executing task...");
                }
                if (word != null) {
                	  final String []lines = NewHelper.DivString(word);
                	  System.out.println("\nTask done...");
                	  if (ArgsHandler.isDebug()) {
                	  System.out.format("%n############################################################### DEBUG #############################################################");
                	  }
                } else {
                    System.out.format("%nFirst you need to add values.");
                }
                break;
            case printResult:
                if (ArgsHandler.isDebug()) {
                	System.out.format("%n############################################################### DEBUG #############################################################");
                    System.out.format("%nYou chosen 4. "
                                    + "Printing out result...%n");
                }
                if (word != null) {
                	final String[] lines2 = NewHelper.DivString(word);
                	for (final String line2 : lines2) {
                    NewHelper.printSymbols(line2);
                    NewHelper.printSymbolNumbers(line2);
                	}
                	if(ArgsHandler.isDebug()) {
                	System.out.format("%n############################################################### DEBUG #############################################################");
                } 
                	else {
                    System.out.format("%nFirst you need to add values."); 
                }
                break;
                }
            default:
                System.out.println("\nEnter correct number.");
        }
    } while (UI.getChoice() != 0);
}
}
	
	



