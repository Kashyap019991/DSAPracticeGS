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
        //int[] arrival = {900, 940, 950, 1100, 1500, 1800};
        //int[] departure = {910, 1200, 1120, 1130, 1900, 2000};
        //{1, 4}, {2, 5}, {7, 9}
        int[] arrival1 = {1,2,7};
        int[] departure1 = {4,5,9};

        //{1, 3}, {2, 4}, {3, 5}, {6, 8}//exp=3
        int[] arrival2 = {1,2,3,6};
        int[] departure2 = {3,4,5,8};


        //{1, 2}, {3, 4}, {5, 6} exp =1
        int[] arrival3 = {1,3,6};
        int[] departure3 = {2,4,6};
        int n = arrival3.length;
        System.out.println("Minimum Platforms Required: " + findPlatform(arrival3, departure3, n)); // Expected: 3
    }
}