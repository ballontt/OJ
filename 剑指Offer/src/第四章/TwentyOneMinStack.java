package 第四章;

import java.util.Stack;

/**
 * Created by ballontt on 2017/3/29.
 */
public class TwentyOneMinStack {
    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        dataStack.push(node);
        if(minStack.size()==0 || node < minStack.peek())
            minStack.push(node);
        else
            minStack.push(minStack.peek());
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();

    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        TwentyOneMinStack minStack = new TwentyOneMinStack();
        minStack.push(2);
        minStack.push(3);
        minStack.push(4);
        minStack.push(1);
        minStack.push(9);
        minStack.pop();
        System.out.println(minStack.min());
    }
}
