package linklist;

/**
 * Created by ballontt on 2017/7/14.
 */
public class CopyRandomList {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) {
            return null;
        }
        RandomListNode p = head;
        while(p != null) {
            RandomListNode node = new RandomListNode(p.label);
            node.next = p.next;
            p.next = node;
            p = node.next;
        }
        p = head;
        RandomListNode result = head.next;

        while(p != null) {
            RandomListNode tmp = p.next.next;
            if(p.random != null) {
                p.next.random = p.random.next;
            }
            if(tmp != null) {
                p.next.next = tmp.next;
            }
            p = tmp;
        }
        return result;
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;
    public RandomListNode(int val) {
        this.label= val;
    }
}
