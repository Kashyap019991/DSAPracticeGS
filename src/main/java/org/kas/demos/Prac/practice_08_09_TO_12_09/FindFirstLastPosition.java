package org.kas.demos.Prac.practice_08_09_TO_12_09;
//lc 3105
class FindFirstLastPosition {
    public int findFirstOccr(int[] nums, int target){
        int ans=-1;
        int low=0;
        int high = nums.length-1;

        while(low<=high){
            int mid = low +(high-low)/2;
            if(nums[mid] == target){
                //possible first occr
                ans = mid;
                high = mid-1;//continue search onl left may be first occr can be there
            }
            else if(nums[mid] > target){
                high=mid-1;
            }
            else{
                low =mid+1;
            }

        }
        return ans;
    }
    public int findLastOccr(int[] nums, int target){
        int ans=-1;
        int low=0;
        int high = nums.length-1;

        while(low<=high){
            int mid = low +(high-low)/2;
            if(nums[mid] == target){
                //possible last occr
                ans = mid;
                low = mid+1;//continue serch on right side , may be last occr can be there
            }
            else if(nums[mid] > target){
                high=mid-1;
            }
            else{
                low =mid+1;
            }
            
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        int firstOccr = findFirstOccr(nums,target);
        int lastOccr = findLastOccr(nums,target);
        ans[0]=firstOccr;
        ans[1] = lastOccr;
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        FindFirstLastPosition frslast = new FindFirstLastPosition();
        int[] result1 = frslast.searchRange(nums1, target1);
        System.out.println("Input: " + java.util.Arrays.toString(nums1) + ", Target: " + target1);
        System.out.println("Output: " + java.util.Arrays.toString(result1)); // Expected: [3, 4]

        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int target2 = 6;
        int[] result2 = frslast.searchRange(nums2, target2);
        System.out.println("Input: " + java.util.Arrays.toString(nums2) + ", Target: " + target2);
        System.out.println("Output: " + java.util.Arrays.toString(result2)); // Expected: [-1, -1]

        int[] nums3 = {};
        int target3 = 0;
        int[] result3 = frslast.searchRange(nums3, target3);
        System.out.println("Input: " + java.util.Arrays.toString(nums3) + ", Target: " + target3);
        System.out.println("Output: " + java.util.Arrays.toString(result3)); // Expected: [-1, -1]

        int[] nums4 = {1, 1, 1, 1, 1};
        int target4 = 1;
        int[] result4 = frslast.searchRange(nums4, target4);
        System.out.println("Input: " + java.util.Arrays.toString(nums4) + ", Target: " + target4);
        System.out.println("Output: " + java.util.Arrays.toString(result4)); // Expected: [0, 4]
    }
}