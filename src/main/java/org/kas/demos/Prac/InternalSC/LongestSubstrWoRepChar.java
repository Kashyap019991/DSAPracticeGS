package org.kas.demos.Prac.InternalSC;

import java.util.HashMap;

public class LongestSubstrWoRepChar {

    public static void main(String[] args) {
        String str = "abcabcbb";
        int ans = longestSubStrWoRepChar(str);
        System.out.println(ans);
    }
    static int longestSubStrWoRepChar(String str){
        HashMap<Character,Integer> mapPos = new HashMap<Character,Integer>();
        int left=0,longestSubStrCount=0;
        for(int right=0;right<str.length();right++){
            char currChar = str.charAt(right);
            if(mapPos.containsKey(currChar)){
                left = mapPos.get(currChar)+1;
            }
            longestSubStrCount = Math.max(longestSubStrCount,right-left+1);
            mapPos.put(currChar,right);
        }
        return longestSubStrCount;
    }

}
