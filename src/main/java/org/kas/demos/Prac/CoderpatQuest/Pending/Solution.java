package org.kas.demos.Prac.CoderpatQuest.Pending;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<String, Integer> memo;

    /**
     * Calculates the minimum number of characters required to encode a string
     * with repeating subsequences using a wildcard '*'.
     *
     * @param ingredients The input string of ingredients.
     * @return The minimum number of characters required for the encoded string.
     */
    public int minimalSteps(String ingredients) {
        memo = new HashMap<>();
        return solve(ingredients);
    }

    private int solve(String ingredients) {
        if (ingredients.isEmpty()) {
            return 0;
        }
        if (memo.containsKey(ingredients)) {
            return memo.get(ingredients);
        }

        int n = ingredients.length();
        int minLength = n; // Default: no compression

        // Case 1: Split the string into two smaller substrings
        for (int i = 1; i < n; i++) {
            minLength = Math.min(minLength, solve(ingredients.substring(0, i)) + solve(ingredients.substring(i)));
        }

        // Case 2: Compress a repeating subsequence with a '*'
        // Iterate through all possible lengths of a repeating subsequence
        for (int len = 1; len * 2 <= n; len++) {
            String prefix = ingredients.substring(0, len);
            if (prefix.equals(ingredients.substring(len, 2 * len))) {
                // We found a repeating subsequence, e.g., "ABAB..."
                // The encoded form starts with "A B *..."
                int currentLength = solve(prefix) + 1 + solve(ingredients.substring(2 * len));
                minLength = Math.min(minLength, currentLength);
            }
        }
        
        memo.put(ingredients, minLength);
        return minLength;
    }

    /**
     * Runs tests to check if the minimalSteps function works correctly.
     *
     * @return True if all tests pass, false otherwise.
     */
    private boolean doTestsPass() {
        return minimalSteps("ABCDABCE") == 8 && minimalSteps("ABCABCE") == 5;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        if (solution.doTestsPass()) {
            System.out.println("All tests passed.");
        } else {
            System.out.println("One or more tests failed.");
        }

        // Additional custom test case from the example
        String example = "ABAB C ABAB C E";
        String exampleNoSpaces = example.replace(" ", ""); // "ABABCABCE"
        System.out.println("Result for \"ABABCABCE\": " + solution.minimalSteps(exampleNoSpaces)); // Expected: 6 (AB*C*E)
    }
}

