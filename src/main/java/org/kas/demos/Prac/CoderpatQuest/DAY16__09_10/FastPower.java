package org.kas.demos.Prac.CoderpatQuest.DAY16__09_10;


public class FastPower {
/*
If the exponent n is even, then \(x^{n}=(x^{2})^{n/2}\).
If the exponent n is odd, then \(x^{n}=x*(x^{2})^{(n-1)/2}\). 
 */
    /**
     * Computes base^exponent in O(log(exponent)) time.
     *
     * @param base     the base number.
     * @param exponent the integer exponent.
     * @return the result of base raised to the power of exponent.
     */
    public static double fastPower(double base, int exponent) {
        // Handle negative exponents
        if (exponent < 0) {
            base = 1.0 / base;
            exponent = -exponent;
        }

        double result = 1.0;
        while (exponent > 0) {
            // If exponent is odd, multiply base with result
            if (exponent % 2 == 1) {
                result *= base;
            }
            // Now exponent is even, so we can square the base and halve the exponent
            base *= base;
            exponent /= 2;        //x ^8 = (x^2)^4

        }
        return result;
    }

    public static void main(String[] args) {
        // Example 1: 3^10 = 59049
        System.out.println("3.0^10 = " + fastPower(3.0, 10));

        // Example 2: 2^-4 = 0.0625
        System.out.println("2.0^-4 = " + fastPower(2.0, -4));
        
        // Example 3: 5^0 = 1
        System.out.println("5.0^0 = " + fastPower(5.0, 0));
        
        // Example 4: 7^5 = 16807
        System.out.println("7.0^5 = " + fastPower(7.0, 5));


    }
}
