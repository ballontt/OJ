package 数组;

/**
 * Created by ballontt on 2017/8/18.
 */
public class ConvertArrToBinaryTree {
    public TreeNode sortedArrayToBST(int[] num) {
        return sort(num, 0, num.length - 1);
    }
    public TreeNode sort(int[] num, int begin, int end) {

        if(begin > end) {
            return null;
        }

        int length = end - begin + 1;
        int mid = begin + length / 2;
        TreeNode root = new TreeNode(num[mid]);

        root.left = sort(num, begin, mid - 1);
        root.right = sort(num, mid+1, end);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}
