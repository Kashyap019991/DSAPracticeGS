package org.kas.demos.Prac.CoderpatQuest.DAY1_16_09;

import java.util.Arrays;

public class MinimumPlatforms {

    /**
     * Finds the minimum number of platforms required for a railway station.
     *
     * @param arrival   An array representing the arrival times of trains.
     * @param departure An array representing the departure times of trains.
     * @param n         The number of trains.
     * @return The minimum number of platforms required.
     */
    public static int findPlatform(int[] arrival, int[] departure, int n) {
        // Sort both arrival and departure arrays to process events chronologically.
        Arrays.sort(arrival);
        Arrays.sort(departure);

        int platformsNeeded = 0; // Current number of platforms in use
        int maxPlatforms = 0;    // Maximum platforms needed at any point
        int i = 0;               // Pointer for arrival array
        int j = 0;               // Pointer for departure array
//int[] arrival = {900, 940, 950, 1100, 1500, 1800};
//int[] departure = {910, 1200, 1120, 1130, 1900, 2000};
        // Iterate through the sorted arrival and departure times
        while (i < n && j < n) {
            // If a train arrives before or at the same time another train departs,
            // a new platform is needed.
            if (arrival[i] <= departure[j]) {
                platformsNeeded++;
                i++; // Move to the next arriving train
            }
            // If a train departs before the next train arrives,
            // a platform becomes free.
            else {
                platformsNeeded--;
                j++; // Move to the next departing train
            }
            // Update the maximum platforms needed if the current count is higher.
            maxPlatforms = Math.max(maxPlatforms, platformsNeeded);
        }

        return maxPlatforms;
    }

    public static void main(String[] args) {
        int[] arrival = {900, 940, 950, 1100, 1500, 1800};
        int[] departure = {910, 1200, 1120, 1130, 1900, 2000};
        int n = arrival.length;

        System.out.println("Minimum Platforms Required: " + findPlatform(arrival, departure, n)); // Expected: 3
    }
}