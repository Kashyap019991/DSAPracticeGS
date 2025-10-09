package org.kas.demos.Prac.CoderpatQuest.DAY4_19_09;

public class GCD {

  /**
   * Given two fractions passed in as int arrays,
   * returns the fraction which is result of adding the two input fractions.
   * Each fraction is represented by an int array of size 2,
   * where index 0 is the numerator and index 1 is the denominator.
   * The returned fraction should be in its simplest form.
   */

  /**
   * Calculates the Greatest Common Divisor (GCD) of two integers using the Euclidean algorithm.
   * This is a helper method for simplifying fractions.
   */
  private static int calculateGCD(int a, int b) {
    // Ensure 'a' is always positive for GCD calculation
    a = Math.abs(a);
    b = Math.abs(b);

    while (b != 0) {
      int temp = b;
      b = a % b;
      a = temp;
    }
    return a;
  }


  public static void main( String[] args ) {
    // Test case 1: 2/3 + 1/2 = 7/6
    System.out.println(calculateGCD(32,16));
  }
}