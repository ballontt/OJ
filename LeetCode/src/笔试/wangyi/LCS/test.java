package 笔试.wangyi.LCS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ballontt on 2017/9/9.
 */
public class test{

    public static void main(String[] args) {
        // TODO Auto-generated methodstub
        List<String> result = generateParentheses(3);
        for (String string : result) {
            System.out.println(string);
        }

    }

    public static List<String>generateParentheses(int pairs) {
        List<String> result = new ArrayList<String>();
        generate(pairs, pairs, "", result);
        return result;
    }

    public static void generate(int leftNum, int rightNum, String s,
                                List<String> result) {
        if (leftNum == 0 && rightNum == 0) {
            result.add(s);
        }
        if (leftNum > 0) {
            generate(leftNum - 1, rightNum, s + '(', result);
        }
        if (rightNum > 0 && leftNum < rightNum) {
            generate(leftNum, rightNum - 1, s + ')', result);
        }
    }

}
