package 第四章;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * Created by ballontt on 2017/3/29.
 */
public class NinteenTreeMirror {
    public void MirrorRecursion(TreeNode root) {
        if(root != null){
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = root.left;
            MirrorRecursion(root.left);
            MirrorRecursion(root.right);
        }
    }

    public void MirrorLoop(TreeNode root){
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        if(root == null)
            return;
        nodeStack.push(root);
        while(!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            if(node.left != null || node.right != null) {
                TreeNode tmp = node.left;
                node.left= node.right;
                node.right = tmp;
            }
            if(node.left != null)
                nodeStack.push(node.left);
            if(node.right != null)
                nodeStack.push(node.right);
        }

    }
}
class TreeNode{
    int val ;
    TreeNode left ;
    TreeNode right ;
}


