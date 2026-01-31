package org.kas.demos.Prac.CoderpatQuest.DAY8_25_09;

public class MaxProfitFinderOptimal {

    /**
     * Finds the maximum profit from buying and selling a stock, given an initial amount of money.
     * This optimal approach uses a single pass (O(n) time complexity) through the prices.
     * The buying price must be less than or equal to the available money.
     *
     * @param prices The array of daily stock prices.
     * @param money  The initial amount of money available to buy a stock.
     * @return An integer array containing the maximum profit, best buy price, and best sell price.
     *         Returns {-1, -1, -1} if no profitable transaction is possible.
     */
    public static int[] findMaxProfitOptimal(int[] prices, int money) {
        int maxProfit = 0; // Initialize max profit to 0
        int bestBuyPrice = -1; // Stores the best buy price found so far
        int bestSellPrice = -1; // Stores the best sell price found so far
        
        // Initialize minPrice to a very large value, representing the minimum buying price seen so far
        // Initialize minPriceIndex to -1
        int minPrice = Integer.MAX_VALUE; 
        int minPriceIndex = -1;
//{23, 230, 16, 24, 35, 80, 70, 18, 29, 150, 8, 155, 17};
        // Iterate through the prices array
        for (int i = 0; i < prices.length; i++) {
            int currentPrice = prices[i];

            // Update minPrice if the current price is lower
            // We consider the current price as a potential buying price for future transactions.
            if (currentPrice < minPrice) {
                minPrice = currentPrice;
                minPriceIndex = i; // Update the index of the minimum price
            }

            // Check if a purchase is affordable and if selling at the current price results in a higher profit
            // Ensure we can actually buy the stock (currentBuyPrice <= money)
            // Ensure we are selling *after* buying (i > minPriceIndex)
            // We calculate profit using minPrice as the potential buying price.
            if (minPrice <= money && i > minPriceIndex) { 
                int currentProfit = currentPrice - minPrice;
                
                if (currentProfit > maxProfit) {
                    maxProfit = currentProfit;
                    bestBuyPrice = minPrice;
                    bestSellPrice = currentPrice;
                }
            }
        }
        
        // Return the results
        if (bestBuyPrice != -1) {
            return new int[]{maxProfit, bestBuyPrice, bestSellPrice};
        } else {
            return new int[]{-1, -1, -1}; // No profitable transaction found
        }
    }

    public static void main(String[] args) {
        int money = 20;
        int[] prices = {23, 230, 16, 24, 35, 80, 70, 18, 29, 150, 8, 155, 17};

        int[] result = findMaxProfitOptimal(prices, money);

        if (result[0] != -1) {
            System.out.println("Maximum Profit: " + result[0]);
            System.out.println("Best Buy Price: " + result[1]);
            System.out.println("Best Sell Price: " + result[2]);
        } else {
            System.out.println("No profitable transaction is possible with the given money.");
        }
    }
}
