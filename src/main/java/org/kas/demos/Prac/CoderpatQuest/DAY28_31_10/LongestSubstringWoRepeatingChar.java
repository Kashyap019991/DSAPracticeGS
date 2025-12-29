package org.kas.demos.Prac.CoderpatQuest.DAY28_31_10;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWoRepeatingChar {

    /**
     * Finds the length of the longest substring without repeating characters.
     * Uses an optimized sliding window with a HashMap.
     *
     * @param s The input string.
     * @return The length of the longest substring with all unique characters.
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // HashMap to store the last seen index of each character
        // Key: Character, Value: Index
        Map<Character, Integer> charToIndexMap = new HashMap<>();
        int maxLength = 0;
        // 'start' pointer defines the beginning of the current substring (window)
        int start = 0;

        // 'end' pointer iterates through the string
        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);
            //charToIndexMap.get(currentChar) >= start) for case "abba"
            // If the character is already in the map and within the current window (start <= index)
            if (charToIndexMap.containsKey(currentChar) && charToIndexMap.get(currentChar) >= start) {
                // Move the start pointer to the index right after the last occurrence
                start = charToIndexMap.get(currentChar) + 1;
            }

            // Update the map with the current character's last seen index
            charToIndexMap.put(currentChar, end);

            // Calculate the length of the current substring and update max length
            // Current length is (end - start + 1)
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        System.out.println("Input: \"" + s1 + "\"");
        System.out.println("Length of longest substring without repeating characters: " + lengthOfLongestSubstring(s1)); // Output: 3 ("abc")

        System.out.println("---");

        String s2 = "bbbbb";
        System.out.println("Input: \"" + s2 + "\"");
        System.out.println("Length of longest substring without repeating characters: " + lengthOfLongestSubstring(s2)); // Output: 1 ("b")

        System.out.println("---");
        
        String s3 = "pwwkew";
        System.out.println("Input: \"" + s3 + "\"");
        System.out.println("Length of longest substring without repeating characters: " + lengthOfLongestSubstring(s3)); // Output: 3 ("wke")
        
        System.out.println("---");

        String s4 = "abcbdef";
        System.out.println("Input: \"" + s4 + "\"");
        System.out.println("Length of longest substring without repeating characters: " + lengthOfLongestSubstring(s4)); // Output: 5 ("cbdef")
    }
}
