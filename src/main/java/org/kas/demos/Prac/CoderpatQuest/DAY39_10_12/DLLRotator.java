package org.kas.demos.Prac.CoderpatQuest.DAY39_10_12;

import java.util.Objects;

public class DLLRotator {

    // Node class for a Doubly Linked List
    static class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // Doubly Linked List class
    static class DoublyLinkedList {
        Node head, tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        // Method to insert a new node at the end of the list
        public void append(int newData) {
            Node newNode = new Node(newData);
            if (this.head == null) {
                this.head = newNode;
                this.tail = newNode;
                return;
            }
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }

        // Method to print the list from head to tail
        public void displayList() {
            Node current = this.head;
            while (current != null) {
                System.out.print(current.data + " <-> ");
                current = current.next;
            }
            System.out.println("null");
        }
        
        // Method to print the list in reverse (useful for verification)
        public void displayReverse() {
            Node current = this.tail;
            while (current != null) {
                System.out.print(current.data + " <-> ");
                current = current.prev;
            }
            System.out.println("null");
        }

        // Method to rotate the DLL by n nodes (counter-clockwise/left)
        public void rotate(int n) {
            if (this.head == null || n <= 0) {
                return;
            }

            Node current = this.head;
            int count = 1;

            // 1. Traverse to the n-th node (the new tail of the list)
            while (count < n && current != null) {
                current = current.next;
                count++;
            }

            // If n is greater than or equal to the number of nodes, no rotation is needed
            if (current == null || current.next == null) {
                return;
            }

            // 'nNode' is the node after which we break the list
            Node nNode = current;
            
            // 'newHead' is the (n+1)-th node, which becomes the start of the rotated list
            Node newHead = current.next;

            // 2. Adjust pointers to form the rotation:
            
            // A. Make the (n+1)-th node the new head's previous pointer point to null (break previous link)
            newHead.prev = null;

            // B. Connect the old tail to the old head, effectively looping the list
            this.tail.next = this.head;
            this.head.prev = this.tail;

            // C. Update the head of the main list to the new head
            this.head = newHead;

            // D. Break the list at the n-th node by setting its next pointer to null
            // This 'nNode' becomes the new tail of the list.
            nNode.next = null;
            
            // E. Update the tail of the main list to the n-th node
            this.tail = nNode;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.append(10);
        dll.append(20);
        dll.append(30);
        dll.append(40);
        dll.append(50);
        dll.append(60);

        System.out.println("Original List:");
        dll.displayList(); // Output: 10 <-> 20 <-> 30 <-> 40 <-> 50 <-> 60 <-> null

        int rotationAmount = 3;
        dll.rotate(rotationAmount);

        System.out.println("\nList after rotating by " + rotationAmount + " nodes:");
        dll.displayList(); // Output: 40 <-> 50 <-> 60 <-> 10 <-> 20 <-> 30 <-> null
        
        System.out.println("Verify Tail (Reverse traversal should start at 30):");
        dll.displayReverse(); // Output: 30 <-> 20 <-> 10 <-> 60 <-> 50 <-> 40 <-> null
    }
}
