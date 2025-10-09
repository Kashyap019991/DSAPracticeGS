package org.kas.demos.Prac.CoderpatQuest.DAY5_22_09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BiggestNumber {
/*
Arrange given numbers to form the biggest number.
Input- List of numbers : {1, 34, 3, 98, 9, 76, 45, 4} Output – 998764543431
 */
    /**
     * Arranges a list of numbers to form the biggest possible number.
     *
     * @param numbers A list of integers.
     * @return The largest possible number as a string.
     */
    public static String largestNumber(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return "";
        }

        // 1. Convert the list of integers to a list of strings.
        List<String> stringNumbers = new ArrayList<>();
        for (Integer num : numbers) {
            stringNumbers.add(String.valueOf(num));
        }

        // 2. Sort the list of strings using a custom comparator.
        // For any two strings a and b, we compare the concatenated strings b+a and a+b.
        // The one that is lexicographically larger comes first.
        Collections.sort(stringNumbers, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String ab = a + b;
                String ba = b + a;
                // We want to sort in descending order based on this custom logic.
                return ba.compareTo(ab);
            }
        });
        
        // Using a Java 8 lambda expression for the comparator:
        // stringNumbers.sort((a, b) -> (b + a).compareTo(a + b));

        // 3. Handle the edge case where all numbers are zero.
        // If the first element in the sorted list is "0", the result should be "0".
        if (stringNumbers.get(0).equals("0")) {
            return "0";
        }

        // 4. Concatenate the sorted strings to form the final result.
        StringBuilder result = new StringBuilder();
        for (String numStr : stringNumbers) {
            result.append(numStr);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 34, 3, 98, 9, 76, 45, 4);
        System.out.println("Input: " + numbers);
        System.out.println("Output: " + largestNumber(numbers)); // Expected: 998764543431
        
        System.out.println();
        List<Integer> numbers2 = Arrays.asList(3, 30, 34, 5, 9);
        System.out.println("Input: " + numbers2);
        System.out.println("Output: " + largestNumber(numbers2)); // Expected: 9534330
        
        System.out.println();
        List<Integer> numbers3 = Arrays.asList(0, 0, 0, 0);
        System.out.println("Input: " + numbers3);
        System.out.println("Output: " + largestNumber(numbers3)); // Expected: 0
    }
}
