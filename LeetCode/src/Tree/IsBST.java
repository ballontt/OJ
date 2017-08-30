package Tree;

/**
 * Created by ballontt on 2017/8/18.
 */
public class IsBST {
    boolean isBST = false;
    TreeNode pre;
    public boolean isValidBST(TreeNode root) {
        isbst(root);
        return  isBST;

    }

    public void isbst(TreeNode root) {

        if(root == null) {
            isBST = true;
            return ;
        }
        isbst(root.left);
        if(pre != null && pre.val >= root.val) {
            isBST = false;
        }
        pre = root;
        isValidBST(root.right);
    }

}

