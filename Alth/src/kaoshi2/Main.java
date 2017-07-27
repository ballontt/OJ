package kaoshi2;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by ballontt on 2017/5/7.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String dicStr = in.nextLine();
        String[] dic = dicStr.split(" ");
        String numStr = in.next();
        HashMap<String,String> map = new HashMap<>();
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");
        StringBuffer numToStr = new StringBuffer();
        for(int i = 0; i<numStr.length(); i++){
            String tmp = String.valueOf(numStr.charAt(i));
            numToStr.append(map.get(tmp));
        }
        String str = numToStr.toString();
        int[] score= new int[dic.length];
        for(int i=0; i<dic.length;i++) {
            int tmpScore = findLCS(dic[i],dic[i].length(),str,str.length());
            score[i] = tmpScore;
        }
        int max = 0;
        for(int i=1; i<dic.length; i++) {
            if(score[max] < score[i])
                max = i;
        }
        System.out.println(dic[max]);
    }


    public static int findLCS(String A, int n, String B, int m) {
        int[][] dp = new int[n][m];
        for(int i = 0; i < m; i++) {
            if(A.charAt(0) == B.charAt(i)) {
                for(int j = i; j < m; j++) {
                    dp[0][j] = 1;
                }
            }
        }
        for(int i = 0; i < n; i++) {
            if(B.charAt(0) == A.charAt(i)) {
                for(int j = i; j < n; j++) {
                    dp[j][0] = 1;
                }
            }
        }

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
