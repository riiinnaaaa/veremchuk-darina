package ua.oop.khpi.veremchuk03;

import java.util.ArrayList;
import java.util.List;


public class Helper {
	/**
	 * The method that printing symbols with using String Builder object
	 * 
	 * @param line - our text after splitting
	 */
	public static void printSymbols(final String line) {
		StringBuilder builder = new StringBuilder();
        for (char symbol : line.toCharArray()) {
        	//Check for the  ' '/'!'/'.'/':'
            if((int)symbol == 32 | (int)symbol == 33 |(int)symbol == 46 |(int)symbol == 58 |(int)symbol == 44) 
            {
            	continue;
            }
            builder.append("\t");
            builder.append(symbol);
         }
        System.out.print(builder.toString());
        System.out.println();
     }
	
	/**
	 * The method that printing integer value (ASCII CODE) of symbol
	 * 
	 * @param line - our line of symbols where we looking for (ASCII CODE)
	 */
    
    public static void printSymbolNumbers(final String line) {
    	StringBuilder builder = new StringBuilder();
        for (char symbol : line.toCharArray()) {
        	//�������� �� ' '/'!'/'.'/':'
            if((int)symbol == 32 | (int)symbol == 33 |(int)symbol == 58|(int)symbol == 44|(int)symbol == 46)
            {
            	continue;
            }
            builder.append("\t");
            builder.append((int)symbol);

        }
        System.out.print(builder.toString());
        System.out.println();
     }
     
    /**
     * The method that splits text 
     * 
     * @param text - text we are splitting 
     * @return - returns array of words 
     */
    
    public static String[] DivString(String text) {
        List<String> words = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        int count = 0;
        char symbol;
        while (count < text.length()) {
        	for (int i = count; i < text.toCharArray().length; i++)
        	{
        		symbol = text.toCharArray()[i];
        		if((int)symbol == 32 | (int)symbol == 33 |(int)symbol == 58|(int)symbol == 44|(int)symbol == 46) {
                    count++;
        			break;
        		}
        		builder.append(symbol);
        		count++;
        	}
        	words.add(builder.toString());
        	builder = new StringBuilder();
        }
        
        if(builder.length() != 0) {
        	words.add(builder.toString());
        }
        for (int i = 0; i < words.size(); i++) {
        	if(words.get(i).length() == 0) {
        		words.remove(i);
            }
        }
        String[] output = new String[words.size()];
        for (int i = 0; i < words.size(); i++) {
        	output[i] = words.get(i);
        }
        return output;
    }
}