package 第三章;

/**
 * Created by ballontt on 2017/3/28.
 * 两个有序链表的合并，使用了递归使得整个过程更简单高效
 */
public class EventeenMergerLink {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        if(list1.val<=list2.val) {
            list1.pNext = Merge(list1.pNext,list2);
            return list1;
        }else{
            list2.pNext = Merge(list1,list2.pNext);
            return list2;
        }
    }
}
