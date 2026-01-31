package org.kas.demos.Prac.CoderpatQuest.DAY27_30_10;

public class LinkedListMiddleElement {

    // Node class to represent an element in the linked list
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head; // Head of the linked list

    // Method to add a new node to the linked list
    public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    // Method to find and print the middle element of the linked list
    public void findMiddle() {
        if (head == null) {
            System.out.println("The linked list is empty.");
            return;
        }

        Node slow_ptr = head;
        Node fast_ptr = head;

        while (fast_ptr != null && fast_ptr.next != null) {
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;
        }

        System.out.println("The middle element is: " + slow_ptr.data);
    }

    public static void main(String[] args) {
        LinkedListMiddleElement list = new LinkedListMiddleElement();

        // Adding elements to the linked list
        list.push(5);
        list.push(4);
        list.push(3);
        list.push(2);
        list.push(1); // List: 1 -> 2 -> 3 -> 4 -> 5

        System.out.println("Linked List: 1 -> 2 -> 3 -> 4 -> 5");
        list.findMiddle(); // Expected output: 3

        LinkedListMiddleElement list2 = new LinkedListMiddleElement();
        list2.push(6);
        list2.push(5);
        list2.push(4);
        list2.push(3);
        list2.push(2);
        list2.push(1); // List: 1 -> 2 -> 3 -> 4 -> 5 -> 6

        System.out.println("\nLinked List: 1 -> 2 -> 3 -> 4 -> 5 -> 6");
        list2.findMiddle(); // Expected output: 4 (second middle element in even-sized list)
    }
}