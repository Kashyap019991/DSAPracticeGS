package org.kas.demos.Prac.CoderpatQuest.DAY37_14_11;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class SnapshotArray {
    private List<TreeMap<Integer, Integer>> history;
    private int snapId;

    public SnapshotArray(int length) {
        history = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            history.add(new TreeMap<>());
            // Initialize each index with the default value (0) at snapId 0
            history.get(i).put(0, 0); 
        }
        snapId = 0;
    }

    /**
     * Assigns a value to the array at the given index for the current snapshot version.
     */
    public void set(int index, int value) {
        history.get(index).put(snapId, value);
    }

    /**
     * Takes a snapshot of the array and returns the snapshot ID.
     */
    public int snap() {
        return snapId++;
    }

    /**
     * Returns the value at the given index as it was at the time of the snapshot with ID snapId.
     */
    public int get(int index, int requestedSnapId) {
        // Use the floorEntry method of TreeMap to find the entry with the greatest 
        // snapshot ID less than or equal to the requestedSnapId.
        Integer value = history.get(index).floorEntry(requestedSnapId).getValue();
        return value != null ? value : 0;
    }

    /**
     * Main method to demonstrate the SnapshotArray class.
     */
    public static void main(String[] args) {
        // Example 1: Basic Operations
        System.out.println("--- Example 1: Basic Operations ---");
        SnapshotArray sa1 = new SnapshotArray(3); // length 3 (indices 0, 1, 2)
        sa1.set(0, 5); // Set index 0 to 5
        int snapId0 = sa1.snap(); // Take snapshot 0
        sa1.set(0, 6); // Set index 0 to 6 in the current version
        sa1.set(1, 10); // Set index 1 to 10 in the current version
        int snapId1 = sa1.snap(); // Take snapshot 1

        System.out.println("Value at index 0 in snap " + snapId0 + ": " + sa1.get(0, snapId0)); // Output: 5
        System.out.println("Value at index 0 in snap " + snapId1 + ": " + sa1.get(0, snapId1)); // Output: 6
        System.out.println("Value at index 1 in snap " + snapId1 + ": " + sa1.get(1, snapId1)); // Output: 10
        System.out.println("Value at index 2 in snap " + snapId1 + ": " + sa1.get(2, snapId1)); // Output: 0 (default)

        // Example 2: Verifying historical values
        System.out.println("\n--- Example 2: Historical Values ---");
        SnapshotArray sa2 = new SnapshotArray(1);
        sa2.set(0, 1);
        sa2.snap(); // snap 0
        sa2.set(0, 2);
        sa2.snap(); // snap 1
        sa2.set(0, 3);
        sa2.snap(); // snap 2
        
        System.out.println("Value at index 0 in snap 0: " + sa2.get(0, 0)); // Output: 1
        System.out.println("Value at index 0 in snap 1: " + sa2.get(0, 1)); // Output: 2
        System.out.println("Value at index 0 in snap 2: " + sa2.get(0, 2)); // Output: 3
    }
}
