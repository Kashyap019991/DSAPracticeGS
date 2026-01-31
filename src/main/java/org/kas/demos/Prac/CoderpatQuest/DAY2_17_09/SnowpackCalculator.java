package org.kas.demos.Prac.CoderpatQuest.DAY2_17_09;

public class SnowpackCalculator {

/* Problem Name is &&& Snowpack &&& PLEASE DO NOT REMOVE THIS LINE. */

    /*
     ** Instructions to candidate.
     **  1) Given an array of non-negative integers representing the elevations
     **     from the vertical cross section of a range of hills, determine how
     **     many units of snow could be captured between the hills.
     **
     **     See the example array and elevation map below.
     **                                 ___
     **             ___                |   |        ___
     **            |   |        ___    |   |___    |   |
     **         ___|   |    ___|   |   |   |   |   |   |
     **     ___|___|___|___|___|___|___|___|___|___|___|___
     **     {0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0}
     **                                 ___
     **             ___                |   |        ___
     **            |   | *   *  _*_  * |   |_*_  * |   |
     **         ___|   | *  _*_|   | * |   |   | * |   |
     **     ___|___|___|_*_|___|___|_*_|___|___|_*_|___|___
     **     {0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0}
     **
     **     Solution: In this example 13 units of snow (*) could be captured.
     **
     **  2) Consider adding some additional tests in doTestsPass().
     **  3) Implement computeSnowpack() correctly.
     */

    public static int computeSnowpack(int[] elevations) {
        if (elevations == null || elevations.length <= 2) {
            return 0; // No snow can be trapped with less than 3 elevations
        }

        int totalSnow = 0;
        int left = 0;
        int right = elevations.length - 1;
        int leftMax = 0;
        int rightMax = 0;
// {0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0}
        while (left < right) {
            if (elevations[left] < elevations[right]) {
                if (elevations[left] >= leftMax) {
                    leftMax = elevations[left];
                } else {
                    totalSnow += leftMax - elevations[left];
                }
                left++;
            } else {
                if (elevations[right] >= rightMax) {
                    rightMax = elevations[right];
                } else {
                    totalSnow += rightMax - elevations[right];
                }
                right--;
            }
        }
        return totalSnow;
    }

    public static boolean doTestsPass() {
        boolean allTestsPassed = true;

        // Test case 1: Example from the problem description
        int[] elevations1 = {0, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 0};
        int expected1 = 13;
        int result1 = computeSnowpack(elevations1);
        if (result1 != expected1) {
            System.out.println("Test 1 Failed: Expected " + expected1 + ", Got " + result1);
            allTestsPassed = false;
        } else {
            System.out.println("Test 1 Passed.");
        }

        // Test case 2: Empty array
        int[] elevations2 = {};
        int expected2 = 0;
        int result2 = computeSnowpack(elevations2);
        if (result2 != expected2) {
            System.out.println("Test 2 Failed: Expected " + expected2 + ", Got " + result2);
            allTestsPassed = false;
        } else {
            System.out.println("Test 2 Passed.");
        }

        // Test case 3: Array with two elements
        int[] elevations3 = {1, 2};
        int expected3 = 0;
        int result3 = computeSnowpack(elevations3);
        if (result3 != expected3) {
            System.out.println("Test 3 Failed: Expected " + expected3 + ", Got " + result3);
            allTestsPassed = false;
        } else {
            System.out.println("Test 3 Passed.");
        }

        // Test case 4: Flat terrain
        int[] elevations4 = {2, 2, 2, 2, 2};
        int expected4 = 0;
        int result4 = computeSnowpack(elevations4);
        if (result4 != expected4) {
            System.out.println("Test 4 Failed: Expected " + expected4 + ", Got " + result4);
            allTestsPassed = false;
        } else {
            System.out.println("Test 4 Passed.");
        }

        // Test case 5: Single peak
        int[] elevations5 = {0, 1, 0, 2, 0, 1, 0};
        int expected5 = 3; // (1 unit at index 2, 1 unit at index 4, 1 unit at index 6)
        int result5 = computeSnowpack(elevations5);
        if (result5 != expected5) {
            System.out.println("Test 5 Failed: Expected " + expected5 + ", Got " + result5);
            allTestsPassed = false;
        } else {
            System.out.println("Test 5 Passed.");
        }

        // Test case 6: Descending then ascending
        int[] elevations6 = {4, 2, 0, 3, 2, 5};
        int expected6 = 9; // (2 at index 1, 4 at index 2, 1 at index 4)
        int result6 = computeSnowpack(elevations6);
        if (result6 != expected6) {
            System.out.println("Test 6 Failed: Expected " + expected6 + ", Got " + result6);
            allTestsPassed = false;
        } else {
            System.out.println("Test 6 Passed.");
        }


        return allTestsPassed;
    }

    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests passed!");
        } else {
            System.out.println("Some tests failed.");
        }
    }
    // ... (doTestsPass() method will be added below)
}