package ua.oop.khpi.veremchuk01;

public class Veremchuk01 {
	/**
    * An entry point - main method.
    *
    * @param args - arguments of main method
    */
	public static void main(String[] args) {

        final short bookNumber = 0x3AEB;
        final long phoneNumber = 380994711009L;
        final byte binaryPhoneOfNumber = 0b10011;
        final short octalPhoneOfNumber = 035353;
        final byte numberInJournal = 5;
        final byte constant = 26;

        final byte number =  ((numberInJournal - 1 ) % constant) + 1;

        final char symbol = (char) number + 65;
        
        
        String strBookNumber;
        strBookNumber = Short.toString(bookNumber);
        Amount.EvenOddNum(strBookNumber);
        
        String strPhoneNumber;
        strPhoneNumber = Long.toString(phoneNumber);
        Amount.EvenOddNum(strPhoneNumber);
        
        String strBinaryPhoneNumber;
        strBinaryPhoneNumber = Byte.toString(binaryPhoneOfNumber);
        Amount.EvenOddNum(strBinaryPhoneNumber);
        
        String strOctalPhoneNumber;
        strOctalPhoneNumber = Short.toString(octalPhoneOfNumber);
        Amount.EvenOddNum(strOctalPhoneNumber);
        
        String strConstant;
        strConstant = Byte.toString(binaryPhoneOfNumber);
        Amount.EvenOddNum(strConstant);
        
        String strSymbol;
        strSymbol =  Integer.toString((int) symbol);
        Amount.EvenOddNum(strSymbol);
     
        
        strBookNumber = Integer.toBinaryString(bookNumber);
        Amount.OneCountBinaryNumber(strBookNumber);
        
        strPhoneNumber = Long.toBinaryString(phoneNumber);
        Amount.OneCountBinaryNumber(strPhoneNumber);
        
        strBinaryPhoneNumber = Integer.toBinaryString(binaryPhoneOfNumber);
        Amount.OneCountBinaryNumber(strBinaryPhoneNumber);
        
        strOctalPhoneNumber = Integer.toBinaryString(octalPhoneOfNumber);
        Amount.OneCountBinaryNumber(strOctalPhoneNumber);
        
        strConstant = Integer.toBinaryString(binaryPhoneOfNumber);
        Amount.OneCountBinaryNumber(strConstant);
        
        strSymbol = Integer.toBinaryString((int) symbol);
        Amount.OneCountBinaryNumber(strSymbol);
        
       
    }

}

class Amount{
	/**
	 * The method that counting and printing even and odd numbers
	 * 
	 * @param num - an argument that checks for parity
	 */
    public static void EvenOddNum ( String num) {
    	
    	  
    	byte EvenNum = 0;          // count of even numbers
        byte OddNum = 0;           // count of odd numbers
        
    	   for (byte i = 0; i < num.length(); i++) {   //checking if a number is even or not
    	             if (num.charAt(i) % 2 == 0) {
    	            	 EvenNum++;
    	             } else {
    	            	 OddNum++;
    	             }
    	         }
    	   System.out.println("Number: " + num);
    	   System.out.println("Number of even numbers: " + EvenNum);
    	   System.out.println("Number of odd numbers: " + OddNum);
    	   System.out.println("\n ");
    }
    /**
     * The method that counting binary ones in our numbers
     * 
     * @param num - the argument in which we count the number of ones in a binary number
     */
    public static void OneCountBinaryNumber(String num)
    {
     byte CountOne = 0;      // count of binary ones
     for (byte i = 0; i < num.length(); i++)         //comparison with 1
     {
               if (num.charAt(i) == '1')
               {
            	   CountOne++;
               } 
           }
      System.out.println("Binary Number: " + num);
      System.out.println("Number of 1: " + CountOne);
      System.out.println("\n ");
    }
}
