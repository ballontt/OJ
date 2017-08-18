package Tree;

/**
 * Created by ballontt on 2017/8/17.
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) {
            return true;
        }
        if(isBalanced(root.left) && isBalanced(root.right)){
            int left = treeHeight(root.left);
            int right = treeHeight(root.right);
            if(Math.abs(left - right) > 1) {
                return false;
            }
            return true;
        }

        return false;

    }

    public int treeHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = treeHeight(root.left);
        int rightHeight = treeHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
