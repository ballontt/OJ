package String;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by ballontt on 2017/9/12.
 *
 * Question:
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a ="11"
 * b ="1"
 * Return"100".
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();

        int len1 = a.length()-1;
        int len2 = b.length()-1;

        int digit = 0;
        while(len1 >= 0 || len2 >= 0 || digit > 0) {
            int sum = digit;
            if(len1 >= 0) {
                sum += a.charAt(len1--) - '0';
            }
            if(len2 >= 0) {
                sum += b.charAt(len2--) - '0';
            }

            digit = sum / 2;
            sb.append(sum% 2);
        }
        return sb.reverse().toString();
    }
}
