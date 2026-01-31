package org.kas.demos.Prac.Company_Interv.vsa;

public class Vsa4_Tle {
    public static int solution(int[] heights, int viewingGap) {
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < heights.length; i++) {
            for (int j = i + viewingGap; j < heights.length; j++) {
                int diff = Math.abs(heights[i] - heights[j]);
                if (diff < minDiff) {
                    minDiff = diff;
                }
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
