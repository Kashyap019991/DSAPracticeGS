package org.kas.demos.Prac.CoderpatQuest.DAY6_23_09;

/**
 * Determines if a number divisible by 3 can be formed using all digits in an array.
 */
public class DivisibleByThreeFinder {

    /**
     * Checks if it's possible to construct a number divisible by 3 from the digits
     * in the given array.
     *
     * @param digits The array of integers (digits).
     * @return true if a divisible-by-3 number can be formed, false otherwise.
     */
    public boolean canFormDivisibleByThree(int[] digits) {
        // Handle edge case of an empty or null array
        if (digits == null || digits.length == 0) {
            return false;
        }

        long sum = 0; // Use long to prevent integer overflow for large arrays or values

        // Sum up all the digits in the array
        for (int digit : digits) {
            sum += digit;
        }

        // Apply the divisibility rule of 3: A number is divisible by 3
        // if the sum of its digits is divisible by 3.
        return sum % 3 == 0;
    }

    public static void main(String[] args) {
        DivisibleByThreeFinder checker = new DivisibleByThreeFinder();

        // Example 1: {1, 2, 3} -> sum = 6 -> 6 % 3 == 0 (true)
        int[] arr1 = {1, 2, 3};
        System.out.println("Can form a divisible-by-3 number from {1, 2, 3}? " + checker.canFormDivisibleByThree(arr1));

        // Example 2: {4, 5, 6} -> sum = 15 -> 15 % 3 == 0 (true)
        int[] arr2 = {4, 5, 6};
        System.out.println("Can form a divisible-by-3 number from {4, 5, 6}? " + checker.canFormDivisibleByThree(arr2));

        // Example 3: {1, 4} -> sum = 5 -> 5 % 3 != 0 (false)
        int[] arr3 = {1, 4};
        System.out.println("Can form a divisible-by-3 number from {1, 4}? " + checker.canFormDivisibleByThree(arr3));
        
        // Example 4: {40, 50, 90} (Note: treating as digits means summing the values directly)
        // -> sum = 40+50+90 = 180 -> 180 % 3 == 0 (true)
        int[] arr4 = {40, 50, 90};
        System.out.println("Can form a divisible-by-3 number from {40, 50, 90}? " + checker.canFormDivisibleByThree(arr4));
    }
}
