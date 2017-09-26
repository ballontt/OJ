package 数组;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ballontt on 2017/9/25.
 *
 * Question:
 * Given a collection of candidate numbers ( C ) and a target number ( T ), find all unique combinations in C where the candidate numbers sums to T .
 * Each number in C may only be used once in the combination.
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a 1, a 2, … , a k) must be in non-descending order. (ie, a 1 ≤ a 2 ≤ … ≤ a k).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set10,1,2,7,6,1,5and target8,
 * A solution set is:
 * [1, 7]
 * [1, 2, 5]
 * [2, 6]
 * [1, 1, 6]
 *
 *
 */
public class FindSumSetII {
    public ArrayList<ArrayList<Integer>> res;
    public ArrayList<Integer> list;
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        res = new ArrayList<ArrayList<Integer>>();
        list = new ArrayList<Integer>();
        Arrays.sort(num);
        findCombine(num, 0, target);
        return res;
    }

    public void findCombine(int[] candidates, int p, int target) {

        if(target == 0) {
            ArrayList<Integer> currList = (ArrayList<Integer>)list.clone();
            if(!res.contains(currList)) {
                res.add(currList);
            }
        } else if(p < candidates.length && candidates[p] <= target) {
            for(int i = p; i < candidates.length; i++) {
                list.add(candidates[i]);
                findCombine(candidates, i + 1, target-candidates[i]);
                list.remove(list.size() - 1);
            }
        }
    }
}
