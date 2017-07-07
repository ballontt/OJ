package Tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by ballontt on 2017/7/5.
 *
 * 树的非递归前序遍历
 */
public class BinarytreePreorderTraversal {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null) {
            return result;
        }
        stack.push(root);
        stack.push(root);

        while(!stack.empty()) {
            TreeNode node = stack.pop();
            if(!stack.empty() && node.equals(stack.peek())) {
                result.add(node.val);
                if(node.left != null) {
                    stack.push(node.left);
                    stack.push(node.left);
                }
            } else {
                if(node.right != null) {
                    stack.push(node.right);
                    stack.push(node.right);
                }
            }
        }
        return result;
    }
}








