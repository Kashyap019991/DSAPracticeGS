package org.kas.demos.Prac.CoderpatQuest.DAY8_25_09;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    /**
     * Calculates the number of days one needs to wait for a higher temperature.
     * This method uses a monotonic stack to achieve a time complexity of O(n).
     *
     * @param temperatures The array of daily temperatures.
     * @return An array where each element is the number of days to wait for a warmer temperature.
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        // This array will store the final result. Initialized with 0s by default.
        int[] result = new int[n];
        // The stack will store the indices of the days we've seen so far.
        // It maintains a decreasing monotonic order of temperatures at those indices.
        Stack<Integer> stack = new Stack<>();
//{73, 74, 75, 71, 69, 72, 76, 73}
        // Iterate through each day's temperature.
        for (int i = 0; i < n; i++) {
            // While the stack is not empty and the current temperature is warmer
            // than the temperature at the index on top of the stack...
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // ...we've found a warmer day for the day at the top of the stack.
                int previousDayIndex = stack.pop();
                // The waiting time is the difference between the current day and the previous day.
                result[previousDayIndex] = i - previousDayIndex;
            }
            // Push the current day's index onto the stack.
            // It will wait here until a warmer day is found.
            stack.push(i);
        }

        // Any indices left in the stack do not have a warmer day in the future,
        // so their result value remains the default 0.

        return result;
    }

    public static void main(String[] args) {
        DailyTemperatures solution = new DailyTemperatures();
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
                    //[1, 1, 4, 2, 1, 1, 0, 0]
        int[] output = solution.dailyTemperatures(arr);

        System.out.println("Input temperatures: " + Arrays.toString(arr));
        System.out.println("Days to wait:       " + Arrays.toString(output));
    }
}
