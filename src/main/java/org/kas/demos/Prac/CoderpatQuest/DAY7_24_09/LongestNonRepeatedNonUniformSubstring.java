package org.kas.demos.Prac.CoderpatQuest.DAY7_24_09;

import java.util.HashMap;
import java.util.Map;

public class LongestNonRepeatedNonUniformSubstring {

    /**
     * Finds the length of the longest non-repeated non-uniform substring.
     * A non-uniform substring is one containing at least two different characters.
     *
     * @param s The input string.
     * @return The length of the longest valid substring, or 0 if none exists.
     */
    public static int longestNonUniformSubstring(String s) {
        // Handle edge case for null or very short strings
        if (s == null || s.length() < 2) {
            // A non-uniform substring must have at least two different characters, so length must be > 1.
            return 0;
        }

        // Map to store the last seen index of each character
        Map<Character, Integer> lastSeen = new HashMap<>();
        int maxLength = 0;
        int start = 0; // The start of the sliding window

            // Iterate through the string with the end of the window
            for (int end = 0; end < s.length(); end++) {
                char current = s.charAt(end);

                // If the character is already in the map and within the current window,
                // move the start of the window past the last occurrence of this character.
                if (lastSeen.containsKey(current)) {
                    start = Math.max(start, lastSeen.get(current) + 1);
                }

                // Update the last seen index of the current character
                lastSeen.put(current, end);

            // Calculate the current window size
            int currentLength = end - start + 1;

            // Check if the current substring is non-uniform
            // This is implicitly handled by the maxLength update and the base case.
            // A simple check is that the current length must be > 1.
            if (currentLength > 1) {
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s1 = "aaaa";     // all uniform -> no valid substring
        String s2 = "abcabcbb"; // longest = "abc" -> length 3
        String s3 = "aab";      // longest = "ab" -> length 2
        String s4 = "pwwkew";   // longest = "wke" -> length 3

        System.out.println("String: \"" + s1 + "\", Longest non-uniform substring length: " + longestNonUniformSubstring(s1));
        System.out.println("String: \"" + s2 + "\", Longest non-uniform substring length: " + longestNonUniformSubstring(s2));
        System.out.println("String: \"" + s3 + "\", Longest non-uniform substring length: " + longestNonUniformSubstring(s3));
        System.out.println("String: \"" + s4 + "\", Longest non-uniform substring length: " + longestNonUniformSubstring(s4));
    }
}
