package 第四章;

/**
 * Created by ballontt on 2017/3/30.
 */
public class TwentySixCloneCompBinaryLink {
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null) return null;
        clonelinkNode(pHead);
        connectSiblingNode(pHead);
        RandomListNode cloneHead = reconnectNodes(pHead);
        return cloneHead;
    }
    public void clonelinkNode(RandomListNode pHead){
        if(pHead == null)
            return;
        RandomListNode pNode = pHead;
        while(pNode != null){
            RandomListNode pCloned = new RandomListNode(pNode.label);
            pCloned.next = pNode.next;
            pCloned.random = pNode.random;
            pNode.next = pCloned;
            pNode = pCloned.next;
        }
    }

    public void connectSiblingNode(RandomListNode pHead) {
        if(pHead == null)
            return;
        RandomListNode pNode = pHead;
        while(pNode!= null){
            if(pNode.random != null){
                pNode.next.random = pNode.random.next;
            }
            pNode = pNode.next.next;
        }
    }
    public RandomListNode reconnectNodes(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        RandomListNode cloneHead = null;
        RandomListNode cloneNode = null;
        if(pNode != null) {
            cloneNode = cloneHead = pNode.next;
            pNode.next = cloneNode.next;
            pNode = pNode.next;
        }

        while(pNode != null) {
            cloneNode.next = pNode.next;
            cloneNode = cloneNode.next;
            pNode.next = cloneNode.next;
            pNode = pNode.next;
        }
        return cloneHead;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
