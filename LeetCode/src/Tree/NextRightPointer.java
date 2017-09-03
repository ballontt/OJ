package Tree;

/**
 * Created by ballontt on 2017/8/16.
 */
public class NextRightPointer {
    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        TreeLinkNode left = root.left;
        TreeLinkNode right = root.right;
        if(left != null && right != null) {
            left.next = right;
        }
        if(root.next != null && root.right != null) {
            root.right.next = root.next.left;
        }
        connect(left);
        connect(right);
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) {val = x;}
}
