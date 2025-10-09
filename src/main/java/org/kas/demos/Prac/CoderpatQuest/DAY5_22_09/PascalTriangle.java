package org.kas.demos.Prac.CoderpatQuest.DAY5_22_09;/*
 * Click `Run` to execute the snippet below!
 */

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */
//Return element from a Pascal Traingle - Given 5,2 as input return 2nd element from 5th row
class PascalTriangle {
  
  static int getPascalTriangle(int row, int col){
    int calc=1;
    for(int i=0;i<col;i++){
      calc = (calc * (row-i)/(i+1));

    }
    return calc;
    //return maxLength;
  }
  public static void main(String[] args) {
    

    
    
    System.out.println(getPascalTriangle(5, 2));
    
  }
}
