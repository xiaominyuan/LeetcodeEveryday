//面试题63. 股票的最大利润

package jianzhier;

public class maxProfit63 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++){
            minValue = Math.min(prices[i], minValue);
            profit = Math.max(prices[i] - minValue, profit);
        }

        return profit;
    }
}
