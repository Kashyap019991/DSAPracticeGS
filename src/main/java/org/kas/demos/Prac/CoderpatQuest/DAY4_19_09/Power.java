package org.kas.demos.Prac.CoderpatQuest.DAY4_19_09;

public class Power {

  /**
   * Given a base and an integer exponent, computes the value of the base
   * raised to the power of the exponent.
   * This implementation handles positive, negative, and zero exponents.
   *
   * @param base The base number (double).
   * @param exp The exponent (integer).
   * @return The result of base raised to the power of exp (double).
   */
  public static double power(double base, int exp) {
    // Edge case: Any number raised to the power of 0 is 1.
    if (exp == 0) {
      return 1.0;
    }

    // Handle negative exponents by calculating the reciprocal of the positive exponent.
    boolean isNegative = exp < 0;
    long exponent = Math.abs((long) exp); // Use long to handle exp = Integer.MIN_VALUE

    double result = 1.0;
    double currentBase = base;

    // Use a loop to multiply the base by itself `exponent` number of times.
    for (int i = 0; i < exponent; i++) {
      result *= currentBase;
    }

    // If the original exponent was negative, return the reciprocal of the result.
    if (isNegative) {
      return 1.0 / result;
    } else {
      return result;
    }
  }

  public static boolean doTestPass() {
    boolean testsPass = true;
    double result = power(2, 2);
    // Add additional test cases for a more robust test.
    testsPass &= (result == 4.0);
    testsPass &= (power(2, 3) == 8.0);
    testsPass &= (power(5, 0) == 1.0);
    testsPass &= (power(2, -2) == 0.25);
    testsPass &= (power(-3, 2) == 9.0);
    testsPass &= (power(-3, 3) == -27.0);
    
    return testsPass;
  }

  public static void main( String[] args ) {
    if(doTestPass()){
      System.out.println("Pass");
    }
    else{
      System.out.println("There are failures");
    }
  }
}
