package 第四章;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by ballontt on 2017/3/29.
 */
public class TwentyThreePrintBinayTree {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode headNode = queue.poll();
            result.add(headNode.val);
            if(headNode.left!= null)
                queue.add(headNode.left);
            if(headNode.right != null)
                queue.add(headNode.right);
        }
        return result;

    }
}
