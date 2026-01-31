package org.kas.demos.Prac.CoderpatQuest.DAY2_17_09;

import java.util.ArrayList;
import java.util.List;

public class ShortestDistance0 {
// Input two words returns the shortest distance between their two midpoints in number of characters
  // Words can appear multiple times in any order and should be case insensitive.

  // E.g. for the document="Example we just made up"
  //   shortestDistance( document, "we", "just" ) == 4

  /**Distance between 2 word Mid Point
   * Calculates the shortest distance between the midpoints of two specified words in a document.
   * Words can appear multiple times and the comparison is case-insensitive.
   *
   * @param document The string representing the document.
   * @param word1 The first word to search for.
   * @param word2 The second word to search for.
   * @return The shortest distance between the midpoints of any occurrence of the two words.
   */
  public static double shortestDistance(String document, String word1, String word2) {
    // Convert document to lowercase to handle case-insensitivity.
    String lowercasedDocument = document.toLowerCase();
    
    // Find all starting indices of word1 and word2.
    List<Integer> indices1 = findAllIndices(lowercasedDocument, word1.toLowerCase());
    List<Integer> indices2 = findAllIndices(lowercasedDocument, word2.toLowerCase());

    // If either word is not found, a meaningful distance cannot be calculated.
    if (indices1.isEmpty() || indices2.isEmpty()) {
      return -1.0; 
    }

    double shortestDistance = Double.MAX_VALUE;

    // Use two pointers to find the minimum distance between midpoints.
    int i = 0;
    int j = 0;
    while (i < indices1.size() && j < indices2.size()) {
      // Calculate the midpoint of the current occurrence of word1.
      double midpoint1 = indices1.get(i) + (double) word1.length() / 2;
      
      // Calculate the midpoint of the current occurrence of word2.
      double midpoint2 = indices2.get(j) + (double) word2.length() / 2;
      
      // Calculate the distance between the midpoints.
      double currentDistance = Math.abs(midpoint1 - midpoint2);
      
      // Update the shortest distance.
      shortestDistance = Math.min(shortestDistance, currentDistance);

      // Advance the pointer of the word with the smaller midpoint index.
      if (midpoint1 < midpoint2) {
        i++;
      } else {
        j++;
      }
    }

    return shortestDistance;
  }
  
  /**
   * Finds all starting indices of a given word within a document.
   *
   * @param document The string to search within.
   * @param word The word to find.
   * @return A list of starting indices.
   */
  private static List<Integer> findAllIndices(String document, String word) {
    List<Integer> indices = new ArrayList<>();
    int index = document.indexOf(word, 0);
    while (index != -1) {
      indices.add(index);
      index = document.indexOf(word, index + 1);
    }
    return indices;
  }

  public static boolean pass() {
    return  //shortestDistance(document, "and", "graphic") == 6d &&
        //shortestDistance(document, "transfer", "it") == 14d &&
        //shortestDistance(document, "Design", "filler" ) == 25d &&
      shortestDistance(document, "layout.", "It") == 6d;
  }

  public static void main(String[] args) {
    if (pass()) {
      System.out.println("Pass");
    } else {
      System.out.println("Some Fail");
    }
  }

  private static final String document;
  static{
    StringBuffer sb = new StringBuffer();
    sb.append("In publishing and graphic design, lorem ipsum is a filler text commonly used to demonstrate the graphic elements");
    sb.append(" lorem ipsum text has been used in typesetting since the 1960s or earlier, when it was popularized by advertisements");
    sb.append(" for Letraset transfer sheets. It was introduced to the Information Age in the mid-1980s by Aldus Corporation, which");

    document= """
            In publishing and graphic design, lorem ipsum is a
            filler text commonly used to demonstrate the graphic elements of a
            document or visual presentation. Replacing meaningful content that
            could be distracting with placeholder text may allow viewers to focus
            on graphic aspects such as font, typography, and page layout. It also
            reduces the need for the designer to come up with meaningful text, as
            they can instead use hastily generated lorem ipsum text. The lorem
            ipsum text is typically a scrambled section of De finibus bonorum et
            malorum, a 1st-century BC Latin text by Cicero, with words altered,
            added, and removed to make it nonsensical, improper Latin. A variation
            of the ordinary lorem ipsum text has been used in typesetting since
            the 1960s or earlier, when it was popularized by advertisements for
            Letraset transfer sheets. It was introduced to the Information Age in
            the mid-1980s by Aldus Corporation, which employed it in graphics and
            word processing templates for its desktop publishing program,
            PageMaker, for the Apple Macintosh. A common form of lorem ipsum
            reads: Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
            eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad
            minim veniam, quis nostrud exercitation ullamco laboris nisi ut
            aliquip ex ea commodo consequat. Duis aute irure dolor in
            reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
            pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
            culpa qui officia deserunt mollit anim id est laborum.""".replace('\n', ' ');

  }
}