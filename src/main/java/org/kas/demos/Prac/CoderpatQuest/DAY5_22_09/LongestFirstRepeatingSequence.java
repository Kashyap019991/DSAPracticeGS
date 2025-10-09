package org.kas.demos.Prac.CoderpatQuest.DAY5_22_09;

public class LongestFirstRepeatingSequence {

    /**
     * Finds the starting index and length of the longest consecutive sequence of repeating characters.
     * If multiple sequences have the same maximum length, it returns the details of the first one found.
     *
     * @param s The input string.
     * @return An integer array where the first element is the index and the second is the length.
     *         Returns [-1, 0] if the string is empty or null, or if no repeating characters exist.
     */
    public static int[] findLongestFirstRepeating(String s) {
        if (s == null || s.length() == 0) {
            return new int[]{-1, 0};
        }

        int longestLength = 1;      // Length of the longest sequence found so far.
        int longestIndex = 0;       // Starting index of the longest sequence.
        int currentLength = 1;      // Length of the current consecutive sequence.
        int currentIndex = 0;       // Starting index of the current sequence.

        // Iterate through the string starting from the second character.
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                // If the current character is the same as the previous one, extend the current sequence.
                currentLength++;
            } else {
                // The current consecutive sequence has ended.
                // Check if this sequence was the longest found so far.
                // We use '>' to find the *first* longest sequence.
                if (currentLength > longestLength) {
                    longestLength = currentLength;
                    longestIndex = currentIndex;
                }
                // Reset the current sequence for the new character.
                currentLength = 1;
                currentIndex = i;
            }
        }

        // After the loop, perform a final check for the last sequence.
        if (currentLength > longestLength) {
            longestLength = currentLength;
            longestIndex = currentIndex;
        }
        
        // If no repetitions were found (all characters are unique), handle edge cases.
        if (longestLength == 1 && s.length() > 0) {
             // If all characters are unique, there's no repeating sequence.
             // The problem asks for the longest *repeating* index, so we should return an indicator
             // that no repetition was found. A repeating sequence requires a length of at least 2.
             return new int[]{-1, 0};
        }

        return new int[]{longestIndex, longestLength};
    }

    public static void main(String[] args) {
        String input1 = "aabbbbddcc";
        int[] result1 = findLongestFirstRepeating(input1);
        System.out.println("Input: \"" + input1 + "\" Output: [" + result1[0] + "," + result1[1] + "]"); // Expected: [2, 4]

        String input2 = "aaabbbccc";
        int[] result2 = findLongestFirstRepeating(input2);
        System.out.println("Input: \"" + input2 + "\" Output: [" + result2[0] + "," + result2[1] + "]"); // Expected: [0, 3]

        String input3 = "abcde";
        int[] result3 = findLongestFirstRepeating(input3);
        System.out.println("Input: \"" + input3 + "\" Output: [" + result3[0] + "," + result3[1] + "]"); // Expected: [-1, 0]

        String input4 = "aabbaa";
        int[] result4 = findLongestFirstRepeating(input4);
        System.out.println("Input: \"" + input4 + "\" Output: [" + result4[0] + "," + result4[1] + "]"); // Expected: [2, 2]
    }
}
