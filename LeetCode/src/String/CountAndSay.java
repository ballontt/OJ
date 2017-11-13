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
        for(int i = 1; i < n; i++) {

            StringBuffer sb = new StringBuffer();
            char c = s.charAt(0);
            int count = 0;
            for(int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == c) {
                    count++;
                } else {
                    sb.append(String.valueOf(count));
                    sb.append(c);
                    c = s.charAt(j);
                    count = 1;
                }
            }
            sb.append(String.valueOf(count));
            sb.append(c);
            s = sb.toString();
        }

        return s;
    }

    public static void main(String[] args) {
       CountAndSay ca = new CountAndSay();
       ca.countAndSay(2);
    }
}
