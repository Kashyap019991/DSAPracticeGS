package org.kas.demos.Prac.CoderpatQuest.DAY35_10_11.Java21;

public class UnnamedVariablesDemo {
    public static void main(String[] args) {
        record Pair(String key, String value) {}
        Object data = new Pair("name", "Alice");
/*
        if (data instanceof Pair(_, String value)) { // Unnamed pattern for key
            System.out.println("Value is: " + value);
        }

 */
    }
}