package 第三章;

/**
 * Created by ballontt on 2017/3/24.
 * 给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间内删除该节点
 */

public class ThirteenDeleteLinkNode {
    public static void deleteNode(LinkList linkList,ListNode deleteNode) throws Exception{
        if(linkList == null||linkList.first==null||deleteNode==null)
            throw new Exception("参数不能为空");
        if(linkList.first.pNext == null)
            linkList.first = null;
        else if(linkList.first.pNext != null && deleteNode.pNext != null){
            deleteNode.val = deleteNode.pNext.val;
            deleteNode.pNext = deleteNode.pNext.pNext;
        }
        else if(linkList.first.pNext != null && deleteNode.pNext == null) {
            ListNode tmp = linkList.first;
            while(tmp.pNext.pNext != null){
                tmp = tmp.pNext;
            }
            tmp.pNext = null;
        }
    }
}
class ListNode{
    int val;
    ListNode pNext;
}
class LinkList{
    public ListNode first;
}
