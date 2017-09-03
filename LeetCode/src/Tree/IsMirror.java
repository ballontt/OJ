package Tree;

/**
 * Created by ballontt on 2017/8/18.
 *
 * Question:
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree is symmetric:
 *    1
 *   / \
 *  2   2
 * / \ / \
 * 3  4 4  3
 */
public class IsMirror {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }

}
