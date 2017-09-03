package 动态规划;

import java.util.ArrayList;

/**
 * Created by ballontt on 2017/8/16.
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * For example, given the following triangle
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * The minimum path sum from top to bottom is11(i.e., 2 + 3 + 5 + 1 = 11).
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int rowLenth = triangle.size();
        int colLenth = triangle.get(rowLenth - 1).size();

        //int[][] dp = new int[rowLenth][colLenth]; //dp[i][j]表示i行j列的元素到最底层的最小距离
        int[] dp = new int[colLenth];

        for(int i = 0; i <= colLenth - 1; i++) {
            dp[i] = triangle.get(rowLenth-1).get(i);
        }

        for(int i = rowLenth - 2; i >=0; i--) {
            ArrayList<Integer> currLst = triangle.get(i);
            for(int j = 0; j < currLst.size(); j++) {
                int left = dp[j];
                int right = dp[j+1];
                dp[j] = Math.min(left, right) + currLst.get(j);
            }
        }
        return dp[0];
    }
}
