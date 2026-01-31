package org.kas.demos.Prac.CoderpatQuest.DAY5_22_09;/*
 * Click `Run` to execute the snippet below!
 */


class LongestFirstRepeatingSequence2 {
  /*
  Given a String “aabbbbddcc” find the longest first
  repeating index and its length. (Input: “aabbbbddcc” Output: [2,4] 2 is
  the index and 4 is the length
   */
    //aaabbbccc 0 3
    //aabbbbcccc 2 4
  static int[] getLongestFrstRepChar(String str){
    int[] startIndLeng = {-1,0};
    int n=str.length(),left=0,maxLength=0,start=-1;
    for(int i=0;i<n;i++){
      if(i+1 < n && str.charAt(i) != str.charAt(i+1)){
          if(i-left+1>1 && i-left+1>maxLength){
            start=left;
            maxLength=i-left+1;
          }
          left = i+1;


      }

    }
      if(str.charAt(str.length()-1) == str.charAt(str.length()-2)){
          if(str.length()-1-left+1>1 && str.length()-1-left+1>maxLength){
            start=left;
            maxLength=str.length()-1-left+1;
          }
      }
    return new int[]{start,maxLength};
  }
  public static void main(String[] args) {
    

    
    int[] startIndLeng = getLongestFrstRepChar("aabbbbddcc");
    System.out.println("startIndex: "+startIndLeng[0] +" maxLength: " +startIndLeng[1]);


int[] startIndLeng1 = getLongestFrstRepChar("aaabbbccc");
    System.out.println("startIndex: "+startIndLeng1[0] +" maxLength: " +startIndLeng1[1]);

      int[] startIndLeng3 = getLongestFrstRepChar("abcde");
      System.out.println("startIndex: "+startIndLeng3[0] +" maxLength: " +startIndLeng3[1]);

      int[] startIndLeng4 = getLongestFrstRepChar("aabbbbcccc");
      System.out.println("startIndex: "+startIndLeng4[0] +" maxLength: " +startIndLeng4[1]);

      int[] startIndLeng5 = getLongestFrstRepChar("aabbbbddcc");
      System.out.println("startIndex: "+startIndLeng5[0] +" maxLength: " +startIndLeng5[1]);

      int[] startIndLeng6 = getLongestFrstRepChar("abccddeeee");
      System.out.println("startIndex: "+startIndLeng6[0] +" maxLength: " +startIndLeng6[1]);

      int[] startIndLeng7 = getLongestFrstRepChar("abccddeee");
      System.out.println("startIndex: "+startIndLeng7[0] +" maxLength: " +startIndLeng7[1]);

      //abcccddeee
  }
}
