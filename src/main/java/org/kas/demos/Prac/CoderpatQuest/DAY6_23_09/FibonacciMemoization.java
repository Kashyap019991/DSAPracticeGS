package org.kas.demos.Prac.CoderpatQuest.DAY6_23_09;

import java.util.HashMap;
import java.util.Map;

/**
 * Calculates the nth number in the Fibonacci series using a recursive approach
 * with memoization.
 */
public class FibonacciMemoization {
/*
Find the nth Number in fibonacci series using Iterative and Recursive Approach.
 */
    // A map to cache previously computed Fibonacci numbers
    private static Map<Integer, Integer> memo = new HashMap<>();

    /**
     * Finds the nth Fibonacci number using recursion with memoization.
     * Time Complexity: O(n) - Each Fibonacci number from 0 to n is computed only once.
     * Space Complexity: O(n) - For storing the computed values in the HashMap.
     *
     * @param n The position in the Fibonacci series (n >= 0).
     * @return The nth Fibonacci number.
     */
    public static int findNthFibonacci(int n) {
        // Handle base cases: the first two numbers in the series
        if (n <= 1) {
            return n;
        }

        // Check if the result is already in the memoization cache
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        // If not in cache, compute the result recursively
        int result = findNthFibonacci(n - 1) + findNthFibonacci(n - 2);
        
        // Store the newly computed result in the cache before returning
        memo.put(n, result);
        
        return result;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Using Recursive Approach with Memoization:");
        System.out.println("The " + n + "th Fibonacci number is: " + findNthFibonacci(n)); // Expected: 55

        int largeN = 45;
        System.out.println("The " + largeN + "th Fibonacci number is: " + findNthFibonacci(largeN)); // Fast even for large numbers
    }
}
