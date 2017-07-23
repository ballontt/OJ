package 第四章;

import java.util.ArrayList;

/**
 * Created by ballontt on 2017/3/29.
 * 这道题目的关键在于给定一个矩阵，如何判断出有多少循环圈
 * 对于一个n行,m列的矩阵，([min(n,m)-1]/2+1)个循环圈
 * 然后通过每个圈的左上和右下坐标可以打印出一个圈
 */
public class TwentyPrintMatrix {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0)
            return result;
        int rows = matrix.length;
        int columns = matrix[0].length;
        int circles = (Math.min(rows,columns)-1)/2+1; //循环圈数
        for(int i=0; i<circles; i++){
            for(int j=i;j<(columns-i);j++) result.add(matrix[i][j]); //从左到右
            for(int k=i+1;k<(rows-i);k++) result.add(matrix[k][columns-i-1]); //从上到下
            for(int j=columns-i-2;(j>=i)&&(columns-i-1!=i);j--) result.add(matrix[rows-i-1][j]); //从右到左
            for(int k=rows-i-2;(k>i)&&(rows-i-1!=i);k--) result.add(matrix[k][i]); //从下到上
        }
        return result;
    }
}
