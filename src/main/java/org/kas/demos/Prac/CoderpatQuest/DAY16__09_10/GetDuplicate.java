package org.kas.demos.Prac.CoderpatQuest.DAY16__09_10;
/*
create chatbot feature in whichyou have dictionary list and one String array input which consist of misspelled words. You need to auto correct the words if it is available in list.

List<String> wordList = Arrays.asList("i", "live", "in", "mumbai", "india");
String[] input = {"i", "lvie", "ni", "mumbai"};

o/p -> Auto-corrected sentence: i live in mumbai.
 */

import java.util.*;
import java.util.stream.Collectors;

public class GetDuplicate {




    public static int[] getDupl(int[] arr) {

        Set<Integer> seenElem = new HashSet<>();

        List<Integer> dupl = Arrays.stream(arr).filter(e -> !seenElem.add(e)).boxed().collect(Collectors.toList());


        int[] res = dupl.stream().mapToInt(e -> e).toArray();
        //unique element
        int[]  uniqueElem = Arrays.stream(arr).distinct().toArray();
        System.out.println(Arrays.toString(uniqueElem));

        //elements that appears only once;
        int[] appearsOnce = Arrays.stream(arr).boxed()
                            .collect(Collectors.groupingBy(e->e, Collectors.counting()))
                            .entrySet()
                            .stream()
                            .filter(e->e.getValue()==1)
                            .map(e->e.getKey())
                            .mapToInt(e->e)
                            .toArray();

        System.out.println(Arrays.toString(appearsOnce));
        return res;
        /*
        // Accumulate names into a List
List<String> list = people.stream()
  .map(Person::getName)
  .collect(Collectors.toList());

// Accumulate names into a TreeSet
Set<String> set = people.stream()
  .map(Person::getName)
  .collect(Collectors.toCollection(TreeSet::new));

// Convert elements to strings and concatenate them, separated by commas
String joined = things.stream()
  .map(Object::toString)
  .collect(Collectors.joining(", "));

// Compute sum of salaries of employee
int total = employees.stream()
  .collect(Collectors.summingInt(Employee::getSalary));

// Group employees by department
Map<Department, List<Employee>> byDept = employees.stream()
  .collect(Collectors.groupingBy(Employee::getDepartment));

// Compute sum of salaries by department
Map<Department, Integer> totalByDept = employees.stream()
  .collect(Collectors.groupingBy(Employee::getDepartment,
                                 Collectors.summingInt(Employee::getSalary)));

// Partition students into passing and failing
Map<Boolean, List<Student>> passingFailing = students.stream()
  .collect(Collectors.partitioningBy(s -> s.getGrade() >= PASS_THRESHOLD));
*/

    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,4,5,5};
        int[] res = getDupl(arr);
        System.out.println(Arrays.toString(res));
    }
}
