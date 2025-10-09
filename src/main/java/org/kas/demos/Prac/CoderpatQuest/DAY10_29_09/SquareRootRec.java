package org.kas.demos.Prac.CoderpatQuest.DAY10_29_09;

public class SquareRootRec {

    // Helper method to perform the recursion
    private static double squareRootRecursive(double x, double guess, double epsilon) {
        // Base case: check if the approximation is good enough
        if (Math.abs(guess - (x / guess)) <= epsilon) {
            return guess;
        }

        // Recursive step: refine the guess and call the method again
        double newGuess = 0.5 * (guess + x / guess);
        return squareRootRecursive(x, newGuess, epsilon);
    }

    /**
     * Computes the square root of a number using the Babylonian method recursively.
     */
    public static double squareRoot(double x) {
        // Handle special cases
        if (x < 0) {
            return Double.NaN;
        }
        if (x == 0) {
            return 0;
        }

        double initialGuess = x / 2.0;
        double epsilon = 0.00001;

        // Start the recursive process
        return squareRootRecursive(x, initialGuess, epsilon);
    }
    
    public static void main(String[] args) {
        System.out.println("Square root of 9: " + squareRoot(9));
        System.out.println("Square root of 25: " + squareRoot(25));
        System.out.println("Square root of 2: " + squareRoot(2));
        System.out.println("Square root of 0: " + squareRoot(0));
        System.out.println("Square root of -1: " + squareRoot(-1));
    }
}
