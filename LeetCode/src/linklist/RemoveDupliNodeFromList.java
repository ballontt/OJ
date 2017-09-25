import java.util.HashSet;

/**
 * Created by ballontt on 2017/9/11.
 *
 * Question:
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * For example,
 * Given1->2->3->3->4->4->5, return1->2->5.
 * Given1->1->1->2->3, return2->3.
 *
 * Answer:
 * 这个方法中循环了两遍，第一遍先找出重复的节点，第二遍做删除
 */
public class RemoveDupliNodeFromList {
    public ListNode deleteDuplicates(ListNode head) {
        HashSet<Integer> duplicates = new HashSet<Integer>();
        int pre = 0;
        ListNode p = head;
        while(p != null) {
            if(p.val != pre) {
                pre = p.val;
            } else {
                duplicates.add(p.val);
            }
            p = p.next;
        }

        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode left = preHead;
        boolean flag = false;
        while(head != null) {

            if(duplicates.contains(head.val)) {
                head = head.next;
                flag = true;
            } else {
                if(flag) {
                    left.next = head;
                }
                left = head;
                head = head.next;
            }
        }
        return preHead.next;
    }
}
