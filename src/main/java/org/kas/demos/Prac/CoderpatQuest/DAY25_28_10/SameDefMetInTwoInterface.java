package org.kas.demos.Prac.CoderpatQuest.DAY25_28_10;

interface InterfaceC {
    default void log() { System.out.println("Log from A"); }
}

interface InterfaceD {
    default void log() { System.out.println("Log from B"); }
}
/*
class MyClass implements InterfaceC, InterfaceD {
    // COMPILATION ERROR: The compiler doesn't know which default implementation to use.
}
*/
// Resolution: Explicitly override the method in the implementing class.
public class SameDefMetInTwoInterface implements InterfaceC, InterfaceD {
    @Override
    public void log() {
        // You can provide a custom implementation or call a specific interface's default.
        InterfaceC.super.log(); // Calls the default from InterfaceA
    }
}