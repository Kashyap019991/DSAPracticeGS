package org.kas.demos.Prac.CoderpatQuest.DAY12_1_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayOperations {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 5, 4, 6,7, 0,0, 0};
        int[] result = processArray(input);

        System.out.print("Processed Array: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();

        findMinMax(input);
    }

    public static int[] processArray(int[] arr) {
        int zeroCount = 0;
        List<Integer> nonZeroElements = new ArrayList<>();

        // Count zeros and collect non-zero elements
        for (int num : arr) {
            if (num == 0) {
                zeroCount++;
            } else {
                nonZeroElements.add(num);
            }
        }

        // Distribute zeros equally
        int[] processedArr = new int[arr.length];
        int zerosAtEachEnd = zeroCount / 2;
        int remainingZero = zeroCount % 2;

        for (int i = 0; i < zerosAtEachEnd; i++) {
            processedArr[i] = 0;
        }
        for (int i = 0; i < zerosAtEachEnd; i++) {
            processedArr[arr.length - 1 - i] = 0;
        }

        // Separate odd and even numbers
        List<Integer> odds = new ArrayList<>();
        List<Integer> evens = new ArrayList<>();
        for (int num : nonZeroElements) {
            if (num % 2 == 0) {
                evens.add(num);
            } else {
                odds.add(num);
            }
        }

        // Sort odds and evens for consistent ordering if not specified
        Collections.sort(odds);
        Collections.sort(evens);

        // Populate array with even numbers followed by odd numbers
        int currentIndex = zerosAtEachEnd;
        for (int even : evens) {
            processedArr[currentIndex++] = even;
        }
        for (int odd : odds) {
            processedArr[currentIndex++] = odd;
        }

        // Place remaining zero in the middle if any
        if (remainingZero > 0) {
            processedArr[currentIndex] = 0;
        }

        return processedArr;
    }

    public static void findMinMax(int[] arr) {
        if (arr.length < 2) {
            System.out.println("Array must have at least two elements to find first and second min/max.");
            return;
        }

        Arrays.sort(arr); // Sort the array to easily find min/max

        System.out.println("First Largest: " + arr[arr.length - 1]);
        System.out.println("Second Largest: " + arr[arr.length - 2]);
        System.out.println("First Smallest: " + arr[0]);
        System.out.println("Second Smallest: " + arr[1]);
    }
}