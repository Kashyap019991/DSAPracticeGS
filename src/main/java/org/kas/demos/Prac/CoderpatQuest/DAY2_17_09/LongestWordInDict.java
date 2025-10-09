package org.kas.demos.Prac.CoderpatQuest.DAY2_17_09;

import java.util.*;

class Dictionary {
  private String[] entries;

  public Dictionary(String[] entries) {
    this.entries = entries;
  }

  public boolean contains(String word) {
    return Arrays.asList(entries).contains(word);
  }

  /**
   * Returns all words in the dictionary.
   * This is a helper method to expose the dictionary entries for processing.
   *
   * @return The array of words in the dictionary.
   */
  public String[] getEntries() {
    return this.entries;
  }
}

public class LongestWordInDict {
  /**
   * Finds the longest word or words in the dictionary that can be made from a given set of letters.
   * This involves checking each dictionary word to see if it can be formed using the
   * available letters, and then keeping track of the longest ones found.
   *
   * @param letters The string containing the available letters.
   * @param dict The dictionary of valid words.
   * @return A Set of the longest words that can be formed.
   */
  public static Set<String> longestWord(String letters, Dictionary dict) {
    Set<String> result = new HashSet<>();
    int maxLength = 0;
/*
Dictionary dict ={"to", "toe", "toes", "doe", "dog", "god", "dogs", "banana"});
 Set<String> expected4 = new HashSet<>(Arrays.asList("doe", "dog", "god"));
    longestWord("oedg")
 */
    // Create a frequency map of the available letters for quick lookups.
    Map<Character, Integer> letterCount = new HashMap<>();
    for (char c : letters.toCharArray()) {
      letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
    }

    // Iterate through each word in the dictionary to check if it's a valid match.
    for (String word : dict.getEntries()) {
      // Check if the current word can be formed from the given letters.
      if (canFormWord(word, letterCount)) {
        // If the word is longer than the current max length, clear the result set
        // and add the new, longer word.
        if (word.length() > maxLength) {
          maxLength = word.length();
          result.clear();
          result.add(word);
        } else if (word.length() == maxLength) {
          // If the word has the same length as the current longest, add it to the set.
          result.add(word);
        }
      }
    }

    return result;
  }

  /**
   * Checks if a word can be formed using the available letters.
   * It uses a frequency map of the letters to ensure the correct number of each
   * character is used and that no extra characters are needed.
   *
   * @param word The word to check.
   * @param letterCount A map containing the frequency of each available letter.
   * @return true if the word can be formed, false otherwise.
   */
  private static boolean canFormWord(String word, Map<Character, Integer> letterCount) {
    Map<Character, Integer> tempLetterCount = new HashMap<>(letterCount);
    for (char c : word.toCharArray()) {
      if (tempLetterCount.getOrDefault(c, 0) == 0) {
        // Not enough of this letter, so the word cannot be formed.
        return false;
      }
      // Decrement the count for the current letter.
      tempLetterCount.put(c, tempLetterCount.get(c) - 1);
    }
    return true;
  }

  public static boolean pass() {
    Dictionary dict = new Dictionary(new String[]{"to", "toe", "toes", "doe", "dog", "god", "dogs", "banana"});
    
    // Test case 1: "toe"
    Set<String> expected1 = new HashSet<>(Arrays.asList("toe"));
    Set<String> result1 = longestWord("oet", dict);
    if (!expected1.equals(result1)) {
        System.err.println("Test case 'oet' failed. Expected: " + expected1 + ", Got: " + result1);
        return false;
    }

    // Test case 2: "oetx" - checks for words that cannot be formed
    Set<String> expected2 = new HashSet<>(Arrays.asList("toe"));
    Set<String> result2 = longestWord("oetx", dict);
    if (!expected2.equals(result2)) {
        System.err.println("Test case 'oetx' failed. Expected: " + expected2 + ", Got: " + result2);
        return false;
    }

    // Test case 3: "oest" - multiple longest words
    Set<String> expected3 = new HashSet<>(Arrays.asList("toes"));
    Set<String> result3 = longestWord("oest", dict);
    if (!expected3.equals(result3)) {
        System.err.println("Test case 'oest' failed. Expected: " + expected3 + ", Got: " + result3);
        return false;
    }

    // Test case 4: "oedg" - checks for multiple longest words of same length
    Set<String> expected4 = new HashSet<>(Arrays.asList("doe", "dog", "god"));
    Set<String> result4 = longestWord("oedg", dict);
    if (!expected4.equals(result4)) {
        System.err.println("Test case 'oedg' failed. Expected: " + expected4 + ", Got: " + result4);
        return false;
    }

    // The original test case from the starter code
    Set<String> expected5 = new HashSet<>(Arrays.asList("toe"));
    Set<String> result5 = longestWord("toe", dict);
    if (!expected5.equals(result5)) {
        System.err.println("Test case 'toe' failed. Expected: " + expected5 + ", Got: " + result5);
        return false;
    }


    return true;
  }

  public static void main(String[] args) {
    if(pass()) {
      System.out.println("Pass");
    } else {
      System.err.println("Fails");
    }
  }
}