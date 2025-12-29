package org.kas.demos.Prac.CoderpatQuest.DAY25_28_10;

interface InterfaceA {
    void doSomething();
}

interface InterfaceB {
    void doSomething();
}

public class MyClass implements InterfaceA, InterfaceB {
    // A single method implementation satisfies both interfaces
    @Override
    public void doSomething() {
        System.out.println("Implementation for both interfaces");
    }

    public static void main(String[] args) {
        MyClass cl= new MyClass();
        cl.doSomething();
    }
}
