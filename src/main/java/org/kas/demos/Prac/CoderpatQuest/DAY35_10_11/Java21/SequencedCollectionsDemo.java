package org.kas.demos.Prac.CoderpatQuest.DAY35_10_11.Java21;

import java.util.ArrayList;
import java.util.List;
import java.util.SequencedCollection;

public class SequencedCollectionsDemo {
    public static void main(String[] args) {
        SequencedCollection<String> names = new ArrayList<>(List.of("Bob", "Charlie"));
        names.addFirst("Alice"); // New method
        names.addLast("David");  // New method
        System.out.println("First element: " + names.getFirst());
        System.out.println("Last element: " + names.getLast());
        System.out.println("Reversed collection: " + names.reversed());
    }
}