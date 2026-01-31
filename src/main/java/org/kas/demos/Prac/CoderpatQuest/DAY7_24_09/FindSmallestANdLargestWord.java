package org.kas.demos.Prac.CoderpatQuest.DAY7_24_09;

public class FindSmallestANdLargestWord {

/* 
   Program to find Smallest and Largest Word in a String.Input :This is a test string Output : Minimum length word: is Maximum length word: string
   */

  public static String[] getFindSmallestANdLargestWord(String str){
    StringBuilder res = new StringBuilder();
//"Ravi had been saying that he had been there"
    String[] splitStrs= str.split(" ");
    String smallestWord ="";
    String largestWord="";
    int smallestLen = Integer.MAX_VALUE,largestLen = Integer.MIN_VALUE;
    for(int i=0;i<splitStrs.length;i++){
      int currlen = splitStrs[i].length();
      if(currlen >1 && smallestLen > currlen){
        smallestWord = splitStrs[i];
        smallestLen=currlen;
      }

      if(currlen >1 && largestLen < currlen){
        largestWord = splitStrs[i];
        largestLen=currlen;
      }
    }
    return new String[]{smallestWord,largestWord};
  }

  


  public static void main(String[] args) {

    String str = "Ravi had been saying that he had been there";
    String res[] = getFindSmallestANdLargestWord(str);
    System.out.println("smallest: "+res[0] + " largest: "+ res[1]);
  }
}


