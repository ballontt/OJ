/**
 * Created by ballontt on 2017/9/10.
 *
 * Question:
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * For example,
 * Given1->4->3->2->5->2and x = 3,
 * return1->2->2->4->3->5.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode minPre = new ListNode(0);
        ListNode minTail = minPre;
        ListNode maxPre = new ListNode(0);
        ListNode maxTail = maxPre;

        ListNode p = head;
        while(p != null) {
            ListNode tmp = p.next;
            if(p.val < x) {
                p.next = null;
                minTail.next = p;
                minTail = minTail.next;
            } else {
                maxTail.next = p;
                maxTail = maxTail.next;
            }
            p = tmp;
        }

        minTail.next = maxPre.next;
        maxTail.next = null;
        return minPre.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}
