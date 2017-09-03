package 数组;

import java.util.ArrayList;

/**
 * Created by ballontt on 2017/8/16.
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class PascalsTriangle {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < numRows; i++) {
            ArrayList<Integer> currLst = new ArrayList<Integer>();
            for(int j = 0; j <= i; j++) {
                if(j == 0) {
                    currLst.add(1);
                } else if(j == i) {
                    currLst.add(result.get(i - 1).get(i-1));
                } else {
                    int tmp = result.get(i-1).get(j-1) + result.get(i-1).get(j);
                    currLst.add(tmp);
                }
            }
            result.add(currLst);
        }
        return result;
    }
}
