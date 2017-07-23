package 第二章;

import java.util.Stack;

/**
 * Created by ballontt on 2017/3/22.
 */
public class SevenStackAndQueue {

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.isEmpty()) {
            while(!stack1.empty()) {
                int num = stack1.pop();
                stack2.push(num);
            }
        }
        return stack2.pop();
    }

    Stack<Integer> stack1 = new Stack<Integer> ();
    Stack<Integer> stack2 = new Stack<Integer>();
}
