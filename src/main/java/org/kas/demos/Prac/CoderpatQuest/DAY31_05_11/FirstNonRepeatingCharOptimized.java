package org.kas.demos.Prac.CoderpatQuest.DAY31_05_11;

public class FirstNonRepeatingCharOptimized {

    public static Character findFirstNonRepeatingOptimized(String str) {
        // Assuming ASCII character set (0 to 255)
        int[] frequency = new int[256]; 

        // First pass: Count character frequencies
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            frequency[c]++;
        }

        // Second pass: Find the first character with a frequency of 1
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (frequency[c] == 1) {
                return c;
            }
        }

        return null;
    }
    // Main method same as above...
}
