package org.kas.demos.Prac.CoderpatQuest.DAY6_23_09;
/*
Reverse the linked list

Input 1->2_>4->6

Out 6->4->2->1
 */
public class LinklidtReverse {

    static ListNode revLLIterative(ListNode head){
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){//1->2->3
            ListNode tempNode = curr.next;//2->3//3
            curr.next = prev;//1->null//2->1->null
            prev = curr;//1//2
            curr = tempNode;//2//3
        }
        return prev;
    }

    static ListNode revLLRec(ListNode head){
        // Base case: If the list is empty or has only one node, it's already reversed
        if(head == null || head.next==null)
            return head;
        //rec go to the last node
        System.out.println(head.next.val);
        ListNode newHead = revLLRec(head.next);
        System.out.println(head.val +"  "+ newHead.val);
        // After the recursion returns, 'head.next' is the last node of the reversed sub-list.
                // We now point its 'next' pointer back to the current 'head'.
        head.next.next = head; //last node 4->5 , 4.next =5.next=4 now 5->4
        head.next=null; //5->4->null

        return newHead;
    }

        public static void main(String[] args) {
            // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(5);

            System.out.println("Original List:");
            printList(head);

            LinklidtReverse iterativeReverser = new LinklidtReverse();
            ListNode reversedHeadIterative = iterativeReverser.revLLIterative(head);
            System.out.println("Reversed List (Iterative):");
            printList(reversedHeadIterative);

            // We need a fresh list to test the recursive approach
            head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(5);

            LinklidtReverse recursiveReverser = new LinklidtReverse();
            ListNode reversedHeadRecursive = recursiveReverser.revLLRec(head);
            System.out.println("Reversed List (Recursive):");
            printList(reversedHeadRecursive);
        }

        /**
         * Helper method to print the linked list.
         *
         * @param head The head of the list to print.
         */
        public static void printList(ListNode head) {
            ListNode current = head;
            while (current != null) {
                System.out.print(current.val + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }

}

/**
 * Represents a single node in a singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}


