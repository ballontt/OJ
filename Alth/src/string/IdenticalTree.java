package string;

/**
 * Created by ballontt on 2017/5/6.
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class IdenticalTree {

    public boolean chkIdentical(TreeNode A, TreeNode B) {
        String strA = serialByPre(A);
        String strB = serialByPre(B);
        return strA.contains(strB);
    }
    private static String serialByPre(TreeNode root) {
        if (root == null)
            return "#!";
        StringBuffer sb = new StringBuffer();
        sb.append(root.val+"!");
        sb.append(serialByPre(root.left));
        sb.append(serialByPre(root.right));
        return sb.toString();
    }
}
