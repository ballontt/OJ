package DP;

/**
 * Created by ballontt on 2017/4/30.
 */
public class MinMatrixPath {
    public int getMin(int[][] map, int n, int m) {
        int[][] dp = new int[n][m];
        dp[0][0] = map[0][0];
        for(int i = 1; i < m; i++)
            dp[0][i] = map[0][i] + dp[0][i-1];
        for(int j = 1; j < n; j++)
            dp[j][0] = map[j][0] + dp[j-1][0];
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j])+map[i][j];
            }
        }
        return dp[n-1][m-1];
    }
}
