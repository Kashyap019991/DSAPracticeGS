package org.kas.demos.Prac.CoderpatQuest.DAY3_18_09;

import java.util.HashMap;
import java.util.Map;

public class TopLogIp {

  /**
   * Given a log file, return IP address(es) which accesses the site most often.
   *
   * @param lines An array of strings, where each string is a line from a log file.
   * @return The IP address that appears most frequently. If there's a tie, any one
   * of the top IP addresses can be returned.
   */
  public static String findTopIpaddress(String[] lines) {
    if (lines == null || lines.length == 0) {
      return null; // Or handle as an empty string, depending on requirements.
    }

    // A HashMap is an efficient way to store and count the occurrences of each IP address.
    // The IP address will be the key (String), and its count will be the value (Integer).
    Map<String, Integer> ipCounts = new HashMap<>();
  //10.0.0.1 - log entry 1 11
    // Iterate through each line of the log file.
    for (String line : lines) {
      // Assuming the IP address is the first word in each line, we can split the
      // string by space to get it. A more robust solution might use a regular expression
      // to handle different log formats, but for this problem, splitting is sufficient.
      String[] parts = line.split(" ");
      if (parts.length > 0) {
        String ipAddress = parts[0];
        // Increment the count for the current IP address.
        // getOrDefault is a convenient way to handle the case where the IP
        // address is not yet in the map.
        ipCounts.put(ipAddress, ipCounts.getOrDefault(ipAddress, 0) + 1);
      }
    }

    // Now, find the IP address with the highest count.
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
  