package org.kas.demos.Prac.CoderpatQuest.DAY7_24_09;

public class RevIndividualWord {

//input:I AM A TESTER
  // Expected Output: I MA A RETSET
  public static String getRevIndividualWord(String str){
    StringBuilder res = new StringBuilder();

    String[] splitStrs= str.split(" ");

    for(int i=0;i<splitStrs.length;i++){
      res.append(new StringBuilder(splitStrs[i]).reverse());

      if(i<splitStrs.length-1)
        res.append(" ");
    }
    return res.toString();
  }

  


  public static void main(String[] args) {

    String str = "I AM A TESTER";
    String res = getRevIndividualWord(str);
    System.out.println(res);
  }
}


