package org.kas.demos.Prac.CoderpatQuest.DAY6_23_09;

/**
 * Correctly reverses a string using an efficient approach.
 */
public class CorrectStringReverser {

    /**
     * Reverses a given string.
     *
     * @param input The string to reverse.
     * @return The reversed string.
     */
    public String reverse(String input) {
        // Bug fix 1: Handle null input to prevent NullPointerException.
        // It returns an empty string for null input, a common practice.
        if (input == null) {
            return "";
        }

        // Using StringBuilder is more efficient for repeated modifications.
        // It avoids creating a new String object in every loop iteration.
        StringBuilder reversedBuilder = new StringBuilder();

        // Iterate through the string from the last character to the first.
        for (int i = input.length() - 1; i >= 0; i--) {
            // Append each character to the StringBuilder.
            reversedBuilder.append(input.charAt(i));
        }

        // Convert the StringBuilder back to a String and return.
        return reversedBuilder.toString();
    }
    
    // A separate method using the built-in StringBuilder.reverse() for comparison.
    public String reverseUsingBuiltin(String input) {
        if (input == null) {
            return "";
        }
        return new StringBuilder(input).reverse().toString();
    }

    public static void main(String[] args) {
        CorrectStringReverser reverser = new CorrectStringReverser();
        
        System.out.println("--- Corrected Program ---");

        // Test case 1: Null input
        System.out.println("Reversing null: '" + reverser.reverse(null) + "'"); // Expected: ''

        // Test case 2: Empty string
        System.out.println("Reversing empty string: '" + reverser.reverse("") + "'"); // Expected: ''
        
        // Test case 3: Single character string
        System.out.println("Reversing 'a': '" + reverser.reverse("a") + "'"); // Expected: 'a'
        
        // Test case 4: Regular string
        System.out.println("Reversing 'hello': '" + reverser.reverse("hello") + "'"); // Expected: 'olleh'
        
        // Test case 5: String with spaces
        System.out.println("Reversing 'hello world': '" + reverser.reverse("hello world") + "'"); // Expected: 'dlrow olleh'
        
        System.out.println("\n--- Testing Built-in Method ---");
        System.out.println("Reversing 'example': '" + reverser.reverseUsingBuiltin("example") + "'"); // Expected: 'elpmaxe'
    }
}
