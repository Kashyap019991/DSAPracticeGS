package org.kas.demos.Prac.practice_08_09_TO_12_09;

class AreaContainWithMostWater {
    public int maxArea(int[] height) {
       int left = 0, right = height.length-1;
        int maxHeight = Integer.MIN_VALUE;
        
       while(left<right) {
        maxHeight = Math.max(maxHeight, (right - left)*Math.min(height[left],height[right]));

        if(height[left] <= height[right])
            left++;
        else
            right--;
       }
       return maxHeight;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(new AreaContainWithMostWater().maxArea(height));
    }
}