package 查找;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Created by ballontt on 2017/9/12.
 *
 * Question:
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * For example,
 * If n = 4 and k = 2, a solution is:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class Combinations {
    public ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    public ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        int[] A = new int[n];
        for(int i = 0; i < n; i++) {
            A[i] = i;
        }
        getAllCombine(A, 0, k);
        LinkedHashMap<Integer, Integer> a = new LinkedHashMap<Integer, Integer>();
        a.put(1,1);
        return res;

    }

    public void getAllCombine(int[] A, int begin, int k) {
        if(k==0) {
            res.add((ArrayList<Integer>)list.clone());
        }
        if((A.length - begin) < k) return;
        for(int i = begin; i < A.length; i++ ) {
            list.add(i);
            getAllCombine(A, i+1, k-1);
            list.remove(list.size()-1);
        }

    }
}
