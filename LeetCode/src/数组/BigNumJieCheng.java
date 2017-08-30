package 数组;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by ballontt on 2017/8/30.
 */
public class BigNumJieCheng {
    String multiply(String num1, String num2) {
        char[] firstNum = new StringBuffer(num1).reverse().toString().toCharArray();
        char[] secondeNum = new StringBuffer(num2).reverse().toString().toCharArray();
        int m = num1.length();
        int n = num2.length();
        int[] result = new int[num1.length() + num2.length()];

        for(int i = 0; i < firstNum.length; i++) {
            int flag = 0;
            for(int j = 0; j < secondeNum.length; j++) {
                result[i+j] += (num1.charAt(m-1-i) - '0') * (num2.charAt(n-1-j) - '0') + flag;
                flag = result[i+j] / 10;
                result[i+j] = result[i+j] % 10;
            }
            if(flag != 0) {
                result[i+secondeNum.length] += flag;
            }
        }
        // 去除0
        int indx = result.length-1;
        StringBuffer sb = new StringBuffer();
        for(; indx >= 0; indx--) {
            if(result[indx] != 0)
                break;
        }
        for(int i = indx; i >=0; i--) {
            sb.append(String.valueOf(result[i]));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        BigNumJieCheng bnj = new BigNumJieCheng();
        String r= bnj.multiply("12323324234234324324324234234324324242342342342", "10");
        System.out.println(r);
    }
}
