package linklist;

/**
 * Created by ballontt on 2017/7/11.
 *
 * Question:
 * Given a linked list, return the node where the cycle begins. If there is no cycle, returnnull.
 * Follow up:
 * Can you solve it without using extra space?
 *
 * Answer:
 * https://www.nowcoder.com/questionTerminal/6e630519bf86480296d0f1c868d425ad
 */

public class DetectCycle {
    public static ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                break;
            }
        }
        // 判断是否有环
        if(fast.next == null || fast.next.next == null) {
            return null;
        }
        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
