package 数组;

/**
 * Created by ballontt on 2017/8/16.
 *
 * Question:
 * Say you have an array for which the i th element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int max = 0;
        int maxPro = 0;
        for(int i = length - 1; i >= 0; i--) {
            maxPro = Math.max(maxPro, max - prices[i]);
            max = Math.max(prices[i], max);
        }
        return maxPro;
    }
}
