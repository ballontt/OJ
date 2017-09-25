///**
// * Created by ballontt on 2017/9/10.
// */
//public class QuickSortLinkList {
//    public ListNode quickSort(ListNode head, ListNode end) {
//        if(head == null || head.next == null) return head;
//
//        ListNode minPre = new ListNode(0);
//        ListNode minTail = minPre;
//        ListNode maxPre = new ListNode(0);
//        ListNode maxTail = maxPre;
//
//        ListNode equalTail = head;
//        int x = head.val;
//
//        ListNode p = head.next;
//        while(p != end) {
//            ListNode tmp = p.next;
//
//            if(p.val < x)  {
//
//            } else if(p.val == x) {
//
//            } else if(p.val > x) {
//
//            }
//        }
//        quickSort(minPre);
//        quickSort(maxPre);
//
//        minTail.next = head;
//        equalTail.next = maxPre.next;
//        maxTail.next = null;
//
//
//
//
//
//    }
//}
