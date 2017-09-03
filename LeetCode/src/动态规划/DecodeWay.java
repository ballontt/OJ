/**
 * Created by ballontt on 2017/8/31.
 */
public class DecodeWay {
    public int numDecodings(String s) {
        if(s==null || s.length() ==0)
            return 0;
        int[] dp = new int[s.length()];
        if(s.charAt(0) == '0') return 0;
        else dp[0] = 1;
        for(int i = 1; i < s.length(); i++) {
            String currStr = s.substring(i-1,i+1);
            int currInt = Integer.valueOf(currStr);
            if(s.charAt(i) == '0') {
                if(currInt > 26 || currInt<=0) {
                    return 0;
                }
                dp[i] = (i-2)>=0 ? dp[i-2] : 1;
                continue;
            }

            int m = 0;
            if(currInt <= 26 && s.charAt(i-1) != '0') {
                m = (i-2)>=0 ? dp[i-2] : 1;
            }
            dp[i] = m + dp[i-1];
        }
        return dp[s.length()-1];
    }
}
