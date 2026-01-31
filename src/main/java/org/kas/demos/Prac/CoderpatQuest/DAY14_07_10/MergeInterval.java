package org.kas.demos.Prac.CoderpatQuest.DAY14_07_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/*
Given an array of intervals where intervals[i] = [starti, endi],
merge all overlapping intervals,
and return an array of the non-overlapping intervals
that cover all the intervals in the input
 */
class MergeInterval {
    public static int[][] merge(int[][] intervals) {
        // If there's only one or zero intervals, no merging is needed.
        if (intervals.length <= 1) {
            return intervals;
        }

        // Sort the intervals based on their start times.
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
//{{1,3},{2,6},{8,10},{15,18}};
        List<int[]> mergedIntervals = new ArrayList<>();
        int[] currentInterval = intervals[0];
        mergedIntervals.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            // Check for overlap.
            if (nextStart <= currentEnd) {
                // Merge intervals by updating the end time of the current interval.
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap, so add the new interval to the list.
                currentInterval = interval;
                mergedIntervals.add(currentInterval);
            }
        }

        // Convert the list back to a 2D array and return.
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] res = merge(intervals);

        System.out.println(Arrays.deepToString(res));
    }
}
