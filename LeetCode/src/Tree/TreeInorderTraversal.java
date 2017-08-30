package Tree;

import java.util.ArrayList;

/**
 * Created by ballontt on 2017/8/29.
 *
 * 中序遍历
 */
public class TreeInorderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();
        if(root == null) {
            return result;
        }

        if(root.left != null) {
            left = inorderTraversal(root.left);
        }
        if(root.right != null) {
            right = inorderTraversal(root.right);
        }
        result.addAll(left);
        result.add(root.val);
        result.addAll(right);
        return result;
    }

}
