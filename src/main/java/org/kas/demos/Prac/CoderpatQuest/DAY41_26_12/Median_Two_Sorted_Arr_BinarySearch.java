package org.kas.demos.Prac.CoderpatQuest.DAY41_26_12;

class Median_Two_Sorted_Arr_BinarySearch {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1= nums1.length;
        int n2= nums2.length;

        //perform binary search on smaller array
        if(n1>n2) return findMedianSortedArrays(nums2,nums1);

        int low =0,high=n1;
       
        int left = (n1+n2+1)/2;//for odd +1

        while(low <= high){
            //System.out.println(low +"  "+high);
             int mid1 = (low+high)/2;
            int mid2 = left -  mid1;
            //System.out.println(left +"  "+mid1+" "+mid2);
            int l1 = Integer.MIN_VALUE,l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE,r2 = Integer.MAX_VALUE;

            if(mid1 < n1) r1 = nums1[mid1];

            if(mid2 < n2) r2 = nums2[mid2];

            if(mid1-1 >=0) l1 = nums1[mid1-1];
            if(mid2-1 >=0) l2 = nums2[mid2-1];

            if(l1 <= r2 && l2 <= r1){
                //ans found check for even or odd
                if((n1+n2)%2 == 0) 
                    return ((double)(Math.max(l1,l2) + Math.min(r1,r2)))/2.0;
                else
                    return Math.max(l1,l2);
            }
            else if(l1 > r2)
                high = mid1-1;
            else 
                low = mid1+1;
        }
        return 0;
    }
    public static void main(String[] args) {
        Median_Two_Sorted_Arr_BinarySearch sol = new Median_Two_Sorted_Arr_BinarySearch();

        // Test Case 1: Odd total length (m=2, n=1, total=3)
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println("Test 1 - Median: " + sol.findMedianSortedArrays(nums1, nums2)); // Expected: 2.0

        // Test Case 2: Even total length (m=2, n=2, total=4)
        int[] nums1_2 = {1, 2,3,4,5};
        int[] nums2_2 = {6,7,8};
        System.out.println("Test 2 - Median: " + sol.findMedianSortedArrays(nums1_2, nums2_2)); // Expected: 2.5

        // Test Case 3: Larger arrays (m=5, n=6, total=11)
        int[] nums1_3 = {3, 5, 6, 12, 15};
        int[] nums2_3 = {3, 4, 6, 10, 10, 12};
        System.out.println("Test 3 - Median: " + sol.findMedianSortedArrays(nums1_3, nums2_3)); // Expected: 6.0
    }
}