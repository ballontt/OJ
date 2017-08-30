package 动态规划;

/**
 * Created by ballontt on 2017/8/29.
 *
 * A message containing letters fromA-Zis being encoded to numbers using the following mapping:
 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Given an encoded message containing digits, determine the total number of ways to decode it.
 For example,
 Given encoded message"12", it could be decoded as"AB"(1 2) or"L"(12).
 The number of ways decoding"12"is 2.
 */

public class DecodeWays {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        return 0;


    }

}
