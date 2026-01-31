package org.kas.demos.Prac.Company_Interv.vsa.Quest2;

import java.util.*;

public class DroneDelivery {
    public static int solution(int target, int[] stations) {
        Arrays.sort(stations);
        int footDistance = 0;
        int currentPosition = 0;

        while (currentPosition < target) {
            // Find the nearest station ahead of currentPosition
            int nextStation = -1;
            for (int station : stations) {
                if (station >= currentPosition) {
                    nextStation = station;
                    break;
                }
            }

            if (nextStation == -1 || nextStation > target) {
                // No station ahead, walk to target
                footDistance += target - currentPosition;
                break;
            }

            // Walk to the next station
            footDistance += nextStation - currentPosition;

            // Deploy drone from nextStation
            int droneReach = nextStation + 10;
            if (droneReach >= target) {
                // Drone reaches target
                break;
            }

            // Find next station within drone reach
            int bestStation = -1;
            for (int station : stations) {
                if (station > nextStation && station <= droneReach) {
                    bestStation = station;
                }
            }

            if (bestStation == -1) {
                // No station within drone reach, walk to drone's landing point
                currentPosition = droneReach;
            } else {
                // Drone lands at bestStation
                currentPosition = bestStation;
            }
        }

        return footDistance;
    }

    public static void main(String[] args) {
        System.out.println(solution(23, new int[]{7, 4, 14})); // Output: 4
        System.out.println(solution(27, new int[]{15, 7, 3, 10})); // Output: 7
        System.out.println(solution(10, new int[]{})); // Output: 10
    }
}
