package ua.oop.khpi.veremchuk04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NewHelper { 
	/**
	 * The method that printing symbols with using String Builder object
	 * 
	 * @param line - our text after splitting
	 */
	public static void printSymbols(final String line) {

		  StringBuilder builder = new StringBuilder();
		        for (char symbol : line.toCharArray()) {
		         //Checking for  ' '/'!'/'.'/':'
		         if((int)symbol == 32 | (int)symbol == 33 |(int)symbol == 46 |(int)symbol == 58 |(int)symbol == 44) 
		         {
		       continue;
		         }
		            builder.append("\t");
		            builder.append(symbol);
		        }
		        
		        if (ArgsHandler.isDebug()) {
		            System.out.println("\nInput Text: " + builder.toString());
		        }
		        else {
		        	System.out.print(builder.toString());}
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
		         //Checking for ' '/'!'/'.'/':'
		         if((int)symbol == 32 | (int)symbol == 33 |(int)symbol == 58|(int)symbol == 44|(int)symbol == 46)
		         {
		          continue;
		         }
		   builder.append("\t");
		   builder.append((int)symbol);

		        }
		        if (ArgsHandler.isDebug()) {
		            System.out.println("\nTask Result: " + builder.toString());
		        }
		        else {
		        	System.out.print(builder.toString());
		        }
		        	
		        
		        System.out.println(); 
		    }
		    /**
		     * The method that splits text 
		     * 
		     * @param text - text we are splitting 
		     * @return - returns array of words 
		     */
		    
		   
		public static String[] DivString(String text) {
			
			if(ArgsHandler.isDebug())
			   {
				   System.out.format("%nString text = "
				+ text +" (a string that stores our text that we'll split.)");
				   System.out.println();
			   };
			 			 
		    	List<String> words = new ArrayList<>();
		    	StringBuilder builder = new StringBuilder();
		    	for(char symbol : text.toCharArray()) {
		    		  if((int)symbol == 32 | (int)symbol == 33 |(int)symbol == 58|(int)symbol == 44|(int)symbol == 46) {
		    	      continue;
		    	      }
		    		  builder.append(symbol);
		    	}
		    	words.add(builder.toString());
		   	    builder = new StringBuilder();
		    	  
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
		    	
		    	if(ArgsHandler.isDebug())
				   {
					   System.out.format("%nString output = ");
							 
					   for (int i = 0; i < output.length; i++) {
						   System.out.format(output[i]);
					   }
					   System.out.format (" (our array of output strings after Split Method!)");
					   System.out.format("%n############################################################### DEBUG #############################################################");
					   System.out.println();
				   }
		    	return output;
		    	}
		    
	
	
}

