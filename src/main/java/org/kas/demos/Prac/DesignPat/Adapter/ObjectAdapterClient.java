package org.kas.demos.Prac.DesignPat.Adapter;

// Target interface expected by the client
interface TargetOb {
    void request();
}

// Adaptee class with an incompatible interface
class AdapteeOb {
    public void specificRequest() {
        System.out.println("Adaptee's specific request.");
    }
}

// Object Adapter implementation
class ObjectAdapter implements TargetOb {
    private AdapteeOb adaptee;

    public ObjectAdapter(AdapteeOb adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        // Delegate the call to the adaptee's specific method
        adaptee.specificRequest();
    }
}

// Client code
public class ObjectAdapterClient {
    public static void main(String[] args) {
        AdapteeOb adaptee = new AdapteeOb();
        TargetOb target = new ObjectAdapter(adaptee);
        target.request(); // Client interacts with the Target interface
    }
}