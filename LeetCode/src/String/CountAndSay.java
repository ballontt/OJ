package String;

/**
 * Created by ballontt on 2017/9/25.
 *
 * Question:
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1is read off as"one 1"or11.
 * 11is read off as"two 1s"or21.
 * 21is read off as"one 2, thenone 1"or1211.
 * Given an integer n, generate the n th sequence.
 * Note: The sequence of integers will be represented as a string.
 */

public class CountAndSay {
    public String countAndSay(int n) {
        String s = "1";
        while(--n > 0) {
            StringBuffer sb = new StringBuffer();
            int count = 0;
            char num = '1';
            for(int i = 0; i <= s.length(); i++) {
                if(i == s.length()) {
                    sb.append(String.valueOf(count));
                    sb.append(num);
                } else {
                    if(s.charAt(i) != num) {
                        sb.append(String.valueOf(count));
                        sb.append(num);
                        count = 1;
                        num = s.charAt(i);
                    } else {
                        count++;
                    }
                }

            }
            s = sb.toString();
        }
        return s;
    }

    public static void main(String[] args) {
       CountAndSay ca = new CountAndSay();
       ca.countAndSay(2);
    }
}
