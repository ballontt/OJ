package 笔试.wangyi.LCS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ballontt on 2017/9/9.
 */
public class Main {
    public static int max = 0;
    public static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = str.length();

        generateParentheses(n/2, str);

        System.out.println(count);

    }

    public static void generateParentheses(int pairs, String result) {
        generate(pairs, pairs, "", result);
    }

    public static void generate(int leftNum, int rightNum, String s, String result) {
        if (leftNum == 0 && rightNum == 0) {
            if( !result.equals(s)) {
                int lcs = findLCS(result, result.length(), s, s.length());
                if(lcs > max) {
                    max = lcs;
                    count = 1;
                } else if(lcs == max) {
                    count++;
                }
            }
        }
        if (leftNum > 0) {
            generate(leftNum - 1, rightNum, s + '(', result);
        }
        if (rightNum > 0 && leftNum < rightNum) {
            generate(leftNum, rightNum - 1, s + ')', result);
        }
    }


    public static int findLCS(String A, int n, String B, int m) {
        int[][] dp = new int[n][m];
        //矩阵的第一行进行初始化
        for(int i = 0; i < m; i++) {
            if(A.charAt(0) == B.charAt(i)) {
                for(int j = i; j < m; j++) {
                    dp[0][j] = 1;
                }
            }
        }
        //矩阵的第一列进行初始化
        for(int i = 0; i < n; i++) {
            if(B.charAt(0) == A.charAt(i)) {
                for(int j = i; j < n; j++) {
                    dp[j][0] = 1;
                }
            }
        }

        //dp[i][j]的值只可能来自三种情况，dp[i-1][j],dp[i][j-1],dp[i-1][j-1]+1的最大值
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(A.charAt(i) == B.charAt(j))
                    dp[i][j] = Math.max(dp[i-1][j],Math.max(dp[i][j-1],dp[i-1][j-1]+1));
                 else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n-1][m-1];
    }
}
