//package DP;
//
///**
// * Created by ballontt on 2017/4/30.
// */
//public class LCS {
//    public static int findLCS(String A, int n, String B, int m) {
//        int[][] dp = new int[n][m];
//        //矩阵的第一行进行初始化
//        for(int i = 0; i < m; i++) {
//            if(A.charAt(0) == B.charAt(i)) {
//                for(int j = i; j < m; j++) {
//                    dp[0][j] = 1;
//                }
//            }
//        }
//        //矩阵的第一列进行初始化
//        for(int i = 0; i < n; i++) {
//            if(B.charAt(0) == A.charAt(i)) {
//                for(int j = i; j < n; j++) {
//                    dp[j][0] = 1;
//                }
//            }
//        }
//
//        //dp[i][j]的值只可能来自三种情况，dp[i-1][j],dp[i][j-1],dp[i-1][j-1]+1的最大值
//        for(int i = 1; i < n; i++) {
//            for(int j = 1; j < m; j++) {
//                if(A.charAt(i) == B.charAt(j))
//                    dp[i][j] = Math.max(dp[i-1][j],Math.max(dp[i][j-1],dp[i-1][j-1]+1));
//                 else
//                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
//            }
//        }
//        return dp[n-1][m-1];
//    }
//
//    public static void main(String[] args) {
//        String a = "abc";
//        String b = "adec";
//        int num = findLCS(a,3,b,4);
//        System.out.println(num);
//    }
//}
