package org.kas.demos.Prac.CoderpatQuest.DAY25_28_10;

interface MyInterface {
    default void doSomething() {
        System.out.println("Default implementation");
    }
}

class MyClass1 implements MyInterface {
    // doSomething() method is not overridden, so the default implementation is used.
}

public class DefMetImpl {
    public static void main(String[] args) {
        MyClass1 myObject = new MyClass1();
        myObject.doSomething(); // Output: Default implementation
    }
}
