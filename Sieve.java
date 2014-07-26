/**
 * <p>This is an interface that creates the outine for finding prime numbers</p>
 * 
 * <u>Grading Level</u>: Standard
 * 
 * @author Sean Bucholtz
 * @version Assignment 9: Sieve of Eratosthenes
 */
public interface Sieve {
   
  /**
   * generates a list of prime numbers.
   * 
   * @param n the range ceiling
   * @return a list of prime numbers
   */
   public java.util.List<Integer> getPrimes(int n);
   
}