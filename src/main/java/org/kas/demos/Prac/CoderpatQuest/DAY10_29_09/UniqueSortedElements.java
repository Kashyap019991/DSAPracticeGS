package org.kas.demos.Prac.CoderpatQuest.DAY10_29_09;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UniqueSortedElements {

    public static void main(String[] args) {
        int[] numbers = {1, 5, 6, 10, 10, 10, 5, 5, 8, 2, 2};

        // Get unique elements
        List<Integer> uniqueElements = Arrays.stream(numbers)
                                            .distinct()
                                            .boxed()
                                            .collect(Collectors.toList());

        System.out.println("Unique elements: " + uniqueElements);

        // Get unique elements in ascending order
        List<Integer> ascendingUniqueElements = Arrays.stream(numbers)
                                                .distinct()
                                                .sorted()
                                                .boxed()
                                                .collect(Collectors.toList());

        System.out.println("Unique elements in ascending order: " + ascendingUniqueElements);

        // Get unique elements in descending order
        List<Integer> descendingUniqueElements = Arrays.stream(numbers)
                                                .distinct()
                                                .boxed()
                                                .sorted(Comparator.reverseOrder())
                                                .collect(Collectors.toList());

        System.out.println("Unique elements in descending order: " + descendingUniqueElements);
    }
}
