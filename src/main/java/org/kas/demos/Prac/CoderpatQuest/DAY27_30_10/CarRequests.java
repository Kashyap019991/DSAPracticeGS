package org.kas.demos.Prac.CoderpatQuest.DAY27_30_10;

import java.util.Map;
import java.util.TreeMap;

public class CarRequests {

    /**
     * Calculates the minimum number of cars required to fulfill all requests.
     *
     * @param requests A 2D array where each inner array represents a request
     *                 [startTime, endTime].
     * @return The minimum number of cars needed.
     */
    public static int findMinimumCars(int[][] requests) {
        // TreeMap to store events (start/end times) and their impact on active cars
        // Key: time point, Value: change in active cars (+1 for start, -1 for end)
        TreeMap<Integer, Integer> timeline = new TreeMap<>();

        for (int[] request : requests) {
            int startTime = request[0];
            int endTime = request[1]; // Inclusive end time, so car is free after this time

            // Increment active cars at start time
            timeline.put(startTime, timeline.getOrDefault(startTime, 0) + 1);
            // Decrement active cars at endTime + 1 (car becomes free)
            timeline.put(endTime + 1, timeline.getOrDefault(endTime + 1, 0) - 1);
        }

        int maxCarsNeeded = 0;
        int currentCars = 0;

        // Iterate through the sorted timeline
        for (Map.Entry<Integer, Integer> entry : timeline.entrySet()) {
            currentCars += entry.getValue();
            maxCarsNeeded = Math.max(maxCarsNeeded, currentCars);
        }

        return maxCarsNeeded;
    }

    public static void main(String[] args) {
        // Example usage:
        int[][] requests1 = {{1, 4}, {2, 5}, {7, 9}}; // Max overlap at [2,4] is 2 cars
        System.out.println("Minimum cars needed for requests1: " + findMinimumCars(requests1)); // Expected: 2

        int[][] requests2 = {{1, 3}, {2, 4}, {3, 5}, {6, 8}}; // Max overlap at [3,3] is 3 cars
        System.out.println("Minimum cars needed for requests2: " + findMinimumCars(requests2)); // Expected: 3

        int[][] requests3 = {{1, 2}, {3, 4}, {5, 6}}; // No overlap, max is 1 car
        System.out.println("Minimum cars needed for requests3: " + findMinimumCars(requests3)); // Expected: 1
    }
}