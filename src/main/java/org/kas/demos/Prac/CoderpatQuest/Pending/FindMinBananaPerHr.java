package org.kas.demos.Prac.CoderpatQuest.Pending;

import java.util.Arrays;

class FindMinBananaPerHr {

    /**
     * Finds the minimum eating speed (k) for Koko to eat all bananas within h hours.
     * @param piles An array of integers representing the number of bananas in each pile.
     * @param h The total number of hours available.
     * @return The minimum integer eating speed.
     */
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for (int pile : piles) {
            if (pile > high) {
                high = pile;
            }
        }

        int minSpeed = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid == 0) { // Avoid division by zero if low starts at 0, though not the case here
                low = 1;
                continue;
            }

            long hoursNeeded = calculateHours(piles, mid);

            if (hoursNeeded <= h) {
                minSpeed = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return minSpeed;
    }

    /**
     * Helper function to calculate the total hours required to eat all piles at a given speed.
     * Uses ceiling division for accurate hour calculation.
     * @param piles The array of banana piles.
     * @param speed The eating speed (bananas per hour).
     * @return The total hours needed.
     */
    // {3, 6, 7, 11} , h=8; mid =3
    private long calculateHours(int[] piles, int speed) {
        long totalHours = 0;
        for (int pile : piles) {
            totalHours += (pile + speed - 1) / speed;
        }
        return totalHours;
    }

    /*
     * Example of how to use the function.
     */
    public static void main(String[] args) {
        FindMinBananaPerHr solution = new FindMinBananaPerHr();
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        int result = solution.minEatingSpeed(piles, h);
        System.out.println("Minimum eating speed (k) for piles " + Arrays.toString(piles) + " and h=" + h + " is: " + result); // Expected output: 4
    }
}
