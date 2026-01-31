package org.kas.demos.Prac.CoderpatQuest.DAY3_18_09;

import java.util.*;

public class RobotWalk {

  /**
   * Calculates the final position of a robot after following a path string.
   * The robot starts at (0,0) and moves according to the characters in the path.
   *
   * @param path The string of movement commands.
   * @return An Integer array of size 2, representing the final [x, y] coordinates.
   */
  public static Integer[] walk( String path ) {
    int x = 0;
    int y = 0;
    
    // Iterate through each character of the path string.
    for (char move : path.toCharArray()) {
      // Use a switch statement to handle the different movement commands.
      // Other characters are ignored.
      switch (move) {
        case 'U':
          y++; // Move up, y-coordinate increases.
          break;
        case 'D':
          y--; // Move down, y-coordinate decreases.
          break;
        case 'L':
          x--; // Move left, x-coordinate decreases.
          break;
        case 'R':
          x++; // Move right, x-coordinate increases.
          break;
        default:
          // Ignore any other characters not representing a movement.
          break;
      }
    }

    return new Integer[] {x, y};
  }

  public static boolean isEqual(Integer[] a, Integer[] b) {
    return Arrays.equals(a, b);
  }

  public static boolean pass() {
    boolean res = true;

    {
      String test = "UUU";
      Integer[] result = walk(test);
      res &= isEqual(result, new Integer[]{0, 3});
    }

    {
      String test = "ULDR";
      Integer[] result = walk(test);
      res &= isEqual(result, new Integer[]{0, 0});
    }

    {
      String test = "ULLLDUDUURLRLR";
      Integer[] result = walk(test);
      res &= isEqual(result, new Integer[]{-2, 2});
    }

    {
      String test = "UP LEFT 2xDOWN DOWN RIGHT RIGHT UP UP";
      Integer[] result = walk(test);
      // The code should ignore the non-movement characters.
      // U: y=1, P: ignore
      // L: x=-1, E: ignore, F: ignore, T: ignore
      // 2: ignore, x: ignore
      // D: y=0, O: ignore, W: ignore, N: ignore
      // D: y=-1, O: ignore, W: ignore, N: ignore
      // R: x=0, I: ignore, G: ignore, H: ignore, T: ignore
      // R: x=1, I: ignore, G: ignore, H: ignore, T: ignore
      // U: y=0, P: ignore
      // U: y=1, P: ignore
      // Final: x=1, y=1
      res &= isEqual(result, new Integer[]{1, 1});
    }
    
    // Additional test case: empty path
    {
      String test = "";
      Integer[] result = walk(test);
      res &= isEqual(result, new Integer[]{0, 0});
    }

    // Additional test case: all invalid characters
    {
      String test = "Hello World";
      Integer[] result = walk(test);
      res &= isEqual(result, new Integer[]{0, 0});
    }

    return res;
  }

  public static void main(String[] args) {
    if(pass()){
      System.out.println("Pass");
    } else {
      System.out.println("Test failures");
    }
  }
}