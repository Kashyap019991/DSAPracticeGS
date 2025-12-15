package org.kas.demos.Prac.CoderpatQuest.DAY4_19_09;

import java.util.*;

/*
 * This program prints set of anagrams together in given string 
 * 
 * eg. 
 * setOfAnagrams("cat dog tac sat tas god dog") should print "cat tac dog god dog sat tas"
 *
 */

class GroupAnagram {
  
  static String input = "cat dog tac sat tas god dog";
  
  /**
   * Groups and prints anagrams from a given string.
   *
   * @param inputString The string containing space-separated words.
   */
  static void setOfAnagrams(String inputString) {
    // 1. Split the input string into an array of words.
    String[] words = inputString.split(" ");
    
    // 2. Use a HashMap to store sorted words as keys and a list of
    // their anagrams as values.
    Map<String, List<String>> anagramGroups = new HashMap<>();

    // 3. Iterate over the words to group them.
    for (String word : words) {
      // Create a sorted version of the word to use as a key.
      char[] charArray = word.toCharArray();
      Arrays.sort(charArray);
      String sortedWord = new String(charArray);
      //cat dog tac sat tas god dog
      // Get the list of words for this sorted key, or create a new list if it doesn't exist.
      List<String> group = anagramGroups.getOrDefault(sortedWord, new ArrayList<>());
      
      // Add the original word to the list.
      group.add(word);
      
      // Put the updated list back into the map.
      anagramGroups.put(sortedWord, group);
    }
    
    // 4. Print the sets of anagrams.
    for (List<String> group : anagramGroups.values()) {
      // Use a StringBuilder to format the output string efficiently.
      StringBuilder sb = new StringBuilder();
      for (String word : group) {
        sb.append(word).append(" ");
      }
      System.out.println(sb.toString().trim());
    }
  }
  
  
  public static void main(String[] args) {
    
    String input = "cat dog tac sat tas god dog";
    setOfAnagrams(input);
    
  }
}
