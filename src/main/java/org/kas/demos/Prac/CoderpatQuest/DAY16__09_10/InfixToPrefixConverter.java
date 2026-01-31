package org.kas.demos.Prac.CoderpatQuest.DAY16__09_10;

import java.util.Stack;

/**
 * Converts an infix expression to a prefix expression using a stack.
 */
public class InfixToPrefixConverter {

    /**
     * Determines the precedence of an operator.
     * @param ch The operator character.
     * @return An integer representing the operator's precedence.
     */
    private int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    /**
     * Converts a reversed infix expression to a postfix expression.
     * Note: In this special case, associativity for operators of the same precedence
     * is handled in a way that is correct for the final prefix reversal.
     *
     * @param infix The reversed infix expression with swapped parentheses.
     * @return The postfix representation of the reversed infix.
     */
    private String infixToPostfix(String infix) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
//a+b*(c-d)
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            }
            else if (c == '(') {
                stack.push(c);
            }
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop(); // Pop the '('
                }
            }
            else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }
    
    /**
     * Reverses a string and swaps parentheses.
     * @param str The string to be reversed and modified.
     * @return The reversed and modified string.
     */
    private String reverseAndSwapParentheses(String str) {
        StringBuilder reversed = new StringBuilder(str).reverse();
        for (int i = 0; i < reversed.length(); i++) {
            if (reversed.charAt(i) == '(') {
                reversed.setCharAt(i, ')');
            } else if (reversed.charAt(i) == ')') {
                reversed.setCharAt(i, '(');
            }
        }
        return reversed.toString();
    }

    /**
     * Converts an infix expression to a prefix expression.
     * @param infix The infix expression string.
     * @return The prefix expression string.
     */
    public String convertToPrefix(String infix) {
        String reversedInfix = reverseAndSwapParentheses(infix);
        System.out.println("revinfix"+reversedInfix);
        String postfix = infixToPostfix(reversedInfix);
        System.out.println("postfix: "+postfix);
        return new StringBuilder(postfix).reverse().toString();
    }

    public static void main(String[] args) {
        InfixToPrefixConverter converter = new InfixToPrefixConverter();
        String infix1 = "a+b*(c-d)"; 
        String infix2 = "(a-b/c)*(a/k-l)"; 

        System.out.println("Infix: " + infix1);
        System.out.println("Prefix: " + converter.convertToPrefix(infix1));

        System.out.println("\nInfix: " + infix2);
        System.out.println("Prefix: " + converter.convertToPrefix(infix2));
    }
}
