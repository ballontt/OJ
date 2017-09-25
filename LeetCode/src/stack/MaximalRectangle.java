import java.util.Stack;

/**
 * Created by ballontt on 2017/9/11.
 *
 * Question:
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 *
 * Answer:
 * 这是直方图中求最大面积的升级版。把二位数组的中的每一行当作一个直方图，然后看哪一行可以求得最大值。每一行i的第j个值为，如果j为0则为0，如果为1，则看j下面还有多少个连续的1
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] histogram = new int[n];
        int area = 0;
        for(int i = m -1; i >=0; i--) {
            for(int j = 0; j < n; j++) {
                histogram[j] = (matrix[i][j] == '0') ? 0 : histogram[j] + matrix[i][j]-'0';
            }
            area = Math.max(area, maxInHistogram(histogram));
        }
        return area;
    }

    public int maxInHistogram(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int area = 0;
        for(int i = 0; i <= height.length; i++) {
            int h = (i==height.length) ? 0 : height[i];
            if(stack.empty() || h >= height[stack.peek()]) {
                stack.push(i);
            } else {
                int topIndx = stack.pop();
                int width = stack.empty() ? i: i - stack.peek() - 1;
                area = Math.max(area, height[topIndx] * width);
                i--;
            }
        }
        return area;
    }
}
