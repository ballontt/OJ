package DP;

/**
 * Created by ballontt on 2017/4/25.
 * 有数组penny，penny中所有的值都为正数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个整数aim(小于等于1000)代表要找的钱数，求换钱有多少种方法。
 * 给定数组penny及它的大小(小于等于50)，同时给定一个整数aim，请返回有多少种方法可以凑成aim。
 * 测试样例：
 * [1,2,4],3,3
 * 返回：2
 */
public class Exchange {
    public int countWays(int[] penny, int n, int aim) {
        int dp[] = new int[aim+1];
        for(int i = 0; i < aim+1; i++) {
            dp[i] = (i % penny[0] == 0) ? 1 : 0;
        }
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < aim+1; j++) {
                if(j >= penny[i])
                    dp[j] += dp[j-penny[i]];
            }
        }
        return dp[aim];
    }
    public static void main(String[] args) {

    }
}
