package org.kas.demos.Prac.Company_Interv.vsa;

public class Vsa3 {
    public static int solution(int[] centerCapacities, String[] dailyLog) {
        int n = centerCapacities.length;
        int[] remaining = centerCapacities.clone();
        int[] processed = new int[n];
        boolean[] closed = new boolean[n];
        int currentCenter = 0;

        for (String log : dailyLog) {
            if (log.startsWith("CLOSURE")) {
                int closedIndex = Integer.parseInt(log.split(" ")[1]);
                closed[closedIndex] = true;
            } else if (log.equals("PACKAGE")) {
                boolean delivered = false;
                int start = currentCenter;

                while (!delivered) {
                    if (!closed[currentCenter] && remaining[currentCenter] > 0) {
                        processed[currentCenter]++;
                        remaining[currentCenter]--;
                        delivered = true;
                    } else {
                        currentCenter = (currentCenter + 1) % n;
                        if (currentCenter == start) {
                            // Completed one full rotation, restore capacities
                            for (int i = 0; i < n; i++) {
                                if (!closed[i]) {
                                    remaining[i] = centerCapacities[i];
                                }
                            }
                        }
                    }
                }

                // Move to next center for next package
                currentCenter = (currentCenter + 1) % n;
            }
        }

        // Find the center with the most processed packages, tie-break by highest index
        int maxPackages = -1;
        int resultIndex = -1;
        for (int i = 0; i < n; i++) {
            if (processed[i] >= maxPackages) {
                maxPackages = processed[i];
                resultIndex = i;
            }
        }

        return resultIndex;
    }

    public static void main(String[] args) {
        int[] centerCapacities = {1, 2, 1, 2, 1};
        String[] dailyLog = {
            "PACKAGE", "PACKAGE", "CLOSURE 2", "PACKAGE",
            "CLOSURE 3", "PACKAGE", "PACKAGE"
        };
        System.out.println(solution(centerCapacities, dailyLog)); // Output: 1
    }
}
