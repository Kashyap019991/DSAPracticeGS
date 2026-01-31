package org.kas.demos.Prac.CoderpatQuest.DAY14_07_10;

import java.util.*;
/*
You are given the availability of multiple people in the form of time intervals. Each person is available during a specific time range. Write a program to split the time intervals into smaller sub-intervals and determine who is available during each sub-interval.

Example Input:
Person p1 is available from 10 to 15.
Person p2 is available from 12 to 16.
Expected Output:
10 to 12 -> p1
12 to 15 -> p1 and p2
15 to 16 -> p2
 */
public class AvailabilityTracker {

    static class TimePoint {
        int time;
        String person;
        boolean isStart;

        TimePoint(int time, String person, boolean isStart) {
            this.time = time;
            this.person = person;
            this.isStart = isStart;
        }
    }

    public static void main(String[] args) {
        Map<String, int[]> schedules = new LinkedHashMap<>();
        schedules.put("p1", new int[]{10, 15});
        schedules.put("p2", new int[]{12, 16});

        trackAvailability(schedules);
    }

    public static void trackAvailability(Map<String, int[]> schedules) {
        List<TimePoint> timePoints = new ArrayList<>();
        
        // Step 1: Create a list of all start and end time points
        for (Map.Entry<String, int[]> entry : schedules.entrySet()) {
            String person = entry.getKey();
            int[] interval = entry.getValue();
            timePoints.add(new TimePoint(interval[0], person, true));
            timePoints.add(new TimePoint(interval[1], person, false));
        }

        // Step 2: Sort the list of time points
        // Sorts primarily by time, then by event type (start before end)
        timePoints.sort((a, b) -> {
            if (a.time != b.time) {
                return a.time - b.time;
            }
            // For same time, start events come before end events
            return a.isStart ? -1 : 1;
        });

        Set<String> activePeople = new TreeSet<>();
        int lastTime = -1;
//("p1", new int[]{10, 15});
//("p2", new int[]{12, 16});

        // Step 3: Sweep through the sorted time points
        for (TimePoint tp : timePoints) {
            int currentTime = tp.time;

            // Process the interval from the last event to the current one
            if (currentTime > lastTime && lastTime != -1 && !activePeople.isEmpty()) {
                System.out.print(lastTime + " to " + currentTime + " -> ");
                StringJoiner sj = new StringJoiner(" and ");
                activePeople.forEach(sj::add);
                System.out.println(sj.toString());
            }

            // Update the set of active people based on the current event
            if (tp.isStart) {
                activePeople.add(tp.person);
            } else {
                activePeople.remove(tp.person);
            }
            lastTime = currentTime;
        }
    }
}
