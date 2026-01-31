package org.kas.demos.Prac.CoderpatQuest.DAY14_07_10;/*
 * Click `Run` to execute the snippet below!
 */

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class atotimew {
  static int atoi(String str){
    long res = 0;
    int i=0;
    char sign = '+';
    if(str.charAt(0) == '-') 
      sign = '-' ;
    while(str.charAt(i)== ' '){
      i++;
    }
    
    str = str.substring(i);
    for(Character ch:str.toCharArray()){
      if(Character.isAlphabetic(ch)){
        break;
      }
      if(Character.isDigit(ch)){
        
        
        res = (res*10 )+(Integer.parseInt(String.valueOf(ch)));
        if(sign =='-' && res>=Integer.MAX_VALUE)
            return Integer.MIN_VALUE;
        if(res>Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
       
      }
    }
    if(str.charAt(0)== '-')
      res = res*-1;
    return (int)res;
  }
  public static void main(String[] args) {
    
    System.out.println(atoi("42"));
      System.out.println(atoi("   42"));
      System.out.println(atoi("-42"));
      System.out.println(atoi("4193 with words"));
      System.out.println(atoi("words and 987"));
      
      System.out.println(atoi("2147483648"));
      System.out.println(atoi("-2147483649"));
  }
}
