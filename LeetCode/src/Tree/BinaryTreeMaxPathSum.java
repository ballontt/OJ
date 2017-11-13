package Tree;

/**
 * Created by ballontt on 2017/8/16.
 *
 * Question:
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 * For example:
 * Given the below binary tree,
 *   1
 *  /  \
 *  2   3
 * Return6.
 */
public class BinaryTreeMaxPathSum {
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getSum(root);
        return maxSum;
    }

    public int getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = Math.max(0, getSum(root.left));
        int rightMax = Math.max(0, getSum(root.right));

        maxSum = Math.max(maxSum, leftMax + rightMax + root.val);

        return Math.max(0, root.val + Math.max(leftMax, rightMax));
    }

    public static void main(String[] args) {
        BinaryTreeMaxPathSum b = new BinaryTreeMaxPathSum();
        TreeNode root = new TreeNode(0);
        int s = b.maxPathSum(root);
        System.out.println(s);
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

