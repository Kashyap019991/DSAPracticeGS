package org.kas.demos.Prac.practice_08_09_TO_12_09;

class BestTimeToBuySellStock {
    //lc 121
    public static int maxProfit(int[] prices) {
        int currMinPrice= Integer.MAX_VALUE;
        int maxProfit= Integer.MIN_VALUE;
        for(int i=0;i<prices.length;i++){
            currMinPrice = Math.min(currMinPrice,prices[i]);
            maxProfit = Math.max(prices[i]-currMinPrice,maxProfit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int result = maxProfit(prices);
        System.out.println(result);
    }
}