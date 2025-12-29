package org.kas.demos.Prac.CoderpatQuest.DAY25_28_10;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FrequencySorter {

    public static List<Integer> processArrayByFrequency(int[] array) {
        // Step 1: Count the frequency of each element and store it in a map.
        Map<Integer, Long> frequencyMap = IntStream.of(array).boxed()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        Arrays.stream(array).boxed().collect(Collectors.groupingBy(e->e,Collectors.counting()));
        // Step 2: Get a sorted list of unique frequencies.
        List<Long> sortedFrequencies = frequencyMap.values().stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        // Step 3 & 4: Process frequencies and collect results.
        return sortedFrequencies.stream()
                .flatMap(freq -> frequencyMap.entrySet().stream()
                        .filter(entry -> entry.getValue().equals(freq))
                        .map(Map.Entry::getKey)
                        .min(Comparator.naturalOrder()) // Find the smallest element for this frequency.
                        .stream()) // Convert Optional to Stream.
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {2, 1, 3, 4, 1, 5, 5, 5, 3, 4, 6, 3, 8, 8, 8, 8};
        List<Integer> result1 = processArrayByFrequency(arr1);
        System.out.println("Input: " + Arrays.toString(arr1));
        System.out.println("Output: " + result1); // Expected: [2, 6, 1, 4, 3, 5, 8] but the tie-breaking rule needs adjustment.

        // Let's re-evaluate the tie-breaking rule based on the expected output:
        // Frequency 1: elements are 2, 6. Smaller is 2. Result so far: [2, 6].
        // Frequency 2: elements are 1, 4. Smaller is 1. Result so far: [2, 6, 1].
        // Frequency 3: elements are 3, 5. Smaller is 3. Result so far: [2, 6, 1, 3].
        // Frequency 4: element is 8. Result so far: [2, 6, 1, 3, 8].

        // Let's adjust the logic to follow the specified tie-breaking exactly.
        System.out.println("\n--- Adjusted Logic based on expected output [2, 6, 1, 3, 8] ---");
        List<Integer> adjustedResult1 = processWithAdjustedLogic(arr1);
        System.out.println("Output: " + adjustedResult1);

        // Test case 2
        int[] arr2 = {2, 1, 6, 1, 2};
        List<Integer> result2 = processWithAdjustedLogic(arr2);
        System.out.println("\nInput: " + Arrays.toString(arr2));
        System.out.println("Output: " + result2); // Expected: [6, 1]

        // Additional Test Case
        int[] arr3 = {10, 20, 10, 30, 20, 40};
        List<Integer> result3 = processWithAdjustedLogic(arr3);
        System.out.println("\nInput: " + Arrays.toString(arr3));
        System.out.println("Output: " + result3); // Expected: [30, 40, 10, 20]
    }

    private static List<Integer> processWithAdjustedLogic(int[] array) {
        // Step 1: Count element frequencies
        Map<Integer, Long> frequencyMap = IntStream.of(array).boxed()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        // Step 2 & 3: Group elements by frequency and sort the frequencies
        return frequencyMap.entrySet().stream()
                .collect(Collectors.groupingBy(
                        Map.Entry::getValue,
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())
                ))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey()) // Sort by frequency (ascending)
                .flatMap(entry -> {
                    List<Integer> elementsWithSameFreq = entry.getValue();
                    // Custom logic for tie-breaking
                    if (elementsWithSameFreq.size() > 1) {
                        return elementsWithSameFreq.stream()
                                .min(Comparator.naturalOrder()) // Take only the smaller element.
                                .stream();
                    } else {
                        return elementsWithSameFreq.stream();
                    }
                })
                .sorted() // Sort elements within frequency group (e.g., [2, 6]
                .collect(Collectors.toList());
    }
}
