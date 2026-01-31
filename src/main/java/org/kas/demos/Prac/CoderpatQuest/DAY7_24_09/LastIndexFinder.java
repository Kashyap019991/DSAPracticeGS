package org.kas.demos.Prac.CoderpatQuest.DAY7_24_09;

public class LastIndexFinder {

    public static void main(String[] args) {
        String str = "programming";
        char x = 'g';
        
        int lastIndex = findLastIndex(str, x);

        if (lastIndex != -1) {
            System.out.println("The last index of '" + x + "' in the string is: " + lastIndex);
        } else {
            System.out.println("The character '" + x + "' was not found in the string.");
        }
    }

    /**
     * Manually finds the last index of a character in a string by iterating backwards.
     * @param str The input string.
     * @param x The character to find.
     * @return The last index of the character, or -1 if not found.
     */
    public static int findLastIndex(String str, char x) {
        // Iterate backward from the end of the string to the beginning.
        // We use str.length() - 1 to get the index of the last character.
        // The loop continues as long as i is greater than or equal to 0.
        for (int i = str.length() - 1; i >= 0; i--) {
            // Get the character at the current index.
            // str.charAt(i) is a built-in method but is a fundamental operation
            // for accessing a character by index, which is usually allowed even
            // in "no built-in functions" constraints for this type of problem.
            if (str.charAt(i) == x) {
                // If a match is found, we have found the last occurrence.
                // Return the current index immediately.
                return i;
            }
        }
        
        // If the loop completes without finding the character, it means
        // the character does not exist in the string.
        // Return -1 to indicate that the character was not found.
        return -1;
    }
}
