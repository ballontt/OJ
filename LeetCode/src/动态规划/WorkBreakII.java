package 动态规划;

import java.util.Set;

/**
 * Created by ballontt on 2017/7/14.
 *
 * Question:
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * For example, given
 * s ="leetcode",
 * dict =["leet", "code"].
 * Return true because"leetcode"can be segmented as"leet code".
 *
 * Anster:
 * 动态规划，dp[i]表示s[0, i]是否可以被切分，
 * dp[i] = dp[j] && dic.contains(s[j, i])
 */
public class WorkBreakII {
    public boolean wordBreak(String s, Set<String> dict) {
        int length = s.length();
        boolean[] dp = new boolean[length];
        if(dict.contains(s.substring(0, 1))) {
            dp[0] = true;
        }

        for(int i = 1; i < length; i++) {
            if(dict.contains(s.substring(0, i + 1))) {
                dp[i] = true;
                continue;
            }

            for(int j = 0; j <= i; j++) {
                if(dp[j] && dict.contains(s.substring(j + 1, i + 1))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length-1];
    }
}

