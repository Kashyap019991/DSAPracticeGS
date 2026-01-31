package org.kas.demos.Prac.CoderpatQuest.DAY9_26_09;

import java.util.Stack;
import java.util.NoSuchElementException;

/**
 * Implements a Queue using two Stacks.
 * This approach makes the enqueue operation fast (O(1)) and the dequeue and peek
 * operations amortized O(1), with a worst-case of O(n) during a transfer.
 */
public class QueueUsingStacks<T> {

    // One stack for new elements (input).
    private Stack<T> inputStack;

    // A second stack for holding elements in the correct order for removal (output).
    private Stack<T> outputStack;

    /**
     * Initializes a new, empty queue.
     */
    public QueueUsingStacks() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    /**
     * Adds an element to the back of the queue.
     * Time Complexity: O(1)
     *
     * @param data The element to add.
     */
    public void enqueue(T data) {
        inputStack.push(data);
    }

    /**
     * Moves all elements from the input stack to the output stack.
     * This effectively reverses their order.
     */
    private void transferStacks() {
        // Only transfer if the output stack is empty.
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
    }

    /**
     * Removes and returns the element at the front of the queue.
     * Time Complexity: Amortized O(1), Worst-case O(n).
     *
     * @return The element at the front of the queue.
     * @throws NoSuchElementException if the queue is empty.
     */
    public T dequeue() {
        // Ensure the output stack has elements to pop from.
        transferStacks();
        if (outputStack.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return outputStack.pop();
    }

    /**
     * Retrieves, but does not remove, the element at the front of the queue.
     * Time Complexity: Amortized O(1), Worst-case O(n).
     *
     * @return The element at the front of the queue.
     * @throws NoSuchElementException if the queue is empty.
     */
    public T peek() {
        // Ensure the output stack has elements to peek at.
        transferStacks();
        if (outputStack.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return outputStack.peek();
    }

    /**
     * Checks if the queue is empty.
     * Time Complexity: O(1)
     *
     * @return True if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    /**
     * Returns the number of elements in the queue.
     * Time Complexity: O(1)
     *
     * @return The size of the queue.
     */
    public int size() {
        return inputStack.size() + outputStack.size();
    }

    // Main method for testing the implementation
    public static void main(String[] args) {
        QueueUsingStacks<Integer> queue = new QueueUsingStacks<>();

        // Enqueue some elements
        System.out.println("Enqueueing elements: 1, 2, 3");
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("Queue size: " + queue.size());

        // Dequeue and check peek
        System.out.println("Dequeuing: " + queue.dequeue()); // Should return 1
        System.out.println("Peek: " + queue.peek()); // Should return 2

        // Enqueue another element
        System.out.println("Enqueueing: 4");
        queue.enqueue(4);

        // Dequeue remaining elements
        System.out.println("Dequeuing: " + queue.dequeue()); // Should return 2
        System.out.println("Dequeuing: " + queue.dequeue()); // Should return 3
        System.out.println("Dequeuing: " + queue.dequeue()); // Should return 4
        System.out.println("Is queue empty? " + queue.isEmpty());
    }
}
