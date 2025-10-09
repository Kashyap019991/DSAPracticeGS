package org.kas.demos.Prac.CoderpatQuest.DAY14_07_10;

import java.util.ArrayList;
import java.util.List;

class MiddleInList {

  public static Integer middle(List<Integer> input) {
    if (input == null || input.isEmpty()) {
      return null;
    }

    int slow = 0;
    int fast = 0;
    
    // We use a try-catch to detect the end of the list without using size().
    try {
      while (true) {
        // Move fast pointer two steps ahead
        input.get(fast); // Check if fast is valid
        input.get(fast + 1); // Check if fast+1 is valid
        fast += 2;
        
        // Move slow pointer one step ahead
        slow++;
        System.out.println(slow +" : "+fast);
      }
    } catch (IndexOutOfBoundsException e) {
      // The loop terminates when fast goes out of bounds.
      // At this point, 'slow' holds the index of the middle element.
    }
    
    return input.get(slow);
  }
  
  public static void main(String[] args) {
    List<Integer> input1 = List.of(1, 2, 3, 4, 5, 6, 7);
    Integer middle1 = middle(new ArrayList<>(input1)); // Convert List.of to mutable ArrayList
    System.out.println("Middle of " + input1 + " is: " + middle1); // Output: 4

    List<Integer> input2 = List.of(1, 2, 3, 4, 5, 6);
    Integer middle2 = middle(new ArrayList<>(input2));
    System.out.println("Middle of " + input2 + " is: " + middle2); // Output: 4
  }
}
