package org.kas.demos.Prac.Company_Interv.vsa.Quest2;

import java.util.Arrays;

class Vsa2 {
    static int getMinWalked(int target, int[] stations) {
        int current = 0;   // current position
        int walked = 0;    // total walking distance
        boolean[] used = new boolean[stations.length];

        while (current < target) {
            int nextStation = Integer.MAX_VALUE;
            int index = -1;
            Arrays.sort(stations);
            // Find nearest unused station ahead
            for (int i = 0; i < stations.length; i++) {
                if (!used[i] && stations[i] >= current && stations[i] < nextStation) {

                    nextStation = stations[i];
                    index = i;
                }
            }

            // No station ahead → walk to target
            if (index == -1) {
                walked += (target - current);
                break;
            }

            // Walk to station
            walked += (nextStation - current);
            current = nextStation;
            used[index] = true;

            // Drone flies
            current = Math.min(current + 10, target);
        }

        return walked;
    }

    public static void main(String[] args) {
        int target = 23;
        int[] stations = {7,4,14};

        System.out.println(getMinWalked(23, new int[]{7, 4, 14})); // Output: 4
        System.out.println(getMinWalked(27, new int[]{15, 7, 3, 10})); // Output: 7
        System.out.println(getMinWalked(10, new int[]{})); // Output: 10
    }
}