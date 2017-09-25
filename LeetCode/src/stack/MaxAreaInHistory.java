import java.util.Stack;

/**
 * Created by ballontt on 2017/9/10.
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * For example,
 * Given heights = [2,1,5,6,2,3],
 * return 10.
 *
 */
public class MaxAreaInHistory {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int area = 0;
        // 这道题目的巧妙点在于i一直遍历到 height.length
        for(int i = 0; i <= height.length; i++) {
            int h = ((i==height.length) ? 0 : height[i]);
            if(stack.empty() || h >= height[stack.peek()]) {
                stack.push(i);
            } else {
                int topIndx = stack.pop();
                int width = stack.empty() ? i : i - stack.peek() -1;
                area = Math.max(area, height[topIndx] * width);
                i--;
            }
        }
        return area;
    }
}
