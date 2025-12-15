package org.kas.demos.Prac.CoderpatQuest.DAY3_18_09;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TopLogIpRegex {

  /**
   * Given a log file, return IP address(es) which accesses the site most often.
   * This enhanced version uses a regular expression to handle corrupted or
   * irregularly placed IP addresses and includes validation.
   *
   * @param lines An array of strings, where each string is a line from a log file.
   * @return The IP address that appears most frequently. If there's a tie, any one
   *         of the top IP addresses can be returned.
   */
  public static String findTopIpaddress(String[] lines) {
    if (lines == null || lines.length == 0) {
      return null;
    }

    // A HashMap to store the count of each valid IP address.
    Map<String, Integer> ipCounts = new HashMap<>();

    // A regular expression pattern to match a valid IPv4 address.
    // \b matches a word boundary to ensure we match a whole IP address.
    // (?:...) is a non-capturing group for the 0-255 number range.
    String ipRegex = "\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b";
    Pattern pattern = Pattern.compile(ipRegex);

    // Iterate through each line of the log file.
    for (String line : lines) {
     Matcher matcher = pattern.matcher(line);
      while (matcher.find()) {
        String ipAddress = matcher.group();
        if (isValidIpAddress(ipAddress)) {
          // Increment the count for the current valid IP address.
          ipCounts.put(ipAddress, ipCounts.getOrDefault(ipAddress, 0) + 1);
        }
      }
    }

    // Find the IP address with the highest count.
    String topIpAddress = null;
    int maxCount = 0;

    // Iterate through the map's entries to find the maximum count.
    for (Map.Entry<String, Integer> entry : ipCounts.entrySet()) {
      if (entry.getValue() > maxCount) {
        maxCount = entry.getValue();
        topIpAddress = entry.getKey();
      }
    }

    return topIpAddress;
  }

  /**
   * Helper method to validate an IPv4 address.
   *
   * @param ip The IP address string to validate.
   * @return true if the IP address is valid, false otherwise.
   */
  private static boolean isValidIpAddress(String ip) {
    String[] parts = ip.split("\\.");
    if (parts.length != 4) {
      return false;
    }
    for (String part : parts) {
      try {
        int value = Integer.parseInt(part);
        if (value < 0 || value > 255) {
          return false;
        }
        // Handle cases like "01", which should be invalid.
        if (part.length() > 1 && part.startsWith("0")) {
          return false;
        }
      } catch (NumberFormatException e) {
        // Part is not a number, so the IP is invalid.
        return false;
      }
    }
    return true;
  }
     
  public static boolean doTestsPass() {
    boolean passed = true;

    // Test case 1: Standard case with a clear winner.
    String lines1[] = new String[] {
        "10.0.0.1 - log entry 1 11",
        "10.0.0.1 - log entry 2 213",
        "10.0.0.2 - log entry 133132"
    };
    String result1 = findTopIpaddress(lines1);
    passed &= "10.0.0.1".equals(result1);
    if (!passed) {
      System.out.println("Test 1 failed. Expected: 10.0.0.1, Got: " + result1);
    }
    
    // Test case 2: Tied IPs, any one is acceptable.
    String lines2[] = new String[] {
        "192.168.1.1 - log",
        "192.168.1.2 - log",
        "192.168.1.1 - log",
        "192.168.1.2 - log"
    };
    String result2 = findTopIpaddress(lines2);
    passed &= ("192.168.1.1".equals(result2) || "192.168.1.2".equals(result2));
    if (!("192.168.1.1".equals(result2) || "192.168.1.2".equals(result2))) {
      System.out.println("Test 2 failed. Expected: 192.168.1.1 or 192.168.1.2, Got: " + result2);
    }
    
    // Test case 3: Empty input array.
    String lines3[] = new String[]{};
    String result3 = findTopIpaddress(lines3);
    passed &= result3 == null;
    if (result3 != null) {
      System.out.println("Test 3 failed. Expected: null, Got: " + result3);
    }

    // Test case 4: Single line input.
    String lines4[] = new String[] {
        "172.16.0.1 - log entry"
    };
    String result4 = findTopIpaddress(lines4);
    passed &= "172.16.0.1".equals(result4);
    if (!"172.16.0.1".equals(result4)) {
      System.out.println("Test 4 failed. Expected: 172.16.0.1, Got: " + result4);
    }
    
    // Test case 5: Corrupt IP (number out of range) in the line.
    String lines5[] = new String[] {
        "User 256.0.0.1 logged in from 10.0.0.1",
        "User 10.0.0.1 logged in"
    };
    String result5 = findTopIpaddress(lines5);
    passed &= "10.0.0.1".equals(result5);
    if (!"10.0.0.1".equals(result5)) {
      System.out.println("Test 5 failed. Expected: 10.0.0.1, Got: " + result5);
    }

    // Test case 6: Multiple IPs in a line.
    String lines6[] = new String[] {
        "1.1.1.1 access site from 2.2.2.2",
        "1.1.1.1 access site from 3.3.3.3",
        "2.2.2.2 access site from 4.4.4.4"
    };
    String result6 = findTopIpaddress(lines6);
    passed &= "1.1.1.1".equals(result6);
    if (!"1.1.1.1".equals(result6)) {
      System.out.println("Test 6 failed. Expected: 1.1.1.1, Got: " + result6);
    }

    return passed;
  }
  
  public static void main(String[] args) {
    if (doTestsPass()) {
      System.out.println("All tests passed");
    } else {
      System.out.println("Some tests failed");
    }
  }
}