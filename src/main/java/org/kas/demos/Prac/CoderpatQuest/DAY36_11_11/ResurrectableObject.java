package org.kas.demos.Prac.CoderpatQuest.DAY36_11_11;

public class ResurrectableObject {
    public static ResurrectableObject instance; // A static reference to hold the resurrected object

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize() called. Attempting to resurrect object.");
        ResurrectableObject.instance = this; // Assign 'this' to the static reference
        super.finalize();
    }

    public void doSomething() {
        System.out.println("Object is alive and doing something.");
    }

    public static void main(String[] args) throws InterruptedException {
        ResurrectableObject obj = new ResurrectableObject();
        System.out.println("Original object created: " + obj);

        // Nullify the reference, making the object eligible for GC
        obj = null;
        System.out.println("Original reference nulled. Object is now unreachable.");

        // Request garbage collection (not guaranteed to run immediately)
        System.gc();
        Thread.sleep(100); // Give GC a chance to run

        // Check if the object was resurrected
        if (ResurrectableObject.instance != null) {
            System.out.println("Object resurrected: " + ResurrectableObject.instance);
            ResurrectableObject.instance.doSomething();
        } else {
            System.out.println("Object was not resurrected.");
        }
    }
}