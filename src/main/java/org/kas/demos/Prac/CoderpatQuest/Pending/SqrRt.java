package org.kas.demos.Prac.CoderpatQuest.Pending;

public class SqrRt {
  /*
  *   double squareRoot( double x )
  *
  *   This function calculates the square root of a non-negative number 'x'
  *   using Newton's method. It iteratively refines an initial guess until
  *   the result is within a defined precision.
  */

  public static double squareRoot( double x ) {
    // Handle special cases
    if (x < 0) {
      return Double.NaN; // Square root of negative number is not a real number
    }
    if (x == 0) {
      return 0;
    }
    //sqrtn+1 = sqrtn +(num/sqrtn)/2.0
    // Use Newton's Method (Babylonian method) for approximation
    double guess = x / 2.0; // Initial guess, can be anything non-zero
    double epsilon = 0.00001; // Precision for the approximation

    // Loop until the difference between consecutive guesses is very small
    while (Math.abs(guess - (x / guess)) > epsilon) {
      // Refine the guess
      guess = 0.5 * (guess + x / guess);
    }
    
    return guess;
  }

  public static void main( String args[]) {
    double[] inputs = {2, 4, 100, 0, -1};
    double[] expected_values = { 1.41421, 2, 10, 0, Double.NaN};
    double threshold = 0.001;

    boolean allPassed = true;
    for(int i=0; i < inputs.length; i++) {
      double result = squareRoot(inputs[i]);
      boolean testPassed = false;
      
      // Special handling for NaN, as NaN != NaN
      if (Double.isNaN(expected_values[i])) {
          testPassed = Double.isNaN(result);
      } else {
          testPassed = Math.abs(result - expected_values[i]) <= threshold;
      }
      
      if(!testPassed) {
        System.out.printf( "Test failed for %f, expected=%f, actual=%f\n", inputs[i], expected_values[i], result );
        allPassed = false;
      }
    }
    
    if (allPassed) {
        System.out.println( "All tests passed");
    } else {
        System.out.println( "Some tests failed");
    }
  }
}
