package org.kas.demos.Prac.CoderpatQuest.DAY4_19_09;

import java.util.*;

/**
 * Pangram Finder
 *
 * The sentence "The quick brown fox jumps over the lazy dog" contains
 * every single letter in the alphabet. Such sentences are called pangrams.
 * Write a function findMissingLetters, which takes a String `sentence`,
 * and returns all the letters it is missing
 *
 */
class Panagram {

  private static class PanagramDetector {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    /**
     * Finds all the letters missing from a given sentence to form a pangram.
     * The method is case-insensitive.
     *
     * @param sentence The input string to check.
     * @return A string containing all the missing letters, in alphabetical order.
     */
    public String findMissingLetters(String sentence) {
     Set<Character> set = new HashSet<>();

     for(Character ch:sentence.toCharArray()){
       set.add(ch);
     }

     StringBuilder result = new StringBuilder();
     for(int i=0;i<26;i++){
       if(!set.contains((char)(i + 'a'))){
         result.append((char)('a'+i));
       }
     }
     return result.toString();
    }

  }

  public static void main(String[] args) {
    PanagramDetector pd = new PanagramDetector();
    boolean success = true;

    success = success && "".equals(pd.findMissingLetters("The quick brown fox jumps over the lazy dog"));
    success = success && "abcdefghijklmnopqrstuvwxyz".equals(pd.findMissingLetters(""));
    success = success && "hij".equals(pd.findMissingLetters("The quick brown fox jumps over the lazy dogk"));
    success = success && "pqvwxz".equals(pd.findMissingLetters("A quick brown Fox jumps over the lazy dog"));

    if (success) {
      System.out.println("Pass ");
    } else {
      System.out.println("Failed");
    }
  }
}