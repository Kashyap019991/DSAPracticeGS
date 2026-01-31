package org.kas.demos.Prac.CoderpatQuest.DAY22_17_10;

import java.util.ArrayList;
import java.util.List;

public class ConcurrentModificationExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("Bob");

        System.out.println("Original list: " + names);

        // This will throw a ConcurrentModificationException
        try {
            for (String name : names) {
                if ("Bob".equals(name)) {
                    names.remove(name); // Modifying the list while iterating
                }
            }
        } catch (Exception e) {
            System.out.println("Exception caught: " + e);
        }
    }
}
