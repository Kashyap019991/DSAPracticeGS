package org.kas.demos.Prac.CoderpatQuest.DAY26_29_10;

public class StackArr {
    private final int size;
    private final int[] stackArr;
    private int head;

    public StackArr(int size) {
        this.size = size;
        this.stackArr = new int[size];
        this.head = -1;
    }

    public void push(int value) {
        if (head == size - 1) {
            System.out.println("Stack is full, unable to push the element");
            return;
        }
        stackArr[++head] = value;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty , unable to find element for remove");
            return -1;
        }
        return stackArr[head--];
    }

    public boolean isEmpty() {
        return (head == -1);
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty , unable to perform peek ");
            return -1;
        }
        return stackArr[head];
    }
}

class sol {
    public static void main(String[] args) {
        StackArr stackArr = new StackArr(3);
        System.out.println("Pushing the element into stack");
        stackArr.push(10);
        stackArr.push(20);
        stackArr.push(15);
        System.out.println("checking the element at head {" + stackArr.peek() + "}");
        //System.out.println("pop the element {stackArr.pop()}");
        //System.out.println("stack whether it is empty or not : \{stackArr.isEmpty()}");
        //System.out.println("checking the element at head \{stackArr.peek()}");
        //System.out.println("pop the element \{stackArr.pop()}");
        //System.out.println("pop the element \{stackArr.pop()}");
        stackArr.peek();
        stackArr.pop();
        //System.out.println(STR."stack whether it is empty or not : \{stackArr.isEmpty()}");
    }
}