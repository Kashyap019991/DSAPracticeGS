package org.kas.demos.Prac.CoderpatQuest.DAY12_1_10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnmodifiableListExample {
    public static void main(String[] args) {
        List<String> originalList = new ArrayList<>();
        originalList.add("Apple");
        originalList.add("Banana");

        List<String> unmodifiableView = Collections.unmodifiableList(originalList);

        System.out.println("Unmodifiable view: " + unmodifiableView); // Output: [Apple, Banana]

        // Attempting to modify the unmodifiable view will throw an exception
        try {
            unmodifiableView.add("Cherry");
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot add to unmodifiable list: " + e.getMessage());
        }

        // Modifying the original list affects the unmodifiable view
        originalList.add("Date");
        System.out.println("Unmodifiable view after original list modification: " + unmodifiableView); // Output: [Apple, Banana, Date]
    }
}