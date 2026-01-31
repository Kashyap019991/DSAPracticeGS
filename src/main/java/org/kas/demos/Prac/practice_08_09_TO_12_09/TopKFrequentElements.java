package org.kas.demos.Prac.practice_08_09_TO_12_09;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
/* ltc347
Input: nums = [1,1,1,2,2,3], k = 2

Output: [1,2]
 */

    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];

        //create freq map
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int num:nums){
            freqMap.put(num, freqMap.getOrDefault(num,0)+1);
        }

        //put in prio queue which remove smaller freq firest , so min heap
        PriorityQueue<Map.Entry<Integer,Integer>> minHeapFreq
                = new PriorityQueue<>((a,b) -> a.getValue()-b.getValue());
        //push in pq andif count > k then remove
        for(Map.Entry<Integer,Integer> entry:freqMap.entrySet()){
            minHeapFreq.offer(entry);
            if(minHeapFreq.size()>k){
                minHeapFreq.remove();
            }
        }

        //insert to arr that k elem key
        for(int i=k-1;i>=0;i--){
            result[i] = minHeapFreq.remove().getKey();
        }

        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements solution = new TopKFrequentElements();

        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        int[] result1 = solution.topKFrequent(nums1, k1);
        System.out.print("Top " + k1 + " frequent elements in [1,1,1,2,2,3]: ");
        for (int val : result1) {
            System.out.print(val + " ");
        }
        System.out.println(); // Expected: 1 2

        int[] nums2 = {1};
        int k2 = 1;
        int[] result2 = solution.topKFrequent(nums2, k2);
        System.out.print("Top " + k2 + " frequent elements in [1]: ");
        for (int val : result2) {
            System.out.print(val + " ");
        }
        System.out.println(); // Expected: 1
    }
}