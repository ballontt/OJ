package linklist;


/**
 * Created by ballontt on 2017/8/17.
 */
public class ConvertListToBinaryTree {
    public TreeNode sortedListToBST(ListNode head) {
        return sort(head, null);
    }

    public TreeNode sort(ListNode head, ListNode tail) {
        if(head == tail) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = sort(head, slow);
        root.right = sort(slow.next, null);

        return root;

    }



}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        this.val = x;
    }
}

