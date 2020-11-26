package ua.oop.khpi.veremchuk02;
import java.util.Random;

public class Veremchuk02 {
	/**
	    * An entry point - main method.
	    *
	    * @param args - arguments of main method
	    */
public static void main(String[] args)
{
   Random rand = new Random();
   System.out.println("--------------------------------------------------");
   System.out.println("|\tNumber\t |"+"\t"+"prime or not prime number|");
   System.out.println("--------------------------------------------------");

   for (int i = 0; i < 10; i++)
   {
    int number = rand.nextInt(100);
    IsPrimeNumber(number);
    printNumber(IsPrimeNumber(number),number);
   }

   System.out.println("--------------------------------------------------");
}
/**
 * A method that check a number. Is it Prime Number or Not!
 * 
 * @param value - the number that we checking for a simple 
 * @return 		- TRUE - if prime, FALSE - if not prime
 */
    public static boolean IsPrimeNumber(int value) {
	  if(value==1) {
            return false;
	  }
     
         for (int i = 2; i < value; i++){
        	 
             if (value % i == 0){
            	 
                 return false;  //return false, if the number is Not Prime
             }
         }
         //if the value that we need to find is not found we 
         return true;  //return true, if a number is Prime
     }


/**
 * A method that printing a number and check for the Prime Number 
 * 
 * @param prime - boolean argument (Is number Prime)
 * @param n		- a number that we are print
 */
private static void printNumber(boolean prime, int n) {
  
     if (prime) {
    	 System.out.println("|\t"+n+"\t |" +"\t"+ "is a prime number  \t "+"|");
     } else {
    	 System.out.println("|\t"+n+"\t |" +"\t"+ "is not a prime number\t "+"|");
     }
   }
}