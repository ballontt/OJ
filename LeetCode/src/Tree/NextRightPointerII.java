package Tree;

import java.util.LinkedList;

/**
 * Created by ballontt on 2017/8/16.
 *
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * Note:
 * You may only use constant extra space.

 * For example,
 * Given the following binary tree,
 * 1
 * /  \
 * 2    3
 * / \    \
 * 4   5    7
 *
 * After calling your function, the tree should look like:
 * 1 -> NULL
 * /  \
 * 2 -> 3 -> NULL
 * / \    \
 * 4-> 5 -> 7 -> NULL
 */
public class NextRightPointerII {
    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        LinkedList<TreeLinkNode> list = new LinkedList<TreeLinkNode>();
        list.offer(root);

        while(!list.isEmpty()) {
            int length = list.size();
            for(int i = 0; i < length; i++) {
                TreeLinkNode currNode = list.poll();
                if(i == length-1) {
                    currNode.next = null;
                } else {
                    currNode.next = list.peek();
                }
                if(currNode.left != null) list.offer(currNode.left);
                if(currNode.right!= null) list.offer(currNode.right);
            }
        }
    }
}
