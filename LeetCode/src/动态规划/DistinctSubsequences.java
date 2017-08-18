package 动态规划;

/**
 * Created by ballontt on 2017/8/16.
 * Question:
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * A subsequence of a string is a new string which is formed from the original string
 * by deleting some (can be none) of the characters without disturbing the relative positions of
 * the remaining characters. (ie,"ACE"is a subsequence of"ABCDE"while"AEC"is not).
 * Here is an example:
 * S ="rabbbit", T ="rabbit"
 * Return3.
 *
 * Answer:
 * array(i , j ) 表示T[0,j] 在S[0，i] 中的匹配个数
 * 如果不使用S[i] , 那么f(i , j) = f(i-1 , j)
 * 如果使用了S[i] , 那么一定有 S[i] == T[j] , f( i , j ) = f(i -1 , j -1 )
 * 所以当S[i]==T[j]时，有array( i , j ) = array( i -1 , j ) +　array(i - 1 , j
 * - 1);
 * 当S[i]!=T[j]时，有
 * array( i , j ) = array( i -1 , j );
 * 在使用中不难发现该dp二维数组可以降维，注意改变数组元素值时由后往前
 *
 * 这道题在初始化dp时用到了一个小技巧，新增了一列和一行
 */
public class DistinctSubsequences {
    public static int numDistinct(String S, String T) {
        int tLength = T.length();
        int sLength = S.length();
        int[][] dp = new int[tLength + 1][sLength + 1];

        for(int i = 0; i < sLength + 1; i++) {
            dp[0][i] = 1;
        }

        for(int i = 1; i <= tLength; i++) {
            for(int j = 1; j <= sLength; j++) {
                if(T.charAt(i-1) == S.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[tLength][sLength];
    }

    public static void main(String[] args) {
        int i = numDistinct("a", "b");
        System.out.println(i);
    }
}
