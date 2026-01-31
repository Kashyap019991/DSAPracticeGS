package org.kas.demos.Prac.Company_Interv.vsa;

import java.util.*;
//optimizedV
public class Vsa4_Opt
{
    public static int solution(int[] heights, int viewingGap) {
        int n = heights.length;
        int minDiff = Integer.MAX_VALUE;

        // TreeSet keeps values sorted for efficient nearest-neighbor queries
        TreeSet<Integer> window = new TreeSet<>();

        for (int j = viewingGap; j < n; j++) {
            // Add the peak that is exactly viewingGap behind j
            window.add(heights[j - viewingGap]);

            // Find closest peak in the window to heights[j]
            Integer lower = window.floor(heights[j]);
            Integer higher = window.ceiling(heights[j]);

            if (lower != null) {
                minDiff = Math.min(minDiff, Math.abs(heights[j] - lower));
            }
            if (higher != null) {
                minDiff = Math.min(minDiff, Math.abs(heights[j] - higher));
            }
        }

        return minDiff;
    }

    public static void main(String[] args) {
        int[] heights1 = {1, 5, 4, 10, 9};
        int viewingGap1 = 3;
        System.out.println(solution(heights1, viewingGap1)); // Output: 4

        int[] heights2 = {3, 10, 5, 8};
        int viewingGap2 = 1;
        System.out.println(solution(heights2, viewingGap2)); // Output: 2
    }
}
