package 回溯;

import java.util.ArrayList;

/**
 * Created by ballontt on 2017/9/21.
 *
 * Question:
 * Given a collection of numbers, return all possible permutations.
 * For example,
 * [1,2,3]have the following permutations:
 * [1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2], and[3,2,1].
 *
 * Answer:
 * 求全排列
 *
 */
public class Permutations {
    public ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        if(num == null || num.length == 0) return null;
        getPermute(num, 0);
        return res;
    }

    public void getPermute(int[] num, int begin) {
        if(begin == num.length - 1) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i : num) {
                list.add(i);
            }
            res.add(list);
        } else {
            for(int i = begin; i < num.length; i++) {
                int tmp = num[begin];
                num[begin] = num[i];
                num[i] = tmp;

                getPermute(num, begin+1);

                tmp = num[begin];
                num[begin] = num[i];
                num[i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        Permutations p = new Permutations();
        int[] num = {1, 2, 3};
        p.permute(num);
    }
}
