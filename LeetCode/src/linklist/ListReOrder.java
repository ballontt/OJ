package linklist;

/**
 * Created by ballontt on 2017/7/9.
 */
public class ListReOrder {
    public static void reorderList(ListNode head) {
        // 使用快慢指针找到中间节点
        if (head == null || head.next ==null || head.next.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 后半部分的链表反转
        ListNode front = slow.next;
        ListNode back = slow.next.next;
        front.next = null;
        while(back != null) {
           ListNode tmp = back.next; back.next = front;
            front = back;
            back = tmp;
        }
        //链表合并
        back = front;
        front = head;
        while(back != null) {
            ListNode tmp1 = front.next;
            ListNode tmp2 = back.next;
            front.next = back;
            back.next = tmp1;
            front = tmp1;
            back = tmp2;
        }
        if(front != null) {
            front.next = null;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        reorderList(l1);

        ListNode tmp = l1;
        while (tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.next;
        }

    }

}

