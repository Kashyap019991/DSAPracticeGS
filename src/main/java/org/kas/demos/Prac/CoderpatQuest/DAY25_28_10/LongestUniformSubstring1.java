package org.kas.demos.Prac.CoderpatQuest.DAY25_28_10;

public class LongestUniformSubstring1 {

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
        int currentLength = 1;
        char currentChar = ' '; // Initialize with a dummy character
        int n = s.length();
        for (int i = 0; i < n; i++) {

//"aabbbbbCdAA"
// abcde
            if (i+1 < n && s.charAt(i) == s.charAt(i+1)) {
                currentLength++;

            } else {

                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1;
            }
             // Update the current character
        }

        // After the loop, compare maxLength with the last currentLength
        maxLength = Math.max(maxLength, currentLength);

        return maxLength;
    }

    public static void main(String[] args) {
        String s1 = "aabbbbbCdAA";
        System.out.println("Longest uniform substring in \"" + s1 + "\": " + findLongestUniformSubstring(s1)); // Expected: 5 (for 'bbbbb')

        String s2 = "abcdee";
        System.out.println("Longest uniform substring in \"" + s2 + "\": " + findLongestUniformSubstring(s2)); // Expected: 1

        String s3 = "aaaaa";
        System.out.println("Longest uniform substring in \"" + s3 + "\": " + findLongestUniformSubstring(s3)); // Expected: 5

        String s4 = "";
        System.out.println("Longest uniform substring in \"" + s4 + "\": " + findLongestUniformSubstring(s4)); // Expected: 0

        String s5 = "10000111";
        System.out.println("Longest uniform substring in \"" + s5 + "\": " + findLongestUniformSubstring(s5)); // Expected: 4 (for '0000')
    }
}