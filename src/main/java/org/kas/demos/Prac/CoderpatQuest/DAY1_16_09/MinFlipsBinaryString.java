package org.kas.demos.Prac.CoderpatQuest.DAY1_16_09;

public class MinFlipsBinaryString {
/*
Given a binary string, that is it contains only 0s and 1s.
We need to make this string a sequence of alternate characters by
flipping some of the bits, our goal is to minimize the number of bits to be flipped.
Examples :

Input : str = “001”
Output : 1
Minimum number of flips required = 1
We can flip 1st bit from 0 to 1

Input : str = “0001010111”
Output : 2
Minimum number of flips required = 2
We can flip 2nd bit from 0 to 1 and 9th
bit from 1 to 0 to make alternate
string “0101010101”.

 */

    // Helper method to calculate flips needed for a specific starting character
    private static int getFlipCount(String str, char expectedStartChar) {
        int flipCount = 0;//001
        char expectedChar = expectedStartChar;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != expectedChar) {
                flipCount++;
            }
            // Toggle expectedChar for the next position
            expectedChar = (expectedChar == '0' ? '1' : '0');
        }
        return flipCount;
    }

    // Main method to find the minimum flips
    public static int minFlipsToMakeAlternate(String str) {
        // Calculate flips if the string starts with '0'
        int flipsStartingWithZero = getFlipCount(str, '0');

        // Calculate flips if the string starts with '1'
        int flipsStartingWithOne = getFlipCount(str, '1');

        // Return the minimum of the two
        return Math.min(flipsStartingWithZero, flipsStartingWithOne);
    }

    public static void main(String[] args) {
        String str1 = "001";
        System.out.println("Input: " + str1 + ", Output: " + minFlipsToMakeAlternate(str1)); // Expected: 1

        String str2 = "0001010111";
        System.out.println("Input: " + str2 + ", Output: " + minFlipsToMakeAlternate(str2)); // Expected: 2
    }
}