package org.kas.demos.Prac.CoderpatQuest.DAY5_22_09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
Set of anagrams of list of words.
The output should be words which are anagrams from the list should be grouped together.
 */
public class AnagramGrouper {

    /**
     * Groups a list of words into lists of anagrams.
     *
     * @param words The list of strings to be grouped.
     * @return A list of lists, where each inner list contains anagrams.
     */
    public static List<List<String>> groupAnagrams(List<String> words) {
        if (words == null || words.isEmpty()) {
            return new ArrayList<>();
        }

        // A HashMap to store anagrams. The key is the sorted version of a word,
        // and the value is a list of all words that have that same sorted version.
        Map<String, List<String>> anagramGroups = new HashMap<>();

        // Iterate through each word in the input list.
        for (String word : words) {
            // Convert the word to a character array to sort it.
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            
            // Create the sorted string, which will serve as the canonical key.
            String sortedWord = new String(charArray);

            // Get the list of words for this key. If the key is not in the map,
            // computeIfAbsent creates a new empty list for it.
            List<String> group = anagramGroups.computeIfAbsent(sortedWord, k -> new ArrayList<>());
            
            // Add the original word to the corresponding list.
            group.add(word);
        }

        // The values of the map are the lists of anagrams.
        return new ArrayList<>(anagramGroups.values());
    }

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");
        
        System.out.println("Original words: " + wordList);
        
        List<List<String>> groupedAnagrams = groupAnagrams(wordList);
        
        System.out.println("Grouped anagrams: " + groupedAnagrams);
        
        // Example output: [[eat, tea, ate], [tan, nat], [bat]]
        // The order of the inner and outer lists is not guaranteed due to the nature of HashMap.
    }
}
