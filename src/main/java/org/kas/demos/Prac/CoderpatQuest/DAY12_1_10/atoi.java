package org.kas.demos.Prac.CoderpatQuest.DAY12_1_10;

/**
 * A utility class for converting strings to integers (atoi).
 */
public class atoi {

  /**
   * Converts a string to an integer value, handling signs, non-digit characters,
   * whitespace, and integer overflow. This implementation is based on the typical
   * `atoi` (ASCII to integer) function logic.
   *
   * @param str The string to be converted.
   * @return The integer value represented by the string. If the string is
   *         invalid or causes an overflow, the function handles it gracefully.
   */
  public static int atoi(String str) {
    if (str == null || str.length() == 0) {
      return 0;
    }

    int i = 0;
    long result = 0; // Use long to detect overflow
    int sign = 1;

    // 1. Skip leading whitespace
    while (i < str.length() && str.charAt(i) == ' ') {
      i++;
    }

    // 2. Handle sign
    if (i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
      if (str.charAt(i) == '-') {
        sign = -1;
      }
      i++;
    }

    // 3. Convert digits and check for overflow
    while (i < str.length() && Character.isDigit(str.charAt(i))) {
      int digit = str.charAt(i) - '0';
      result = result * 10 + digit;

      // Check for overflow before applying the sign
      if (sign == 1 && result > Integer.MAX_VALUE) {
        return Integer.MAX_VALUE;
      }
      if (sign == -1 && -result < Integer.MIN_VALUE) {
        return Integer.MIN_VALUE;
      }
      i++;
    }

    return (int) (result * sign);
  }

  /**
   * A helper function to run multiple test cases and report on the result.
   *
   * @return true if all tests pass, false otherwise.
   */
  public static boolean pass() {
    boolean result = true;
    
    // Test case 1: Positive integer
    result = result && (atoi("42") == 42);
    
    // Test case 2: Negative integer
    result = result && (atoi("-42") == -42);
    
    // Test case 3: Leading whitespace
    result = result && (atoi("   42") == 42);
    
    // Test case 4: Non-digit characters after the number
    result = result && (atoi("4193 with words") == 4193);
    
    // Test case 5: Words at the beginning
    result = result && (atoi("words and 987") == 0);
    
    // Test case 6: Overflow (positive)
    result = result && (atoi("2147483648") == Integer.MAX_VALUE);
    
    // Test case 7: Overflow (negative)
    result = result && (atoi("-2147483649") == Integer.MIN_VALUE);
    
    // Test case 8: Leading zeros
    result = result && (atoi("000123") == 123);
    
    // Test case 9: Only whitespace
    result = result && (atoi("  ") == 0);
    
    // Test case 10: Empty string
    result = result && (atoi("") == 0);

    // Test case 11: Plus sign
    result = result && (atoi("+1") == 1);
    
    // Test case 12: Combined sign with overflow
    result = result && (atoi("   +2147483648") == Integer.MAX_VALUE);

    return result;
  }

  /**
   * The main method to execute the tests.
   */
  public static void main(String[] args) {
    if (pass()) {
      System.out.println("Pass");
    } else {
      System.err.println("Some fail");
    }
  }
}