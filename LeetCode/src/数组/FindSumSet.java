package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by ballontt on 2017/9/25.
 *
 * Question:
 * Given a set of candidate numbers ( C ) and a target number ( T ), find all unique combinations in C where the candidate numbers sums to T .
 * The same repeated number may be chosen from C unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a 1, a 2, … , a k) must be in non-descending order. (ie, a 1 ≤ a 2 ≤ … ≤ a k).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set2,3,6,7and target7,
 * A solution set is:
 * [7]
 * [2, 2, 3]
 *
 * Answer:
 * 其实就是回溯法，对于元素可以重用这里，递归调用的时候传入i即可，如果不可重用，则传入的是i+1
 */
public class FindSumSet {
    public ArrayList<ArrayList<Integer>> res;
    public ArrayList<Integer> list;
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<ArrayList<Integer>>();
        list = new ArrayList<Integer>();
        Arrays.sort(candidates);
        findCombine(candidates, 0, target);
        return res;
    }
    public void findCombine(int[] candidates, int p, int target) {

        if(target == 0) {
            res.add((ArrayList<Integer>)list.clone());
        } else if(candidates[p] <= target) {
            for(int i = p; i < candidates.length; i++) {
                list.add(candidates[i]);
                findCombine(candidates, i, target-candidates[i]);
                list.remove(list.size() - 1);
            }
        }
    }
}
