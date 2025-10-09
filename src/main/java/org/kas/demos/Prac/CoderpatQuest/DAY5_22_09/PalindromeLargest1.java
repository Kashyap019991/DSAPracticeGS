package org.kas.demos.Prac.CoderpatQuest.DAY5_22_09;/*
 * Click `Run` to execute the snippet below!
 */

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class PalindromeLargest1 {
  static String getPalindromeHelper(String str, int start,int end){
    int n= str.length();
    int maxLen=0;
    while(start >=0 && end < n){
      if(str.charAt(start) == str.charAt(end)){
        //if (start - end + 1 > maxLen){
        maxLen = Math.max(maxLen, end-start+1);
        start--;
        end++;
       // }
      }
      else{
        break;
      }
      
    }
    //System.out.println("start"+start +" "+"end:" +end);
    return str.substring(start+1,start+1+maxLen);
  }
  static String getLargestPalindrome(String str){
    int n=str.length();
    int maxLength=0;
    String currRes="";
    String overallRes="";
    for(int i=0;i<n;i++){
      String oddLengthCount = getPalindromeHelper(str, i,i);

      String evenLengthCount = getPalindromeHelper(str, i,i+1);

      currRes= (oddLengthCount.length()>evenLengthCount.length())?oddLengthCount:evenLengthCount;
      overallRes = (currRes.length()>overallRes.length())?currRes:overallRes;
    }
    return overallRes;
    //return maxLength;
  }
  public static void main(String[] args) {
    String input4 = "racecar";
    String input2 = "cbbd";
    String input1 = "babad";
    String input0= "a";
    
    System.out.println(getLargestPalindrome(input4));
    System.out.println(getLargestPalindrome(input2));
    System.out.println(getLargestPalindrome(input1));
    System.out.println(getLargestPalindrome(input0));
  }
}
