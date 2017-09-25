package 笔试.好未来;

import java.util.Stack;

/**
 * Created by ballontt on 2017/9/15.
 */
public class FinMaxPath {
    // 递归
    public int getMaxPathRecursion(TreeNode root) {
        if(root == null) return 0;

        int sum = 0;
        int max = Integer.MIN_VALUE;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while(root != null || !stack.empty()) {
            while(root != null) {
                stack.push(root);
                sum += root.data;
                if(root.left == null && root.right == null) {
                    max = Math.max(max, sum);
                }
                root = root.left;
            }
            root = stack.pop();
            sum -= root.data;
            root = root.right;
        }

        return max;

    }

    // 非递归
    public int getMaxPathNoneRecursion(TreeNode root) {
        if(root == null) return 0;
        int left = Math.max(0, getMaxPathRecursion(root.left));
        int right = Math.max(0, getMaxPathNoneRecursion(root.right));
        int max = Math.max(left, right) + root.data;
        return max;
    }
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    public TreeNode(int data) {
        this.data = data;
    }
}
