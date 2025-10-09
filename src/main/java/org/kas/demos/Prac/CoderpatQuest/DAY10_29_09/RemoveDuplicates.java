package org.kas.demos.Prac.CoderpatQuest.DAY10_29_09;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String text = "The quick brown fox jumps over the lazy dog the quick fox";

        List<String> uniqueWords = Arrays.stream(text.toLowerCase().split("\\s+"))
            .distinct()
            .collect(Collectors.toList());

        System.out.println("Unique Words:");
        System.out.println(uniqueWords);
    }
}
