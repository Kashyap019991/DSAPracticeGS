package org.kas.demos.Prac.CoderpatQuest.DAY35_10_11.Java21;

record Point(int x, int y) {}

public class RecordPatternsDemo {
    public static void main(String[] args) {
        Object obj = new Point(10, 20);
        if (obj instanceof Point(int x, int y)) { // Record pattern
            System.out.println("Point coordinates: " + x + ", " + y);
        }
    }
}
//Record patterns enhance pattern matching by allowing the deconstruction of record values directly within patterns, making code more concise and readable.