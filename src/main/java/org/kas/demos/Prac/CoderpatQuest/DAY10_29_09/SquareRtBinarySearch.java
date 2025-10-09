package org.kas.demos.Prac.CoderpatQuest.DAY10_29_09;// Java program to Find the square root of given numbers
// using Binary search

// Importing libraries

class SquareRtBinarySearch {
  
    // Function to find cuberoot
    static int squareeroot(int number)
    {
        // Lower bound
        int left = 1;
      
        // Upper bound
        int right = number;

        int ans = 0;
        while (left <= right) {
          
            // Finding the mid value

            int mid = left + (right - left) / 2;
          
            // Checking the mid value
            if (mid * mid == number) {
                return mid;
            }

            // Shift the lower bound
            if (mid * mid < number) {
                left = mid + 1;
                ans = mid;
            }
          
            // Shift the upper bound
            else {
                right = mid - 1;
            }
        }
      
        // Return the ans
        return ans;
    }
    public static void main(String[] args)
    {
        int number = 2;
        System.out.println(squareeroot(number));


    }
}