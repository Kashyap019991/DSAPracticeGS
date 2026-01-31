package org.kas.demos.Prac.CoderpatQuest.DAY4_19_09;

public class ReverseString {
  /**
   * public static String reverseStr( String str )
   * Reverses a given string.
   * Example: reverseStr("abcd") returns "dcba".
   */
  public static String reverseStr(String str) {
    // Check for null or empty string to avoid errors and handle edge cases.
    if (str == null || str.isEmpty()) {
      return str; // Return the string as is if it's null or empty.
    }

    // Use a StringBuilder for efficient string manipulation.
    // Appending characters to a String repeatedly creates new String objects,
    // which is inefficient. StringBuilder modifies the string in place.
    StringBuilder reversedString = new StringBuilder();

    // Iterate through the input string from the last character to the first.
    for (int i = str.length() - 1; i >= 0; i--) {
      // Append each character to the StringBuilder in reverse order.
      reversedString.append(str.charAt(i));
    }

    // Convert the StringBuilder back to a String and return it.
    return reversedString.toString();
  }

  public static void main(String[] args) {
    boolean result = true;

    // Test case 1: Basic string reversal
    result = result && reverseStr("abcd").equals("dcba");

    // Test case 2: Empty string
    result = result && reverseStr("").equals("");

    // Test case 3: Single character string
    result = result && reverseStr("a").equals("a");

    // Test case 4: String with spaces
    result = result && reverseStr("hello world").equals("dlrow olleh");

    // Test case 5: Null string (should return null if not handled, or empty string if handled)
    // The current implementation returns null if the input is null.
    result = result && (reverseStr(null) == null);

    if (result) {
      System.out.println("All tests pass");
    } else {
      System.out.println("There are test failures");
    }
  }
}