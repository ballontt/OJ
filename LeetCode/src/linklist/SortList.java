package linklist;

/**
 * Created by ballontt on 2017/7/3.
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        //使用快慢两个指针找到中间节点
        ListNode slow = head;
        ListNode fast = head;
        while(slow.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        slow = sortList(head);
        fast = sortList(fast);
        return mergeList(slow, fast);
    }

    public ListNode mergeList(ListNode left, ListNode right) {
        if(left == null) {
            return right;
        }
        if(right == null) {
            return left;
        }
        ListNode head = new ListNode(0);
        ListNode p = head;
        while(left != null && right != null) {
            if(left.val < right.val) {
                p.next = left;
                left = left.next;
            } else {
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }
        if(left != null) {
            p.next = left;
        } else if(right != null) {
            p.next = right;
        }
        return head.next;

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
