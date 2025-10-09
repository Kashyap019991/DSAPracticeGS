package org.kas.demos.Prac.CoderpatQuest.DAY4_19_09;

// A class representing a node in a doubly linked list
class Node {
    String data;      // Stores the string value
    Node prev, next;  // References to previous and next nodes

    public Node(String data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

// Main Deque class using a doubly linked list
public class StringDeque {
    private Node front, rear;  // References to front and rear of the deque

    // Constructor initializes an empty deque
    public StringDeque() {
        front = rear = null;
    }

    // Check if deque is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Add a string to the front of the deque
    public void addFront(String data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = rear = newNode; // First node in deque
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
    }

    // Add a string to the rear of the deque
    public void addRear(String data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
        }
    }

    // Remove a string from the front of the deque
    public String removeFront() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty");
        }

        String value = front.data;
        front = front.next;

        if (front == null) {
            rear = null; // The deque is now empty
        } else {
            front.prev = null;
        }

        return value;
    }

    // Remove a string from the rear of the deque
    public String removeRear() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty");
        }

        String value = rear.data;
        rear = rear.prev;

        if (rear == null) {
            front = null;
        } else {
            rear.next = null;
        }

        return value;
    }

    // Peek at the front element without removing it
    public String peekFront() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty");
        }
        return front.data;
    }

    // Peek at the rear element without removing it
    public String peekRear() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty");
        }
        return rear.data;
    }

    // Print the deque from front to rear
    public void printDeque() {
        Node current = front;
        System.out.print("Deque: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Test the StringDeque
    public static void main(String[] args) {
        StringDeque deque = new StringDeque();

        deque.addRear("Hello");
        deque.addFront("World");
        deque.addRear("!");
        deque.printDeque(); // Output: Deque: World Hello !

        System.out.println("Front: " + deque.peekFront()); // World
        System.out.println("Rear: " + deque.peekRear());   // !

        deque.removeFront(); // Removes "World"
        deque.removeRear();  // Removes "!"
        deque.printDeque();  // Output: Deque: Hello
    }
}
