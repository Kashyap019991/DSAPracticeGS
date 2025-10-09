package org.kas.demos.Prac.CoderpatQuest.DAY4_19_09;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatChar {

  /**
  * Finds the first character that does not repeat anywhere in the input string.
  * The method uses a LinkedHashMap to store character counts while preserving
  * the order of insertion. It performs two passes over the data: one to
  * count frequencies and a second to find the first character with a count of one.
  *
  * @param input The input string to search.
  * @return The first non-repeating character. Returns a null character ('\0') if no such character exists.
  **/        
  public static char findFirst(String input) {
    // A LinkedHashMap is used to store characters and their frequencies,
    // maintaining the order of insertion.
    Map<Character, Integer> charFrequencies = new LinkedHashMap<>();

    // First pass: Populate the map with character frequencies.
    for (char ch : input.toCharArray()) {
      charFrequencies.put(ch, charFrequencies.getOrDefault(ch, 0) + 1);
    }

    // Second pass: Iterate through the map entries to find the first character
    // with a frequency of 1. Because LinkedHashMap preserves insertion order,
    // the first entry we find with a count of 1 is the answer.
    for (Map.Entry<Character, Integer> entry : charFrequencies.entrySet()) {
      if (entry.getValue() == 1) {
        return entry.getKey();
      }
    }

    // If no non-repeating character is found, return a null character.
    return '\0';
  }

  public static void main(String args[]) {
    String[] inputs = {"apple", "racecars", "ababdc", "zzzz"};
    char[] outputs = {'a', 'e', 'd', '\0'};

    boolean result = true;
    for(int i = 0; i < inputs.length; i++ ) {
      char foundChar = findFirst(inputs[i]);
      result = result && (foundChar == outputs[i]);
      if(foundChar != outputs[i])
        System.out.println("Test failed for: \"" + inputs[i] + "\". Expected: '" + outputs[i] + "', Got: '" + foundChar + "'");
      else
        System.out.println("Test passed for: \"" + inputs[i] + "\"");
    }
    if(result) {
        System.out.println("\nAll tests passed!");
    } else {
        System.out.println("\nSome tests failed.");
    }
  }
}
