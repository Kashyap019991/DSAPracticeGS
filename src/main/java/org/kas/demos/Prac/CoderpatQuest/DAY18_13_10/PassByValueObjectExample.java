package org.kas.demos.Prac.CoderpatQuest.DAY18_13_10;

class MyObject {
    String name;

    public MyObject(String name) {
        this.name = name;
    }
}

public class PassByValueObjectExample {
    public static void main(String[] args) {
        MyObject obj = new MyObject("Original");
        System.out.println("Before method call (name): " + obj.name); // Output: Original

        modifyObject(obj);
        System.out.println("After method call (name): " + obj.name); // Output: Modified (state changed)

        reassignObject(obj);
        System.out.println("After reassign method call (name): " + obj.name); // Output: Modified (original reference unchanged)
    }

    public static void modifyObject(MyObject o) {
        o.name = "Modified"; // Modifies the state of the object pointed to by 'o' (and 'obj')
    }

    public static void reassignObject(MyObject o) {
        o = new MyObject("New Object"); // 'o' now points to a different object, but 'obj' still points to the original
    }
}