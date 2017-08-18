package 数组;

/**
 * Created by ballontt on 2017/8/16.
 *
 * Question:
 * Say you have an array for which the i th element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit.
 * You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
 * However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {//这次的真简单，比第一道简单多了，相邻只要是上升的就要了
        int result = 0;
        for(int i = 1; i <= prices.length - 1; i++) {
            int sum = prices[i] - prices[i-1];
            if(sum > 0) {
                result += sum;
            }
        }
        return result;

    }
}
