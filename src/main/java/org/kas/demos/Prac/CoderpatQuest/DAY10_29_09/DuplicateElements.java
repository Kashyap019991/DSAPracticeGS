package org.kas.demos.Prac.CoderpatQuest.DAY10_29_09;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateElements {
//wo using grouping by
    public static List<Integer> findDuplicatesWithoutGroupingBy(int[] array) {
        Set<Integer> seen = new HashSet<>();
        return Arrays.stream(array)
                     .filter(n -> !seen.add(n)) // Keep elements that cannot be added (duplicates)
                     .distinct() // Ensure the result contains each duplicate element only once
                     .boxed()
                     .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int[] numbers = {1, 5, 6, 10, 10, 10, 5, 5, 8, 2, 2};
        List<Integer> duplicates = findDuplicatesWithoutGroupingBy(numbers);
        System.out.println("Duplicate elements: " + duplicates);

        String abc = "ABC";
        String def = "ABC";

        String efg = "DEF";
        String mno = new String("ABC");
        System.out.println(abc == def);//false
        System.out.println(def == mno);//false
        System.out.println(def.equals(abc));//true
        System.out.println(abc.equals(mno));//true
    }
}
