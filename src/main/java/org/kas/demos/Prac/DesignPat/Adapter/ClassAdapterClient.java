package org.kas.demos.Prac.DesignPat.Adapter;

// Target interface expected by the client
interface Target {
    void request();
}

// Adaptee class with an incompatible interface
class Adaptee {
    public void specificRequest() {
        System.out.println("Adaptee's specific request.");
    }
}

// Class Adapter implementation
class ClassAdapter extends Adaptee implements Target {
    @Override
    public void request() {
        // Delegate the call to the adaptee's specific method
        specificRequest();
    }
}

// Client code
public class ClassAdapterClient {
    public static void main(String[] args) {
        Target target = new ClassAdapter();
        target.request(); // Client interacts with the Target interface
    }
}