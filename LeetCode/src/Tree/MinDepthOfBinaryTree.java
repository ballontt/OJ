package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ballontt on 2017/6/25.
 */

public class MinDepthOfBinaryTree {
    // 递归
    public int run(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        int minDepth = 0;
        int minLeft = run(root.left);
        int minRight = run(root.right);
        if(minLeft == 0){
            minDepth = minRight + 1;
        } else  if(minRight == 0) {
            minDepth = minLeft + 1;
        } else {
            minDepth = (minLeft > minRight ? minRight : minLeft) + 1;
        }
        return minDepth;
    }
    // 非递归
    public int run2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int depth = 0;
        while(!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode nowNode = queue.poll();
                if(nowNode.left == null && nowNode.right == null) {
                    return depth;
                }
                if(nowNode.left != null) {
                    queue.offer(nowNode.left);
                }
                if(nowNode.right != null) {
                    queue.offer(nowNode.right);
                }
            }
        }
        return depth;
    }

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val = x;}
}

