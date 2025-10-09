package org.kas.demos.Prac.practice_08_09_TO_12_09;

import java.util.Scanner;

public class ValidAnagram {
//lc 242
    public boolean isAnagram(String s, String t) {
        // If lengths are different, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Create a frequency array for lowercase English letters (a-z)
        int[] charCounts = new int[26];

        // Increment count for characters in string s
        for (char c : s.toCharArray()) {
            charCounts[c - 'a']++;
        }

        // Decrement count for characters in string t
        for (char c : t.toCharArray()) {
            charCounts[c - 'a']--;
        }

        // Check if all counts in the array are zero
        // If any count is non-zero, it means character frequencies don't match
        for (int count : charCounts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
    //method 2
    /*
     public boolean isAnagram(String s, String t) {
        char[] charS = s.toCharArray();
        Arrays.sort(charS);
        String sortedOfS = new String(charS);
        char[] charT = t.toCharArray();
        Arrays.sort(charT);

        String sortedOfT = new String(charT);
        if(sortedOfS.equals(sortedOfT)){
            return true;
        }
        return false;
    }
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ValidAnagram solution = new ValidAnagram();

        System.out.print("Enter the first string (s): ");
        String s = scanner.nextLine();

        System.out.print("Enter the second string (t): ");
        String t = scanner.nextLine();

        if (solution.isAnagram(s, t)) {
            System.out.println("'" + s + "' and '" + t + "' are anagrams.");
        } else {
            System.out.println("'" + s + "' and '" + t + "' are NOT anagrams.");
        }

        scanner.close();
    }
}