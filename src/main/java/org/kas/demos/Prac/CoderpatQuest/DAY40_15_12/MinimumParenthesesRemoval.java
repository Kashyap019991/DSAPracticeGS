package org.kas.demos.Prac.CoderpatQuest.DAY40_15_12;

import java.util.Stack;
import java.lang.StringBuilder;
/*

You are given a string s that contains lowercase English letters and parentheses '(' and ')'.
Your task is to remove the minimum number of parentheses so that the resulting string is valid.
A string is called valid if:
1.	Every opening parenthesis '(' has a corresponding closing parenthesis ')'
2.	Parentheses are properly nested
3.	Letters should remain unchanged
             Input: "(a(b(c)d)" Output: "a(b(c)d)"
             Input: "a)b(c)d(" Output: "ab(c)d"
             Input: "lee(t(c)o)de)" Output: "lee(t(c)o)de"
             Input: "))((" Output: ""

 */
public class MinimumParenthesesRemoval {

    public static String minRemoveToMakeValid(String s) {
        // Use a StringBuilder to easily manipulate the string, marking invalid parentheses
        StringBuilder sb = new StringBuilder(s);
        // Use a stack to store the indices of open parentheses
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < sb.length(); i++) {
            char currentChar = sb.charAt(i);

            if (currentChar == '(') {
                // Push the index of the open parenthesis onto the stack
                stack.push(i);
            } else if (currentChar == ')') {
                if (!stack.isEmpty()) {
                    // Found a matching pair, pop the corresponding open parenthesis index
                    stack.pop();
                } else {
                    // Found a closing parenthesis without a matching open one before it.
                    // Mark it for removal by replacing it with a placeholder character (e.g., '*').
                    // We use '*' because the input only contains lowercase letters and '(', ')'
                    sb.setCharAt(i, '*');
                }
            }
        }

        // After the first pass, any remaining indices in the stack correspond
        // to open parentheses that didn't find a matching closing parenthesis.
        // Mark these for removal as well.
        while (!stack.isEmpty()) {
            sb.setCharAt(stack.pop(), '*');
        }

        // Build the final valid string by removing all marked characters ('*')
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '*') {
                result.append(sb.charAt(i));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "(a(b(c)d)";
        String s1 = "a)b(c)d(";
        String s2 = "lee(t(c)o)de)";
        String s3 = "))((";

        System.out.println("Input: \"" + s + "\" Output: \"" + minRemoveToMakeValid(s) + "\"");
        System.out.println("Input: \"" + s1 + "\" Output: \"" + minRemoveToMakeValid(s1) + "\"");
        System.out.println("Input: \"" + s2 + "\" Output: \"" + minRemoveToMakeValid(s2) + "\"");
        System.out.println("Input: \"" + s3 + "\" Output: \"" + minRemoveToMakeValid(s3) + "\"");
    }
}
