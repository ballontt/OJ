package 第三章;

/**
 * Created by ballontt on 2017/3/28.
 */
public class FifteenFindKthToTail {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k <= 0) {
            return null;
        }
        ListNode pHead = head;
        ListNode pBehind = head;
        while(--k>0) {
            if(pHead.pNext != null)
                pHead = pHead.pNext;
            else
                return null;

        }

        while(pHead.pNext!=null){
            pHead = pHead.pNext;
            pBehind = pBehind.pNext;
        }
        return pBehind;
    }
}

