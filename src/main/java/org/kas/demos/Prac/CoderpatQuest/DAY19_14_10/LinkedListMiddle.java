package org.kas.demos.Prac.CoderpatQuest.DAY19_14_10;

public class LinkedListMiddle {

    // Node class for the linked list
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Function to find the middle element of the linked list
    public Node findMiddle(Node head) {
        if (head == null) {
            return null; // Handle empty list
        }

        Node slowPointer = head;
        Node fastPointer = head;
//1 -> 2 -> 3 -> 4 -> 5
        //10 -> 20 -> 30 -> 40
        // Move fastPointer by two steps and slowPointer by one step
        // When fastPointer reaches the end, slowPointer will be at the middle
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            //System.out.println(slowPointer.data +": fast:"+fastPointer.next);
        }
        return slowPointer;
    }

    public static void main(String[] args) {
        LinkedListMiddle list = new LinkedListMiddle();

        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        Node middleNode = list.findMiddle(head);
        if (middleNode != null) {
            System.out.println("The middle element of the linked list is: " + middleNode.data); // Output: 3
        }

        // Create a sample linked list with even number of elements: 10 -> 20 -> 30 -> 40
        Node head2 = new Node(10);
        head2.next = new Node(20);
        head2.next.next = new Node(30);
        head2.next.next.next = new Node(40);

        Node middleNode2 = list.findMiddle(head2);
        if (middleNode2 != null) {
            System.out.println("The middle element of the linked list is: " + middleNode2.data); // Output: 30 (the second middle element)
        }
    }
}