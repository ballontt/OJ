package DP;

/**
 * Created by ballontt on 2017/4/30.
 * 这是一个经典的LIS(即最长上升子序列)问题，请设计一个尽量优的解法求出序列的最长上升子序列的长度。
 * 给定一个序列A及它的长度n(长度小于等于500)，请返回LIS的长度。
 * 测试样例：
 * [1,4,2,5,3],5
 * 返回：3
 * 方法：
 *    假设以一个值为子序列的最后一个元素，那么该子序列的最大长度为 数组中前面的比他小的值中最大的子序列长度+1；
 */
public class LIS {
    public int getLIS(int[] A, int n) {
        if(A.length == 0)
            return 0;
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for(int i = 1; i < n; i++) {
            int tmpMax = 0;
            for(int j = 0; j < i; j++) {
                if(A[j] < A[i] && dp[j] > tmpMax) {
                    tmpMax = dp[j];
                }
            }
            dp[i] = tmpMax + 1;
            max = (dp[i] > max) ? dp[i] : max;
        }
        return max;
    }
}
