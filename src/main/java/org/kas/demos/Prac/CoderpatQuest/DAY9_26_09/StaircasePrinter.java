package org.kas.demos.Prac.CoderpatQuest.DAY9_26_09;

import java.util.Scanner;

public class StaircasePrinter {

    /**
     * Prints a staircase of a given size `n` to the console.
     * The staircase is composed of '#' symbols and is right-aligned.
     *
     * @param n The size of the staircase (number of rows).
     */
    public static void printStaircase(int n) {
        // The outer loop iterates through each row of the staircase.
        // It runs from 1 to n (inclusive).
        for (int i = 1; i <= n; i++) {

            // The first inner loop prints the leading spaces.
            // For a right-aligned staircase, the number of spaces decreases with each row.
            // Row 1: n-1 spaces. Row 2: n-2 spaces, ..., Row n: 0 spaces.
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // The second inner loop prints the '#' symbols.
            // The number of symbols increases with each row.
            // Row 1: 1 symbol. Row 2: 2 symbols, ..., Row n: n symbols.
            for (int k = 1; k <= i; k++) {
                System.out.print("#");
            }

            // After printing all spaces and '#' for the current row,
            // print a newline character to move to the next row.
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the size of the staircase: ");
        int size = scanner.nextInt();
        
        System.out.println("\nStaircase of size " + size + ":");
        printStaircase(size);
        
        scanner.close();
    }
}

