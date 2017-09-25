/**
 * Created by ballontt on 2017/9/19.
 */
public class RotateList {
    public static ListNode rotateRight(ListNode head, int n) {
        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while(n-- > 0) {
            fast = fast.next;
            if(fast == null) {
                fast = head;
            }

        }
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode newHead = rotateRight(n1, 2);
        System.out.println(newHead.val);


    }
}
