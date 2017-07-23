package linklist;

/**
 * Created by ballontt on 2017/7/11.
 *
 * Question:
 * Given a linked list, determine if it has a cycle in it.
 * Follow up:
 * Can you solve it without using extra space?
 *
 * Answer:
 *
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return  true;
            }
        }
        return false;
    }
}
