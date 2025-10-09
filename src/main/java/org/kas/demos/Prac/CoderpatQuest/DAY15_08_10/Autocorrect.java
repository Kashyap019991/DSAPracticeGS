package org.kas.demos.Prac.CoderpatQuest.DAY15_08_10;
/*
create chatbot feature in whichyou have dictionary list and one String array input which consist of misspelled words. You need to auto correct the words if it is available in list.

List<String> wordList = Arrays.asList("i", "live", "in", "mumbai", "india");
String[] input = {"i", "lvie", "ni", "mumbai"};

o/p -> Auto-corrected sentence: i live in mumbai.
 */
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.StringJoiner;

public class Autocorrect {

    /**
     * Finds the closest word in the dictionary to the misspelled word based on edit distance.
     * The Levenshtein distance is used to calculate the number of single-character edits
     * (insertions, deletions, or substitutions) required to change one word into the other.
     *
     * @param misspelledWord The word to correct.
     * @param dictionary The list of correctly spelled words.
     * @return The corrected word, or the original word if no close match is found.
     */
    private static String findClosestWord(String misspelledWord, Set<String> dictionary) {
        String closestWord = misspelledWord;
        int minDistance = Integer.MAX_VALUE;

        for (String correctWord : dictionary) {
            int distance = levenshteinDistance(misspelledWord, correctWord);
            if (distance < minDistance) {
                minDistance = distance;
                closestWord = correctWord;
            }
        }
        return closestWord;
    }

    /**
     * Calculates the Levenshtein distance between two strings.
     *
     * @param word1 The first word.
     * @param word2 The second word.
     * @return The Levenshtein distance.
     */
    private static int levenshteinDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    int cost = (word1.charAt(i - 1) == word2.charAt(j - 1)) ? 0 : 1;
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + cost);
                }
            }
        }
        return dp[m][n];
    }

    /**
     * Autocorrects a sentence based on a provided dictionary.
     *
     * @param input An array of strings with potentially misspelled words.
     * @param wordList The dictionary of correctly spelled words.
     * @return An autocorrected sentence string.
     */
    public static String autocorrectSentence(String[] input, List<String> wordList) {
        // Use a Set for the dictionary for faster lookups (O(1) average time).
        Set<String> dictionary = wordList.stream().collect(Collectors.toSet());
        StringJoiner correctedSentence = new StringJoiner(" ");

        for (String word : input) {
            String lowercaseWord = word.toLowerCase();
            // Check if the lowercase word is in the dictionary.
            if (dictionary.contains(lowercaseWord)) {
                correctedSentence.add(word); // Word is correct, keep it.
            } else {
                // Word is misspelled, find the closest match.
                String correctedWord = findClosestWord(lowercaseWord, dictionary);
                correctedSentence.add(correctedWord);
            }
        }
        return correctedSentence.toString();
    }

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("i", "live", "in", "mumbai", "india");
        String[] input = {"i", "lvie", "ni", "mumbai"};

        String output = autocorrectSentence(input, wordList);
        System.out.println("Auto-corrected sentence: " + output);
    }
}
