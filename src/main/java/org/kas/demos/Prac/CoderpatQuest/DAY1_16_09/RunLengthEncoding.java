package org.kas.demos.Prac.CoderpatQuest.DAY1_16_09;

public class RunLengthEncoding {
//https://leetcode.com/problems/string-compression/description/
    //lc 443 similar done

    /*
     * Implement a run length encoding function.
     * For a string input the function returns output encoded as follows:
     *
     * "a"     -> "a1"
     * "aa"    -> "a2"
     * "aabbb" -> "a2b3"
     * "aabbbaaabababab"  ->  "a2b3a3b1a1b1a1b1a1b1"
     */
    public static String encode(String input) {
        StringBuilder rleBuilder = new StringBuilder();
        int n= input.length();
        int count =1;
        //AAAABBBCCDAA n=12
        for(int i=0;i<n;i++){
            //i+1 < n cond for last char
            if(i+1 < n && input.charAt(i) == input.charAt(i+1)){
                count++;

            }else{
                rleBuilder.append(input.charAt(i));
                rleBuilder.append(count);
                count=1;

            }
        }

        return  rleBuilder.toString();
    }

    public static void main(String[] args) {
        String test1 = "WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW";
        String test2 = "AAAABBBCCDAB";
        String test5 = "AAAABBBCCDAA";
        String test3 = "";
        String test4 = "A";

        System.out.println("Encoded '" + test1 + "': " + encode(test1));
        System.out.println("Encoded '" + test2 + "': " + encode(test2));
        System.out.println("Encoded '" + test3 + "': " + encode(test3));
        System.out.println("Encoded '" + test4 + "': " + encode(test4));
        System.out.println("Encoded '" + test5 + "': " + encode(test5));
    }
}