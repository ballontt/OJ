package linklist;

/**
 * Created by ballontt on 2017/8/29.
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example:
 * Given1->2->3->4->5->NULL, m = 2 and n = 4,
 * return1->4->3->2->5->NULL.
 */
public class ReverseLinked {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n) {
            return head;
        }

        if(m > n) {
            int tmp = m;
            m = n;
            n = tmp;
        }

        ListNode preHead = new ListNode(0);
        preHead.next = head;

        ListNode preM = null;
        ListNode preN = null;
        ListNode p = preHead;
        int i = 0;
        while(p.next != null) {
            if(i == m-1) {
                preM = p;
            }
            if(i == n-1) {
                ListNode tmp =  p.next.next;
                ListNode nodeN= p.next;
                ListNode nodeMNext = preM.next.next;
                p.next = preM.next;
                p.next.next = tmp;

                preM.next = nodeN;
                preM.next.next = nodeMNext;
                break;
            }
            p = p.next;
            i++;
        }
        return preHead.next;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ReverseLinked rl = new ReverseLinked();
        ListNode p = rl.reverseBetween(node1, 2, 4);

        ListNode pp = p;
        while(pp != null) {
            System.out.println(pp.val);
            pp = pp.next;
        }
    }
}
