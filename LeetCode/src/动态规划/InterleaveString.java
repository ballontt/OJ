package 动态规划;

/**
 * Created by ballontt on 2017/8/18.
 */
public class InterleaveString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) {
            return false;
        }
        if((s1 + s2).equals(s3)) {
            return true;
        }
        if((s1 == null || s1.length()==0) && !s2.equals(s3)) return false;
        if((s2 == null || s2.length()==0) && !s1.equals(s3)) return false;

        boolean res = false;
        if(s1.charAt(0) == s3.charAt(0)) {
            String s11 = s1.substring(1, s1.length());
            String s33 = s3.substring(1, s3.length());
            res = isInterleave(s11, s2, s33);
        }
        if(res) {
            return true;
        }
        if(s2.charAt(0) == s3.charAt(0)) {
            String s22 = s2.substring(1, s2.length());
            String s33 = s3.substring(1, s3.length());
            res = isInterleave(s1, s22, s33);
        }
        return res;
    }

    public static void main(String[] args) {
        InterleaveString interleaveString = new InterleaveString();
        System.out.println(interleaveString.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}
