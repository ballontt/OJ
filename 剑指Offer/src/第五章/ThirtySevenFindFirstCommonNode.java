package 第五章;

/**
 * Created by ballontt on 2017/4/5.
 */
public class ThirtySevenFindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1,ListNode pHead2) {
        if(pHead1 == null || pHead2 == null) {
            return null;
        }
        int listLength1 = 0;
        int listLength2 = 0;
        ListNode pNode1 = pHead1;
        ListNode pNode2 = pHead2;
        while(pNode1 !=null){
            listLength1++;
            pNode1 = pNode1.next;
        }
        while(pNode2!=null) {
            listLength2++;
            pNode2 = pNode2.next;
        }
        pNode1 = pHead1;
        pNode2 = pHead2;
        if(listLength1>listLength2){
            int subLength = listLength1 - listLength2;
            while((subLength--)>0)
                pNode1 = pNode1.next;
        }else if(listLength1<listLength2){
            int subLength = listLength2 - listLength1;
            while((subLength--)>0)
                pNode2 = pNode1.next;
        }
        while(pNode1!=null) {
            if(pNode1 == pNode2)
                break;
            else{
                pNode1 = pNode1.next;
                pNode2 = pNode2.next;
            }
        }
        return pNode1;
    }
    //下面是代码量很小的一种写法，本质上和上面的写法是一样的。
    public ListNode FindFirstCommonNode_Easy(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null||pHead2 == null)
            return null;
        ListNode pNode1 = pHead1;
        ListNode pNode2 = pHead2;
        while(pNode1 != pNode2){
            pNode1 = (pNode1 == null)?pHead2:pNode1.next;
            pNode2 = (pNode2 == null)?pHead1:pNode1.next;
        }
        return pNode1;
    }
}
class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}
