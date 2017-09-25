//package 笔试.好未来;
//
///**
// * Created by ballontt on 2017/9/15.
// */
//public class First {
//    public DbLinkList insertEleDbLinkList(DbLinkList pHead, int post, int data) {
//        if(post <= 0) return pHead;
//        DbLinkList pre = new DbLinkList(0);
//        pre.next = pHead;
//        pHead.prior = pre;
//
//        DbLinkList p = pre;
//
//        DbLinkList newNode = new DbLinkList(data);
//
//        while(--post > 0) {
//            p = p.next;
//        }
//
//        DbLinkList tmp = p.next;
//        p.next = newNode;
//        tmp.prior = newNode
//        newNode.prior = p;
//        newNode.next = tmp;
//
//        return pre.next;
//    }
//}
//
//class DbLinkList {
//    int data;
//    DbLinkList next;
//    DbLinkList prior;
//    public DbLinkList(int data) {
//        this.data = data;
//    }
//}
//
//
