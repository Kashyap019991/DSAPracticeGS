package org.kas.demos.Prac.CoderpatQuest.DAY3_18_09;

import java.util.HashSet;

public class FindUniqueTupple {

  /**
   * Finds all unique tuples (substrings) of a given length from a string.
   *
   * @param input The string to search within.
   * @param len The desired length of the tuples.
   * @return A HashSet of unique tuples as strings.
   */
  public static HashSet<String> uniqueTuples(String input, int len) {
    // A HashSet is used to automatically handle uniqueness.
    HashSet<String> result = new HashSet<>();

    // A check to handle invalid input cases.
    if (input == null || input.length() < len || len <= 0) {
      return result;
    }

    // Iterate through the input string with a "sliding window" of size 'len'.
    // The loop runs from the start of the string up to the point where
    // a substring of length 'len' can no longer be formed.
    for (int i = 0; i <= input.length() - len; i++) {
      // Extract the substring of length 'len' starting from the current index 'i'.
      String tuple = input.substring(i, i + len);
      
      // Add the extracted tuple to the HashSet.
      // The HashSet will automatically ignore any duplicates.
      result.add(tuple);
    }

    return result;
  }

  public static void main(String[] args) {
    String input = "aab";
    HashSet<String> result = uniqueTuples(input, 2);
    
    // Check if the expected tuples are present and the set size is correct.
    if (result.contains("aa") && result.contains("ab") && result.size() == 2) {
      System.out.println("Test passed.");
    } else {
      System.out.println("Test failed.");
      System.out.println("Expected unique tuples: [aa, ab]");
      System.out.println("Actual unique tuples: " + result);
    }
    
    // Additional test case
    String input2 = "abcdeabc";
    HashSet<String> result2 = uniqueTuples(input2, 3);
    HashSet<String> expected2 = new HashSet<>();
    expected2.add("abc");
    expected2.add("bcd");
    expected2.add("cde");
    expected2.add("eab");
    expected2.add("dea");
    
    if (result2.equals(expected2)) {
      System.out.println("Additional test passed.");
    } else {
      System.out.println("Additional test failed.");
      System.out.println("Expected: " + expected2);
      System.out.println("Actual: " + result2);
    }
  }
}