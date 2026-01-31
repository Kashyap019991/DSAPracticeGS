package org.kas.demos.Prac.practice_08_09_TO_12_09;

class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        //lc 424
        int[] charCount= new int[26];
        int n=s.length(),maxLength=0,left=0,maxCount=0;
        for(int right =0;right<n;right++){
            char currChar = s.charAt(right);
            charCount[currChar - 'A']++;//incr curr char freq in window
            maxLength = Math.max(charCount[currChar - 'A'],maxLength);//max freq of any char in curr window

            // Check if the current window is valid
            // (window size - max frequency) <= k means replacements needed are within limit
            if((right-left+1)-maxLength > k){
                // If not valid, shrink the window from the left
                charCount[s.charAt(left)-'A']--;
                left++;
                // Note: maxFrequency does not necessarily need to be re-calculated here
                // as we are only interested in the maximum frequency *within the current valid window*
                // and the maxLength will only be updated for valid windows.
            }
            maxCount = Math.max(maxCount,(right-left+1));

        }
        return maxCount;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement(s,k));
    }
}