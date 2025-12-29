package org.kas.demos.Prac.CoderpatQuest.DAY35_10_11.Java21;

public class SwitchPatternMatchingDemo {
    public static void main(String[] args) {
        Object obj = "Hello";
        String result = switch (obj) {
            case Integer i -> "It's an Integer: " + i;
            case String s -> "It's a String: " + s.toUpperCase();
            case null -> "It's null";
            default -> "Unknown type";
        };
        System.out.println(result);
    }
}