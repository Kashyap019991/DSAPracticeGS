package org.kas.demos.Prac.CoderpatQuest.DAY25_28_10;

public class LongestUniformSubstring {

    /**
     * Finds the length of the longest uniform substring in a given string.
     * A uniform substring is one where all characters are identical.
     *
     * @param s The input string.
     * @return The length of the longest uniform substring, or 0 if the string is empty.
     */
    public static int findLongestUniformSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int maxLength = 0;
        int currentLength = 0;
        char currentChar = ' '; // Initialize with a dummy character

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
//"aabbbbbCdAA"
            if (i == 0 || c == currentChar) {
                // If it's the first character or the same as the previous one
                currentLength++;
            } else {
                // If the character changes, update maxLength and reset currentLength
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1;
            }
            currentChar = c; // Update the current character
        }

        // After the loop, compare maxLength with the last currentLength
        maxLength = Math.max(maxLength, currentLength);

        return maxLength;
    }

    public static void main(String[] args) {
        String s1 = "aabbbbbCdAA";
        System.out.println("Longest uniform substring in \"" + s1 + "\": " + findLongestUniformSubstring(s1)); // Expected: 5 (for 'bbbbb')

        String s2 = "abcde";
        System.out.println("Longest uniform substring in \"" + s2 + "\": " + findLongestUniformSubstring(s2)); // Expected: 1

        String s3 = "aaaaa";
        System.out.println("Longest uniform substring in \"" + s3 + "\": " + findLongestUniformSubstring(s3)); // Expected: 5

        String s4 = "";
        System.out.println("Longest uniform substring in \"" + s4 + "\": " + findLongestUniformSubstring(s4)); // Expected: 0

        String s5 = "10000111";
        System.out.println("Longest uniform substring in \"" + s5 + "\": " + findLongestUniformSubstring(s5)); // Expected: 4 (for '0000')
    }
}