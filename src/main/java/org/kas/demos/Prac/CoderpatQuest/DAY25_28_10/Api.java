import java.util.List;

import java.util.*;


import java.util.*;

class Result {

    public static int getMinimumOperations(List<Integer> executionTime, int x, int y) {
        Collections.sort(executionTime);

        long left = 0;
        long right = (long)1e12; // high upper bound
        int ans = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (canFinish(executionTime, x, y, mid)) {
                ans = (int) mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private static boolean canFinish(List<Integer> jobs, int x, int y, long operations) {
        long diff = x - y;
        long needed = 0;

        for (int i = jobs.size() - 1; i >= 0; i--) {
            long remain = jobs.get(i) - operations * y;
            if (remain > 0) {
                // number of times this job must be major
                long requiredMajorOps = (long)Math.ceil((double)remain / diff);
                needed += requiredMajorOps;
                if (needed > operations)
                    return false;
            }
        }

        return true;
    }
}