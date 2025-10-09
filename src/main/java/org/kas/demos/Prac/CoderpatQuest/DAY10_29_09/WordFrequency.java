package org.kas.demos.Prac.CoderpatQuest.DAY10_29_09;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordFrequency {
    public static void main(String[] args) {
        String text = "The quick brown fox jumps over the lazy dog the quick fox";

        Map<String, Long> wordFrequency = Arrays.stream(text.toLowerCase().split("\\s+"))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("Word Frequency:");
        wordFrequency.forEach((word, count) -> System.out.println(word + ": " + count));
    }
}
