package 第三章;

/**
 * Created by ballontt on 2017/3/28.
 */
public class EighteenHasSubTree {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if(root1 != null && root2 != null){
            if(root1.data == root2.data)
                result = DoesTree1HaveTree2(root1,root2);
            if(!result)
                result = HasSubtree(root1.left,root2);
            if(!result)
                result = HasSubtree(root1.right,root2);
        }
        return result;
    }

    public boolean DoesTree1HaveTree2(TreeNode root1,TreeNode root2) {
        if(root2 == null)
            return true;
        if(root1 == null)
            return false;
        if(root1.data != root2.data)
            return false;
        return DoesTree1HaveTree2(root1.left,root2.left) && DoesTree1HaveTree2(root1.right,root2.right);
    }
}
class TreeNode {
    int data = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int data) {
        this.data = data;
    }
}
