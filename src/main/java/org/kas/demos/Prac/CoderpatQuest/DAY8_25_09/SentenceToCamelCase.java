package org.kas.demos.Prac.CoderpatQuest.DAY8_25_09;

public class SentenceToCamelCase {

    /**
     * Converts a sentence to PascalCase by removing spaces and capitalizing the first
     * letter of each word.
     * 
     * @param sentence The input sentence string.
     * @return The sentence converted to PascalCase.
     */
    public static String toPascalCase(String sentence) {
        // Handle null or empty input sentences.
        if (sentence == null || sentence.isEmpty()) {
            return "";
        }

        // Use a StringBuilder for efficient string concatenation.
        StringBuilder result = new StringBuilder();

        // Split the sentence into an array of words using space as a delimiter.
        // The regex "\\s+" handles one or more spaces between words.
        String[] words = sentence.trim().split("\\s+");

        // Iterate through each word in the array.
        for (String word : words) {
            // Check if the word is not empty to avoid errors with multiple spaces.
            if (!word.isEmpty()) {
                // Capitalize the first letter of the word.
                // Convert the rest of the word to lowercase.
                String capitalizedWord = word.substring(0, 1).toUpperCase() +
                                         word.substring(1).toLowerCase();
                
                // Append the capitalized word to the result.
                result.append(capitalizedWord);
            }
        }

        // Return the final string.
        return result.toString();
    }

    public static void main(String[] args) {
        String sentence1 = "this is a sample sentence";
        String sentence2 = "   convert to  camel case   ";
        String sentence3 = "already-in-camel-case";

        System.out.println("Original: '" + sentence1 + "'");
        System.out.println("Converted: " + toPascalCase(sentence1)); // Output: ThisIsASampleSentence

        System.out.println("\nOriginal: '" + sentence2 + "'");
        System.out.println("Converted: " + toPascalCase(sentence2)); // Output: ConvertToCamelCase

        System.out.println("\nOriginal: '" + sentence3 + "'");
        System.out.println("Converted: " + toPascalCase(sentence3)); // Output: Already-in-camel-case (Note: Hyphens are not spaces and will be treated as part of a word)
    }
}
