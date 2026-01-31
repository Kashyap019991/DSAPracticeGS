package org.kas.demos.Prac.CoderpatQuest.DAY8_25_09;

public class CombineIngredientsPotionEncoder {

    /**
     * Calculates the minimum number of characters required to encode a potion string.
     * The encoding uses a '*' to represent repeated subsequences.
     *
     * @param potion The un-encoded potion string.
     * @return The minimum number of characters required for the encoded string.
     */
    public int encodePotion(String potion) {
        if (potion == null || potion.isEmpty()) {
            return 0;
        }

        int n = potion.length();
        int[] dp = new int[n + 1];

        // Base case: a single character is encoded as itself.
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                // Check if the substring from j to i is a perfect repeat of an earlier part.
                String sub = potion.substring(j - 1, i);
                int subLength = sub.length();
                
                // Repeated length must be even and repeat must be identical.
                if (subLength % 2 == 0) {
                    String half1 = sub.substring(0, subLength / 2);
                    String half2 = sub.substring(subLength / 2);
                    
                    if (half1.equals(half2)) {
                        // The pattern repeats, e.g., "ABAB" can be encoded from "AB".
                        int repeatLength = dp[j - 1] + dp[subLength / 2] + 1; // +1 for the '*'
                        dp[i] = Math.min(dp[i], repeatLength);
                    }
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        CombineIngredientsPotionEncoder encoder = new CombineIngredientsPotionEncoder();

        String potion1 = "ABABCABABC";
        // "ABABC" repeats, so it's "ABABC*".
        // Encoded from "ABABC" -> A, B, A, B, C
        // and then combined "ABABC" * -> (A, B, *, C) *
        // Example given in question is simplified
        System.out.println("Potion: " + potion1);
        System.out.println("Minimum characters required: " + encoder.encodePotion(potion1)); // Expected: 6 (A,B,*,C,*,E) (adjusted to problem logic)
        
        String potion2 = "ABCDE";
        // No repeats.
        System.out.println("\nPotion: " + potion2);
        System.out.println("Minimum characters required: " + encoder.encodePotion(potion2)); // Expected: 5

        String potion3 = "ABCABCE";
        // "ABC" repeats.
        System.out.println("\nPotion: " + potion3);
        System.out.println("Minimum characters required: " + encoder.encodePotion(potion3)); // Expected: 5 ("ABC*E")

        String potion4 = "AAAAAAAA";
        // Single character repeat.
        System.out.println("\nPotion: " + potion4);
        System.out.println("Minimum characters required: " + encoder.encodePotion(potion4)); // Expected: 2 ("A*")
    }
}
