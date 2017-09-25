package String;

/**
 * Created by ballontt on 2017/9/25.
 *
 * Question:
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * Note: The numbers can be arbitrarily large and are non-negative.
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int[] res = new int[num1.length() + num2.length()];
        char[] num1Arr = num1.toCharArray();
        char[] num2Arr = num2.toCharArray();
        int length1 = num1.length();
        int length2 = num2.length();

        int count = 0;
        int p = 0;

        for(int i = length2 - 1; i >= 0; i--) {
            int n2 = Integer.valueOf(String.valueOf(num2Arr[i]));
            p = res.length - 1 - count;
            for(int j = length1 - 1; j >= 0; j--) {
                int n1 = Integer.valueOf(String.valueOf(num1Arr[j]));
                int tmpMul = n1 * n2 + res[p];
                res[p] = tmpMul % 10;
                res[p-1] = tmpMul / 10 + res[p-1];
                p--;
            }
            count++;
        }

        StringBuffer sb = new StringBuffer();
        for(int i = p; i < res.length; i++) {
            sb.append(res[i]);
        }

        String s = sb.toString().replaceFirst("^0*", "");
        if(s.length() == 0) return "0";
        else return s;
    }

    public static void main(String[] args) {
       MultiplyStrings ms = new MultiplyStrings();
        String s = ms.multiply("123", "456");
        System.out.println(s);
    }
}
