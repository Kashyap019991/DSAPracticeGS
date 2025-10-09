package org.kas.demos.Prac.CoderpatQuest.DAY7_24_09;

public class ReverseWords {


  //Print words of a string in reverse order. Let there be a string say
  // “I AM A TESTER So, the output should be TESTER A AM I”
   
  public static String getRevWord(String str){
    StringBuilder res = new StringBuilder();

    String[] splitStrs= str.split(" ");

    for(int i=splitStrs.length-1;i>=0;i--){
      res.append(splitStrs[i]);

      if(i!=0)
        res.append(" ");
    }
    return res.toString();
  }

  


  public static void main(String[] args) {

    String str = "I AM A TESTER";
    String res = getRevWord(str);
    System.out.println(res);
  }
}


