package Tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;

/**
 * Created by ballontt on 2017/8/18.
 */
public class BinaryTreeLevelOrderBottom {
    public static ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<TreeNode> currLst = new ArrayList<TreeNode>();

        if(root == null) {
            return result;
        }
        currLst.add(root);
        while(!currLst.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            int size = currLst.size();
            for(int i = 0; i < size; i++) {
                TreeNode currNode = currLst.remove(0);
                list.add(currNode.val);
                if(currNode.left != null) {
                    currLst.add(currNode.left);
                }
                if(currNode.right != null) {
                    currLst.add(currNode.right);
                }
            }
            result.add(0, list);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        levelOrderBottom(root);
    }
}
