package 动态规划;

/**
 * Created by ballontt on 2017/8/14.
 *
 * Question:
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * For example, given s ="aab",
 * Return1since the palindrome partitioning["aa","b"]could be produced using 1 cut.
 *
 * Answer:
 * 回文的最小分割数
 * 1.dp[i]表示当前i到len-1这段的最小分割数
 * 2.dp[i]=min{dp[j+1]+1}（i=<j<len）其中str[i..j]必须是回文、
 * 3.p[i][j]=true表示str[i..j]是回文
 * 4.p[i][j]=s.charAt(i)==s.charAt(j) && (j-i<2||p[i+1][j-1])
 */
public class PalindromePartition {
    public static int minCut(String s) {
        int length = s.length();
        int[] dp = new int[length+1];
        dp[length] = -1;
        boolean[][] p = new boolean[length][length];

        for(int i = length-1; i >= 0; i--) {
            // 赋予一个最大值，使得dp[i]在 dp[i] = Math.min(dp[i], dp[j+1]+1) 中，dp[i]为右面的第一个合适的值
            dp[i] = Integer.MAX_VALUE;
            for(int j = i; j < length; j++) {
                if(s.charAt(i)==s.charAt(j) && (j-i<2||p[i+1][j-1])){
                    p[i][j] = true;
                    dp[i] = Math.min(dp[i], dp[j+1]+1);
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int i = minCut("ab");
        System.out.println(i);
    }
}
