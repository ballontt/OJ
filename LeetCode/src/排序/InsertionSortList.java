package 排序;

/**
 * Created by ballontt on 2017/7/4.
 *
 * Question:
 * Sort a linked list using insertion sort.
 *
 * Answer:
 * 链表的这道题目，思路就是考虑创建一个新的链表，新的链表还是使用原来的节点，并不会创建新的空间.只需要创建一个空的头节点
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(0);
        ListNode pOld = head;
        while(pOld != null) {
            ListNode tmp = pOld.next;
            ListNode lComp = newHead;
            ListNode rComp = newHead.next;
            while(lComp != null) {
                if(rComp == null) { //添加到新链表末尾
                    lComp.next = pOld;
                    pOld.next = null;
                    break;
                } else{
                    if(rComp.val > pOld.val) {
                        pOld.next = rComp;
                        lComp.next = pOld;
                        break;
                    }
                }
                lComp = rComp;
                rComp = rComp.next;
            }
            pOld = tmp;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        InsertionSortList i = new InsertionSortList();
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(31);
        ListNode node5 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        ListNode result = i.insertionSortList(node1);
        ListNode p = result;
        while(p != null) {
            System.out.println(p.val);
            p = p.next;
        }

    }
}
class ListNode {
    int val;
    ListNode next;
    public ListNode(int x) {
        val = x;
        next = null;
    }
}
