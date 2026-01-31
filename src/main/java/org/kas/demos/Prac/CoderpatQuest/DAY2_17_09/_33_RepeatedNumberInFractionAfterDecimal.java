package org.kas.demos.Prac.CoderpatQuest.DAY2_17_09;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _33_RepeatedNumberInFractionAfterDecimal {
	/**
	 * Return the fraction output in the following way Examples: If after decimal,
	 * repeating numbers are there in the output . eg. 1/3=0.333333333, this should
	 * be represented as 0.(3) 6/11=0.54545454, this should be represented as 0.(54)
	 * fractionRepresentation(1,2)=0.5 fractionRepresentation(1,3)=0.(3)
	 * fractionRepresentation(6,11)=0.(54)
	 */

		public static String fractionRepresentation(int numerator, int denominator) {
			// Handle edge case where numerator is 0
			if (numerator == 0) {
				return "0";
			}

			StringBuilder result = new StringBuilder();

			// Determine the sign of the result
			if ((numerator < 0) ^ (denominator < 0)) {
				result.append("-");
			}

			// Convert to positive long to handle potential overflow and simplify calculations
			long num = Math.abs((long) numerator);
			long den = Math.abs((long) denominator);

			// Append the integer part
			result.append(num / den);

			// Calculate the remainder
			long remainder = num % den;

			// If no remainder, it's a terminating decimal
			if (remainder == 0) {
				return result.toString();
			}

			// Append the decimal point
			result.append(".");

			// Use a HashMap to store remainders and their corresponding positions in the result string
			// This helps detect repeating decimals
			Map<Long, Integer> remainderMap = new HashMap<>();
			//6/11=0.54545454
			// Loop to find the decimal part
			while (remainder != 0) {
				// If the remainder has been seen before, a repeating sequence is found
				if (remainderMap.containsKey(remainder)) {
					int insertIndex = remainderMap.get(remainder);
					result.insert(insertIndex, "("); // Insert opening parenthesis
					result.append(")"); // Append closing parenthesis
					return result.toString();
				}

				// Store the current remainder and its position
				remainderMap.put(remainder, result.length());

				// Multiply remainder by 10 to continue decimal calculation
				remainder *= 10;
				result.append(remainder / den); // Append the next digit
				remainder %= den; // Update the remainder
			}

			return result.toString();
		}

	public static void main(String args[]) {
		// float f=6/11f;
		// System.out.println(f);
		System.out.println(fractionRepresentation(1, 2) + " " + fractionRepresentation(1, 3) + " "
				+ fractionRepresentation(6, 11));

		if (fractionRepresentation(1, 2).equals("0.5") && fractionRepresentation(6, 11).equals("0.(54)")
				&& fractionRepresentation(1, 3).equals("0.(3)")) {
			System.out.println("All passed");
			fractionRepresentation(6, 11);
		} else {
			System.out.println("Failed");
		}

	}
}