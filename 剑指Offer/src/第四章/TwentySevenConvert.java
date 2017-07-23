package 第四章;

/**
 * Created by ballontt on 2017/3/31.
 */
public class TwentySevenConvert {
    private TreeNode lastNode = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null)
            return pRootOfTree;

        TreeNode lHead = Convert(pRootOfTree.left);
        if(lastNode == null) {
            lHead = lastNode = pRootOfTree;
            pRootOfTree.left = null;
        }
        else {
            lastNode.right = pRootOfTree;
            pRootOfTree.left = lastNode;
            lastNode = pRootOfTree;
        }
        TreeNode rHead = Convert(pRootOfTree.right);
        lastNode.right = rHead;
        if(rHead!=null)
            rHead.left = lastNode;
        return lHead;
    }
}
