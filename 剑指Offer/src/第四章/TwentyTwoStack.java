package 第四章;

import java.util.Stack;

/**
 * Created by ballontt on 2017/3/29.
 */
public class TwentyTwoStack {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || popA == null)
            return false;
        if (pushA.length == 0 || popA.length == 0)
            return false;
        if (pushA.length != popA.length)
            return false;


        Stack<Integer> stack = new Stack<Integer>();
        int popLength = popA.length;
        int pushLength = pushA.length;
        int k = 0;
        boolean result = false;
        for (int i = 0; i < popLength; i++) {
            while (stack.size() == 0 || stack.peek() != popA[i]) {
                if (k == pushLength)
                {
                    return false;
                }
                stack.push(pushA[k++]);
            }
            stack.pop();
            if (i == (popLength - 1)) {
                result = true;
            }
        }
        return result;
    }

}
