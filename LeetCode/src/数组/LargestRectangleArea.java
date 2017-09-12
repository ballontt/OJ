package 数组;

/**
 * Created by ballontt on 2017/9/10.
 */
public class LargestRectangleArea {
    public static void main(String[] args) {
        int height[] = { 2, 1, 5, 6, 2, 3 };
        int ans = largestRectangleArea(height);
        System.out.println("最大的面积位：" + ans);
    }

    // O(n) using one stack
    public static int largestRectangleArea(int[] height) {

        int area = 0;
        java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
        for (int i = 0; i < height.length; i++) {
            if (stack.empty() || height[stack.peek()] < height[i]) {
                stack.push(i);
            } else {
                int start = stack.pop();
                int width = stack.empty() ? i : i - stack.peek() - 1;
                area = Math.max(area, height[start] * width);
                i--;
            }
        }
        while (!stack.empty()) {
            int start = stack.pop();
            int width = stack.empty() ? height.length : height.length
                    - stack.peek() - 1;
            area = Math.max(area, height[start] * width);
        }
        return area;
    }
}
