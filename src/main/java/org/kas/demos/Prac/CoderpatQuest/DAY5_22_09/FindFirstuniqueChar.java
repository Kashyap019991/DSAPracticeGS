package org.kas.demos.Prac.CoderpatQuest.DAY5_22_09;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

//First unique character of a string. E.g. aabdcce . Output : d
public class FindFirstuniqueChar {
    public static void main(String[] args) {
        String str = "aabdcce";

        Map<Character,Long> charsMap = str.chars().mapToObj(ch ->(char) ch)
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
        Optional<Character> ch =         charsMap.entrySet().stream()
                        .filter(entry -> entry.getValue()==1).findFirst()
                .map(entry -> entry.getKey());
        System.out.println(ch);

    }
}
