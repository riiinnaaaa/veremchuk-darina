package ua.oop.khpi.veremchuk05;
import ua.oop.khpi.veremchuk05.MyContainer.MyIterator;
import ua.oop.khpi.veremchuk03.Helper;

public class Veremchuk05 {
	
		private Veremchuk05() {
	    }
	    /**
	     * An entry point - main method.
	     * @param args - arguments of main method
	     */
		 public static void main(final String[] args) {
		        // Creating container
		        MyContainer container = new MyContainer();
		        //Source strings for processing with Helper class 
		        String text =  "Hello, my name is Darina";
		        String text2 = "Hello, my name";
		       
		        String[] lines = Helper.DivString(text); // alternative to split method
		        String[] lines2 = Helper.DivString(text2); 
		        StringBuilder builder = new StringBuilder();
		        container.add(lines);
		     		
		        // Creating iterator
		        MyIterator iter = container.iterator();
		        System.out.print("While:      ");
		        // Printing values by a while loop
		        while (iter.hasNext()) {
		            System.out.print(iter.next() + " ");
		        }
		        System.out.println();
		        // Printing values by a for each loop
		        System.out.print("For each:   ");
		        for (String s : container) {
		            System.out.print(s + " ");
		        }
		        System.out.println();
		        // Using toString() method
		        System.out.println("toString(): " + container.toString()+ "\n");
		        // Creating second container
		        MyContainer container2 = new MyContainer();
		        // Add values into the second container
		        container2.add(lines2);
		     		
		
		        System.out.println("Testing boolean methods:");
		        // Using contains() method
		        System.out.println(container.contains("my"));
		        // Using containsAll() method
		        System.out.println(container.containsAll(container2));
		        container2.add("Nastya");
		        System.out.println(container.containsAll(container2));
		        // Using remove() method
		        container2.remove("Nastya");
		        System.out.println(container.containsAll(container2) + "\n");
		        // Creating second iterator
		        MyIterator iter1 = container.iterator();
		        // Using iterator's methods
		        for (String s : container) {
		            System.out.print(s + ' ');
		        }
		        System.out.println();
		        if (iter1.hasNext()) {
		            System.out.println(iter1.next());
		        }
		        iter1.remove();
		        for (String s : container) {
		            System.out.print(s + ' ');
		        }
		        System.out.println();
		        if (iter1.hasNext()) {
		            System.out.println(iter1.next());
		        }
		        iter1.remove();
		        for (String s : container) {
		            System.out.print(s + ' ');
		        }
		        System.out.println();
		        if (iter1.hasNext()) {
		            System.out.println(iter1.next());
		        }
		        iter1.remove();
		        iter1.toString(); 
		    }
	
	}


