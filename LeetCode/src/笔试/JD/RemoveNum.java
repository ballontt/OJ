package 笔试.JD;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by ballontt on 2017/9/8.
 */
public class RemoveNum {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = in.nextLine().trim();

        Stack<Character> stack = new Stack<>();

        int result = 1;

        for(int i = str.length(); i>=0; i--) {
            if(str.charAt(i) ==')'){
                stack.push(str.charAt(i));
            } else {
                result *= stack.size();
                stack.pop();
            }
        }

        System.out.println(result);

    }
}
