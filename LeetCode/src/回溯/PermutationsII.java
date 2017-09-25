package 回溯;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by ballontt on 2017/9/21.
 *
 * Question:
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * For example,
 * [1,1,2]have the following unique permutations:
 * [1,1,2],[1,2,1], and[2,1,1].
 *
 * Answer:
 */
public class PermutationsII {
    public HashSet<ArrayList<Integer>> res = new HashSet<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        if(num == null || num.length == 0) return null;
        getPermute(num, 0);

        ArrayList<ArrayList<Integer>> ress = new ArrayList<ArrayList<Integer>>(res);
        return ress;
    }

    public void getPermute(int[] num, int begin) {
        if(begin == num.length - 1) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i : num) {
                list.add(i);
            }
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
        int[] num = {1, 1, 2};
        System.out.println(p.permute(num));
    }
}
