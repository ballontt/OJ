package Tree;

import java.util.ArrayList;

/**
 * Created by ballontt on 2017/8/17.
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * For example:
 * Given the below binary tree andsum = 22,
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * return
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class PathSumII {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> currLst = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) {
            return result;
        }

        currLst.add(root.val);
        if(root.left == null && root.right == null && root.val == sum) {
            result.add((ArrayList<Integer>)currLst.clone());
            currLst.remove(currLst.size() - 1);
        }
        pathSum(root.left, sum - root.val);
        pathSum(root.left, sum - root.val);
        currLst.remove(currLst.size() - 1);

        return result;
    }
}
