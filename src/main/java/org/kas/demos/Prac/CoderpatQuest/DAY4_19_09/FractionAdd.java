package org.kas.demos.Prac.CoderpatQuest.DAY4_19_09;

public class FractionAdd {

  /**
   * Given two fractions passed in as int arrays,
   * returns the fraction which is result of adding the two input fractions.
   * Each fraction is represented by an int array of size 2,
   * where index 0 is the numerator and index 1 is the denominator.
   * The returned fraction should be in its simplest form.
   */
  public static int[] addFractions( int[] fraction1, int[] fraction2 ) {
    // Calculate the new numerator: (numerator1 * denominator2) + (numerator2 * denominator1)
    int resultNumerator = (fraction1[0] * fraction2[1]) + (fraction2[0] * fraction1[1]);
    // Calculate the new denominator: denominator1 * denominator2
    int resultDenominator = fraction1[1] * fraction2[1];

    // Find the greatest common divisor (GCD) to simplify the fraction
    int gcd = calculateGCD(resultNumerator, resultDenominator);

    // Divide both numerator and denominator by the GCD to simplify the fraction
    resultNumerator /= gcd;
    resultDenominator /= gcd;

    // Return the simplified result as a new int array
    return new int[]{resultNumerator, resultDenominator};
  }

  /**
   * Calculates the Greatest Common Divisor (GCD) of two integers using the Euclidean algorithm.
   * This is a helper method for simplifying fractions.
   */
  private static int calculateGCD(int a, int b) {
    // Ensure 'a' is always positive for GCD calculation
    a = Math.abs(a);//8
    b = Math.abs(b);//16

    while (b != 0) {
      int temp = b;//16,8
      b = a % b;//8,0
      a = temp;//16,8
    }
    return a;//8
  }


  public static void main( String[] args ) {
    // Test case 1: 2/3 + 1/2 = 7/6
    int[] result1 = addFractions( new int[]{ 2, 3 }, new int[]{ 1, 2 } );
    if( result1[ 0 ] == 7 && result1[ 1 ] == 6 ) {
      System.out.println( "Test 1 passed." );
    } else {
      System.out.println( "Test 1 failed. Expected 7/6, got " + result1[0] + "/" + result1[1] );
    }

    // Test case 2: 1/4 + 1/4 = 1/2 (simplified from 2/4)
    int[] result2 = addFractions( new int[]{ 1, 4 }, new int[]{ 1, 4 } );
    if( result2[ 0 ] == 1 && result2[ 1 ] == 2 ) {
      System.out.println( "Test 2 passed." );
    } else {
      System.out.println( "Test 2 failed. Expected 1/2, got " + result2[0] + "/" + result2[1] );
    }

    // Test case 3: 3/5 + 2/5 = 1/1 (simplified from 5/5)
    int[] result3 = addFractions( new int[]{ 3, 5 }, new int[]{ 2, 5 } );
    if( result3[ 0 ] == 1 && result3[ 1 ] == 1 ) {
      System.out.println( "Test 3 passed." );
    } else {
      System.out.println( "Test 3 failed. Expected 1/1, got " + result3[0] + "/" + result3[1] );
    }
  }
}