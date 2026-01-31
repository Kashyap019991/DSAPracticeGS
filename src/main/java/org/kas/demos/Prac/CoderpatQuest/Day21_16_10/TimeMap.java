package org.kas.demos.Prac.CoderpatQuest.Day21_16_10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Implement a time-based key-value data structure that supports:

Storing multiple values for the same key at specified time stamps
Retrieving the key's value at a specified timestamp
Implement the TimeMap class:

TimeMap() Initializes the object.
void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
String get(String key, int timestamp) Returns the most recent value of key if set was previously called on it and the most recent timestamp for that key prev_timestamp is less than or equal to the given timestamp (prev_timestamp <= timestamp). If there are no values, it returns "".
Note: For all calls to set, the timestamps are in strictly increasing order.
Example 1:
Input:
["TimeMap", "set", ["alice", "happy", 1], "get", ["alice", 1], "get", ["alice", 2], "set", ["alice", "sad", 3], "get", ["alice", 3]]
Output:
[null, null, "happy", "happy", null, "sad"]
Explanation:
TimeMap timeMap = new TimeMap();
timeMap.set("alice", "happy", 1);  // store the key "alice" and value "happy" along with timestamp = 1.
timeMap.get("alice", 1);           // return "happy"
timeMap.get("alice", 2);           // return "happy", there is no value stored for timestamp 2, thus we return the value at timestamp 1.
timeMap.set("alice", "sad", 3);    // store the key "alice" and value "sad" along with timestamp = 3.
timeMap.get("alice", 3);           // return "sad"
Constraints:
1 <= key.length, value.length <= 100
key and value only include lowercase English letters and digits.
1 <= timestamp <= 1000
=>Also asked about approaches and time complexity.

 */
    // Nested class to store the timestamp and value.
      class Pair {
          int timestamp;
          String value;

          public Pair(int timestamp, String value) {
              this.timestamp = timestamp;
              this.value = value;
          }

      }
    // The TimeMap class
    class TimeMap {
        private final Map<String, List<Pair>> keyStore;

        public TimeMap() {
            keyStore = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            keyStore.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(timestamp, value));
        }

        public String get(String key, int timestamp) {
            if (!keyStore.containsKey(key)) {
                return "";
            }

            List<Pair> values = keyStore.get(key);
            String result = "";

            int left = 0;
            int right = values.size() - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                Pair currentPair = values.get(mid);

                if (currentPair.timestamp <= timestamp) {
                    result = currentPair.value;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return result;
        }

        // The main method for testing
        public static void main(String[] args) {
            // Instantiate the TimeMap object.
            TimeMap timeMap = new TimeMap();

            // Perform set and get operations as per the example.
            System.out.println("Calling timeMap.set(\"alice\", \"happy\", 1);");
            timeMap.set("alice", "happy", 1);

            System.out.println("Calling timeMap.get(\"alice\", 1);");
            String result1 = timeMap.get("alice", 1);
            System.out.println("Output: " + result1); // Expected: "happy"

            System.out.println("Calling timeMap.get(\"alice\", 2);");
            String result2 = timeMap.get("alice", 2);
            System.out.println("Output: " + result2); // Expected: "happy"

            System.out.println("Calling timeMap.set(\"alice\", \"sad\", 3);");
            timeMap.set("alice", "sad", 3);

            System.out.println("Calling timeMap.get(\"alice\", 3);");
            String result3 = timeMap.get("alice", 3);
            System.out.println("Output: " + result3); // Expected: "sad"

            System.out.println("Calling timeMap.get(\"alice\", 4);");
            String result4 = timeMap.get("alice", 4);
            System.out.println("Output: " + result4); // Expected: "sad"

            System.out.println("Calling timeMap.get(\"bob\", 5);");
            String result5 = timeMap.get("bob", 5);
            System.out.println("Output: " + result5); // Expected: ""
        }

    }


