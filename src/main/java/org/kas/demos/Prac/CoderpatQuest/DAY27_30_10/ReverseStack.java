package org.kas.demos.Prac.CoderpatQuest.DAY27_30_10;

import java.util.Stack;

public class ReverseStack {

    /**
     * Reverses the order of elements in a stack using recursion.
     * @param stack The stack to be reversed.
     */
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
//[1, 2, 3, 4]
        // Remove the top element
        int topElement = stack.pop();

        // Reverse the remaining stack
        reverse(stack);

        // Insert the held element at the bottom of the now-reversed stack
        insertAtBottom(stack, topElement);
        //stack.push(topElement);
    }

    /**
     * Inserts an element at the very bottom of a stack using recursion.
     * @param stack The stack to which the element will be added.
     * @param x The element to insert at the bottom.
     */
    private static void insertAtBottom(Stack<Integer> stack, int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            return;
        }
//[1, 2, 3, 4]
        // Hold the current top element
        int topElement = stack.pop();

        // Recurse to insert x at the bottom
        insertAtBottom(stack, x);

        // Push the held element back on top
        stack.push(topElement);
    }

    // A utility function to print the stack for demonstration
    public static void printStack(Stack<Integer> stack) {
        System.out.println(stack);
    }

    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);

        System.out.print("Original stack: ");
        printStack(myStack);
        reverse(myStack);
        //reverse1(myStack,myStack.pop());

        System.out.print("Reversed stack: ");
        printStack(myStack);
    }
}
