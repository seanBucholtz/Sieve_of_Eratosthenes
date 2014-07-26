import java.util.ListIterator;

/**
 * <p>This is the client class that provides the prime numbers in a range</p>
 * 
 * <u>Grading Level</u>: Standard
 * 
 * @author Sean Bucholtz
 * @version Assignment 9: Sieve of Eratosthenes
 */
public class SieveDriver {
   // declare scanner field
   private java.util.Scanner scan;
   // declare field of type Sieve
   private Sieve theSieve;
   
   /**
    * zero-parameter constructor.
    */
   public SieveDriver() {
     // instantiate new scanner object
     scan = new java.util.Scanner(System.in);
     // instantiate a new instance of the server class
     theSieve = new SieveWork();
   }
   
   /**
    * Drives the application.
    */
   public void go() {
     // declare list for prime number storage
     java.util.List<Integer> primes;
     // storage varibale for prime cieling/range
     int n = getNumber();
     // continue until user enters "0"
     while (n != 0) {
       //retrieves primes from server class
       primes = theSieve.getPrimes(n);
       // display prime results
       printPrimes(n, primes);
       // prompt user for new number
       n = getNumber();
     }
   }
   
   /**
    * Retrieves the range value from the user.
    * 
    * @return the range value
    */
   public int getNumber() {
     // declare a conditional varibale for whether or not 
     // an input is a integer
     boolean isNumber;
     // declare a conditional variable for whether or not 
     // a valid number was attained
     boolean validNumber;
     // return variable
     int n = 0;
     // declare a String input varibale
     String input;
     // instantiate condition to false
     validNumber = false;
     // while a valid number has not been obtained from user
     while (validNumber == false) {
       // input message
       System.out.print("Enter the upper bound (0 to exit): ");
       // prompt user for input & set valid number condition
       isNumber = scan.hasNextInt();
       // new line
       System.out.println("");
       // if input is an integer
       if (isNumber) {
         // assign number to return variabale
         n = scan.nextInt();
         // set valid number condition to true
         validNumber = true;
         // if return varibale is a negative value
         if (n < 0) {
           // set valid number condition to false
           validNumber = false;
           // inform user of error
           System.out.println("Your input " + n + " is not a valid non-negative number.");
           // new line
           System.out.println("");
         }
        // if input is not an integer
       } else {
         // assign input to varibale
         input = scan.next();
         // inform user of error
         System.out.println("Your input " + input + " is not a valid non-negative number.");
         // new line
         System.out.println("");
       }
     }
     //return number
     return n;
   }
   
   /**
    * Displays the prime numbers in the range provided by the user, 
    * and their ratio of occurance.
    * 
    * @param bound the maximum range of numbers
    * @param list the list of prime numbers
    */
   public void printPrimes(int bound, java.util.List<Integer> list) {
     // declare and instantiate iterator
     ListIterator<Integer> itr = list.listIterator();
     // declare prime value storage
     int prime;
     // declareline count and instantiate to 0
     int lineCount = 0;
     // declare percent varibale
     int percent;
     // display script
      System.out.println("Here are the primes between 2 and " + bound);
      // iterate through prime list
      while(itr.hasNext()) {
        // instantiate storage and assign it to next prime in list
        prime = (int) itr.next();
        //print prime
        System.out.print(prime + " ");
        // increase line count
        lineCount += 1;
        // if line count reached 12
        if (lineCount == 12) {
          // start new line
          System.out.println("");
          // reset line count
          lineCount = 0;
        }  
      }
      // new line
      System.out.println("");
      // instantiate variable and assign the rounded percent value
      // percent = [(number of primes found)/(number range)]*100
      percent = Math.round((list.size() / (float) bound)*100);
      // display percentage of primes to range message
      System.out.println(percent + "% of the numbers between 1 and " + bound + " are prime.");
      // new line
      System.out.println();
      // new line
      System.out.println();
   }
   
   /**
    * The application method.
    * 
    * @param args the command-line arguments
    */
   public static void main(String[] args) {
     // instantiates a new instance of the class and calls the driver method
      new SieveDriver().go();
   }
   
}