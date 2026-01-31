package org.kas.demos.Prac.CoderpatQuest.DAY8_25_09;

import java.util.ArrayList;
import java.util.List;
//Given a string and a delimiter character. Split the string based on the delimiter and print the list of resulting sub strings.
public class ManualSplitExample {

    public static void main(String[] args) {
        // The input string.
        String str = "This,is,a,test,string";
        
        // The delimiter character.
        char delimiter = ',';

        // Call the custom split function.
        List<String> substrings = splitString(str, delimiter);

        // Print the resulting list of substrings.
        System.out.println("Resulting substrings:");
        for (String sub : substrings) {
            System.out.println(sub);
        }
    }

    /**
     * Splits a string based on a delimiter character and returns a list of substrings.
     * This implementation avoids using the built-in String.split() method.
     *
     * @param str The string to be split.
     * @param delimiter The character used to split the string.
     * @return A list of substrings.
     */
    public static List<String> splitString(String str, char delimiter) {
        List<String> result = new ArrayList<>();
        StringBuilder currentSubstring = new StringBuilder();

        // Handle edge case for null or empty input strings.
        if (str == null || str.isEmpty()) {
            return result;
        }

        // Iterate through each character of the string.
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            // If the current character is the delimiter, and the currentSubstring is not empty,
            // add the built-up substring to the list and reset the StringBuilder.
            if (currentChar == delimiter) {
                if (currentSubstring.length() > 0) {
                    result.add(currentSubstring.toString());
                    currentSubstring.setLength(0); // Reset the StringBuilder
                }
            } else {
                // If it's not the delimiter, append the character to the current substring.
                currentSubstring.append(currentChar);
            }
        }

        // After the loop, add any remaining characters to the list.
        // This handles the last substring and the case where there is no delimiter.
        if (currentSubstring.length() > 0) {
            result.add(currentSubstring.toString());
        }

        return result;
    }
}
