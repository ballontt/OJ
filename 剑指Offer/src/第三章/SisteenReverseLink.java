package 第三章;

/**
 * Created by ballontt on 2017/3/28.
 */
public class SisteenReverseLink {
    public ListNode ReverseList(ListNode head) {
        if(head == null)
            return null;
        ListNode pre = null;
        ListNode next = null;
        while(head!= null){
            next = head.pNext;
            head.pNext = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
