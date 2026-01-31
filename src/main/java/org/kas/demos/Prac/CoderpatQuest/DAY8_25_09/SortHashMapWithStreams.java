package org.kas.demos.Prac.CoderpatQuest.DAY8_25_09;

import java.util.HashMap;
import java.util.Map;

public class SortHashMapWithStreams {
    public static void main(String[] args) {
        // 1. Create a HashMap and populate it.
        Map<String, Integer> unsortedMap = new HashMap<>();
        unsortedMap.put("Apple", 100);
        unsortedMap.put("Banana", 150);
        unsortedMap.put("Orange", 80);
        unsortedMap.put("Grape", 120);

        System.out.println("Original HashMap (unsorted):");
        System.out.println(unsortedMap);

        // 2. Use a stream to sort the entries by key and then print them.
        System.out.println("\nSorted by key using Java 8 Stream:");
        unsortedMap.entrySet().stream()
            // Sort the stream of entries using the comparingByKey() method.
            .sorted(Map.Entry.comparingByKey())
            // Iterate and print each sorted entry.
            .forEach(entry -> System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue()));
    }
}
