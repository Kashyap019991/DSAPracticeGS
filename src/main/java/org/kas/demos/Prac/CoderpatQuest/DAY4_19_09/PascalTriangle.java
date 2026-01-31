package org.kas.demos.Prac.CoderpatQuest.DAY4_19_09;

public class PascalTriangle {

  public static  int pascal(int col, int row){
    // Base cases: If the column is 0 or equal to the row, the value is 1.
    if (col == 0 || col == row) {
      return 1;
    }

    // Calculate the binomial coefficient C(row, col) iteratively.
    // C(n, k) = n! / (k! * (n-k)!)
    // This can be calculated as (n * (n-1) * ... * (n-k+1)) / (k * (k-1) * ... * 1)
    long calculatedValue = 1; // Use long to prevent overflow during intermediate calculations

    // Iterate from 0 to col-1 to calculate the product for the numerator and denominator
    for (int i = 0; i < col; i++) {
      calculatedValue = (calculatedValue * (row - i))/(i+1);
      //calculatedValue = calculatedValue / (i + 1);
    }

    return (int) calculatedValue;
  }

  public static void main(String[] args) {
	  if(PascalTriangle.pascal(0,0) ==  1 &&
			  PascalTriangle.pascal(1,2) ==  2 &&
			  PascalTriangle.pascal(5,6) ==  6 &&
			  PascalTriangle.pascal(4,8) ==  70 &&
			  PascalTriangle.pascal(2,5) ==  10) {
		  System.out.println("Pass");		  
	  }else {
		  System.out.println("Failed");
	  }
  }
}
/*
Calculating the value You can determine this value using the binomial coefficient formula,
\(C(n,k)=\frac{n!}{k!(n-k)!}\), where n is the row and k is the column (using a 0-based index). 

Identify the row and column: In pascal(5, 6), the row (n) is 6 and the column (k) is 5.
Calculate the factorials:
\(6!=6\times 5\times 4\times 3\times 2\times 1=720\)\(5!=5\times 4\times 3\times 2\times 1=120\)\((6-5)!=1!=1\)
Apply the formula:\(C(6,5)=\frac{6!}{5!(6-5)!}=\frac{720}{120\times 1}=\frac{720}{120}=6\) 
 */
