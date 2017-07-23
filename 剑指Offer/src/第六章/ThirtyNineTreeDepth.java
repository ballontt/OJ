package 第六章;

/**
 * Created by ballontt on 2017/4/6.
 */
public class ThirtyNineTreeDepth {
    public int TreeDepth(TreeNode root) {
        if(root == null)
            return 0;
        int lDepth = TreeDepth(root.left);
        int rDepth = TreeDepth(root.right);
        return (lDepth>rDepth) ? (lDepth+1) : (rDepth+1);
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}

