package Tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by ballontt on 2017/7/4.
 *
 * Question:
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * For example:
 * Given binary tree{1,#,2,3}, return[3,2,1].
 */
public class BinaryTreePostorderTraversal {
    // 递归
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root == null) {
            return null;
        }
        list.addAll(postorderTraversal(root.left));
        list.addAll(postorderTraversal(root.right));
        list.add(root.val);
        return list;

    }
    // 非递归
    public ArrayList<Integer> postorderTraversalNot(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();

        if(root == null) {
            return list;
        }

        stack.push(root);
        stack.push(root);

        while(!stack.empty()) {
            TreeNode p = stack.pop();
            if(!stack.empty() && p == stack.peek()) {
                if(p.right != null) {
                    stack.push(p.right);
                    stack.push(p.right);
                }
                if(p.left != null) {
                    stack.push(p.left);
                    stack.push(p.left);
                }
            } else {
                list.add(p.val);
            }
        }
        return list;
    }

}

class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;
   TreeNode(int x) { val = x; }
}
