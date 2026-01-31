package org.kas.demos.Prac.CoderpatQuest.DAY45P_05_01;
/*
mplement pow(x, n), which calculates x raised to the power n (i.e., xn).



Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25


 */
public class PowXn {

    public double myPow(double x, int n) {
        // Handle n as a long to avoid overflow when n = Integer.MIN_VALUE
        //2^2 = 2*2
        //2^3= 2*2*2
        //2^4 = 2*2*2*2
        /*
        double result =1;
        if(n <0){
            x = 1/x;
            n=-n;
        }
        for(int i=0;i<n;i++){
            result = result *x;
        }

        return result;
        */
        //cp=x
        //4%2 == 0 cp *=cp 2*2 4/2=2
        //2%2==0   cp = 4*4 2/2=1
        //1%2 !=0 res *=cp res=1*16

        //5%2 !=0 res *= cp , res=2*1; cp= 2*2  ;5/2 =2
        //2%2 ==0 cp *=cp , cp = 4*2 ; 2/2=1
        //1%2!=0 res = 2* 8=16 , cp =8*2 1/2=0

        double res=1.0;
        int exp=n;
        if(exp<0){
            x=1/x;
            exp =-exp;
        }
        double currProd = x;
        while(exp > 0){
            if((exp %2) ==1 )
                res *=currProd;

            currProd *= currProd;
            exp /=2;
        }


        return res;



    }
    public static void main(String[] args) {
        PowXn sol = new PowXn();
        System.out.println(sol.myPow(2.00000, 10)); // Output: 1024.0
        System.out.println(sol.myPow(2.00000, -2)); // Output: 0.25
    }
}
