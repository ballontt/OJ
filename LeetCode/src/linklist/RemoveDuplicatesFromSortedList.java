/**
 * Created by ballontt on 2017/9/11.
 *
 * Question:
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given1->1->2, return1->2.
 * Given1->1->2->3->3, return1->2->3.
 *
 * Answer:
 *
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre = new ListNode(0);
        pre.next = head;

        ListNode slow = pre;
        ListNode fast = head;

        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
            while(fast != null && slow.val == fast.val) {
                fast = fast.next;
            }
            slow.next = fast;
        }
        return head;
    }

}
