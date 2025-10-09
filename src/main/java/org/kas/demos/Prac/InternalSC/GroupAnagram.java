package org.kas.demos.Prac.InternalSC;

import java.util.*;

class GroupAnagram {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>>  mapANag  = new HashMap<>();

        for(String str:strs){
            char[] curr = str.toCharArray();
            Arrays.sort(curr);
            String sortedStr = new String(curr);
            if(!mapANag.containsKey(sortedStr)) {
                mapANag.put(sortedStr, new ArrayList<>());
            }
            mapANag.get(sortedStr).add(str);

        }


        return new ArrayList<>(mapANag.values());
    }
}