package org.kas.demos.Prac.CoderpatQuest.DAY6_23_09;/*
 * Click `Run` to execute the snippet below!
 */

/*
Given Input,print the following input: “SSSSSTTPPQ” Output:“5S2T2P1Q”.

 */

class RunLengthEncodingVarient {
  public static void main(String[] args) {
    String str= "SSSSSTTPPQ";
    int n = str.length();
    int currCount=1;
    StringBuilder strb = new StringBuilder();
    for(int i=0;i<n;i++){

      if(i+1 <n && str.charAt(i) == str.charAt(i+1)){
        currCount++;
      }else
      {
        
        strb.append(currCount).append(str.charAt(i));
        currCount=1;
        
      }
    }
    System.out.println(strb);
  }
}
