/**
 * <p>This is the server class that provides the prime numbers in a range</p>
 * 
 * <u>Grading Level</u>: Standard
 * 
 * @author Sean Bucholtz
 * @version Assignment 9: Sieve of Eratosthenes
 */
public class SieveWork implements Sieve {
  
  // declare number storage
  public java.util.List <Integer> numbers;
  // declare prime number storage
  public java.util.List <Integer> primeList;
  // declare iterator
  public java.util.ListIterator <Integer> itr;
  
  /**
   * uses a <i>Sieve of Eratosthenes</i> style algorithm to
   * find the prime numbers in a range.
   * 
   * @param n the range ceiling
   * @return the list of prime numbers
   */
  public java.util.List<Integer> getPrimes(int n) {
    
    int m = (int) Math.sqrt(n);
    int currentPrime;
    int lastIndex = 0;
    numbers = new java.util.ArrayList<Integer>();
    primeList = new java.util.ArrayList<Integer>();
    // if range is less than 2 return an empty prime list
    if (n < 2) {
      return primeList;
    }
    // generates number list
    for (int num = 2; num <= n; num ++) {
      numbers.add(num);
    }
    // cycles through number list that are < the sqrt of the 'ceiling' n
    for (int num = 0; numbers.get(num) <= m; num ++) {
      // the index of the current/last prime divisor
      lastIndex = num;
      // instantiates iterator, and begins at the index directly after the currentPrime
      itr = numbers.listIterator(num +1); 
      // current number at index
      currentPrime = numbers.get(num);
      // adds current prime to prime list
      primeList.add(currentPrime);     
      // checks the subsequent numbers of the list
      while (itr.hasNext()) {
        //number to check
        int nextNum = itr.next();
        // the remainder of the nextNum/currentPrime
        int remainder = nextNum%currentPrime; 
        // if there is a remainder currentPrime is a divisor of nextNum
        // and so nextNum is not a prime
        if (remainder == 0) {
          // removes nextNum for numberList
          itr.remove();
        }
      }
    }
    // starts iterator at the index
    itr = numbers.listIterator(lastIndex+1);
    while (itr.hasNext()) {
      primeList.add(itr.next());
    }
    return primeList;
  }  
  
//  public java.util.List<Integer> getPrimes(int n) {
//    
//    int m = (int) Math.sqrt(n);
//    int currentPrime;
//    numbers = new java.util.ArrayList<Integer>();
//    primeList = new java.util.ArrayList<Integer>();
//    // if range is less than 2 return an empty prime list
//    if (n < 2) {
//      return primeList;
//    }
//    // generates number list
//    for (int num = 2; num <= n; num ++) {
//      numbers.add(num);
//      primeList.add(num);
//    }
//    for (int i = 0; i <= m; i ++) {
//      int primeNum = numbers.get(i);
//      for (int j = i + primeNum; j < numbers.size(); j += primeNum) {
//        primeList.remove(numbers.get(j));
//      }
//    }
//    return primeList;
//  } 
}