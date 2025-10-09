package org.kas.demos.Prac.CoderpatQuest.DAY5_22_09;

public class PalindromeLargest {

    // These variables need to be instance variables to be modified by a helper method.
    private int start = 0;
    private int maxLength = 1;

    /**
     * Finds the longest palindromic substring in a given string.
     *
     * @param s The input string.
     * @return The longest palindromic substring.
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        // Iterate through each character of the string.
        for (int i = 0; i < s.length(); i++) {
            // Case 1: Odd-length palindromes, with 'i' as the center.
            expandAroundCenter(s, i, i);

            // Case 2: Even-length palindromes, with 'i' and 'i+1' as the center.
            expandAroundCenter(s, i, i + 1);
        }

        // Return the substring based on the longest palindrome found.
        return s.substring(start, start + maxLength);
    }

    /**
     * Helper method to expand around a center and update the longest palindrome.
     *
     * @param s The input string.
     * @param left The left pointer.
     * @param right The right pointer.
     */
    private void expandAroundCenter(String s, int left, int right) {
        // Expand while the pointers are within bounds and characters match.
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                start = left;
            }
            left--;
            right++;
        }
    }

    public static void main(String[] args) {
        PalindromeLargest solver = new PalindromeLargest();

        String input1 = "babad";
        System.out.println("Input: \"" + input1 + "\", Longest Palindrome: \"" + solver.longestPalindrome(input1) + "\""); // "bab" or "aba"
        solver.reset(); // Reset state for next test

        String input2 = "cbbd";
        System.out.println("Input: \"" + input2 + "\", Longest Palindrome: \"" + solver.longestPalindrome(input2) + "\""); // "bb"
        solver.reset();

        String input3 = "a";
        System.out.println("Input: \"" + input3 + "\", Longest Palindrome: \"" + solver.longestPalindrome(input3) + "\""); // "a"
        solver.reset();

        String input4 = "racecar";
        System.out.println("Input: \"" + input4 + "\", Longest Palindrome: \"" + solver.longestPalindrome(input4) + "\""); // "racecar"
        solver.reset();
    }

    private void reset() {
        this.start = 0;
        this.maxLength = 1;
    }
}
