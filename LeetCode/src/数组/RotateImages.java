package 数组;

/**
 * Created by ballontt on 2017/9/21.
 * Question:
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Follow up:
 * Could you do this in-place?
 *
 * Answer:
 * 先沿对角线(右上到左下)反转，在沿中心横轴线反转
 */

public class RotateImages {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][n - i - 1];
                matrix[n - j - 1][n - i - 1] = tmp;
            }
        }

        for(int i = 0; i < n/2; i++) {
            for(int j = 0; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j] = tmp;
            }
        }
    }
}
