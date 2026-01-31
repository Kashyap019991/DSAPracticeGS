package org.kas.demos.Prac.CoderpatQuest.DAY12_1_10;

public class StringComparison {
    public static void main(String[] args) {
        String firstString = "abc#def";
        String secondString = "abc#def";

        // Remove the '#' character
        String modifiedFirstString = firstString.replace("#", "");
        String modifiedSecondString = secondString.replace("#", "");

        // Check if both modified strings are equal
        if (modifiedFirstString.equals(modifiedSecondString)) {
            System.out.println("Both strings are the same after removing '#'.");
        } else {
            System.out.println("The strings are different after removing '#'.");
        }
    }
}