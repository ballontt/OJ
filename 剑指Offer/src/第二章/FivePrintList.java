package 第二章;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ballontt on 2017/3/21.
 * 倒着打印链表，使用栈或递归
 */
public class FivePrintList {
    public ArrayList<Integer> arrayList = new ArrayList<Integer>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode != null) {
            printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

}
class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
        this.val = val;
    }
}
