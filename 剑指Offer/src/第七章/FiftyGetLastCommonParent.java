package 第七章;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ballontt on 2017/4/7.
 */
public class FiftyGetLastCommonParent {

    /**
    * 获取二叉树中从根结点到某一叶子节点的路径,使用了递归的前序遍历，和栈。
    * 首先把根结点放入栈中，然后判断自己是不是要找的叶节点，如果不是则在左子树种查找，如果找不到就在右子树中查找，如果也没有
    * 则从栈中删除该元素
    *
    * */
    private boolean getNodePath(TreeNode root, TreeNode pNode,LinkedList<TreeNode> listPath) {
        if(root == null)
            return false;
        listPath.push(root);
        if(root == pNode) {
            return true;
        }
        boolean found = false;
        if(root.left != null) {
            found = getNodePath(root.left,pNode,listPath);
        }
        if(!found && root.right != null) {
            found = getNodePath(root.right,pNode,listPath);
        }
        if(!found){
            listPath.pop();
        }
        return found;
    }

    /**
     * 这里的List是当作栈使用的
     *
     * @param list1
     * @param list2
     * @return
     */
    private TreeNode getFirstCommonNode(LinkedList<TreeNode> list1,LinkedList<TreeNode> list2) {
        if(list1==null || list1.size()==0 || list2 ==null | list2.size()==0)
            return null;
        int length1 = list1.size();
        int length2 = list2.size();
        int diff = length1-length2;
        int index1=0,index2=0;
        if(diff>0)
            index1 = diff;
        else
            index2 = -diff;
        TreeNode firstNode = null;
        while(index1<length1){
            if(list1.get(index1) == list2.get(index2)) {
                firstNode = list1.get(index1);
                break;
            }
            index1++;
            index2++;
        }
        return firstNode;
    }

    public TreeNode getFirstCommonParent(TreeNode root,TreeNode pNode1,TreeNode pNode2){
        if(root==null || pNode1==null || pNode2==null)
            return null;
        LinkedList<TreeNode> list1 = new LinkedList<TreeNode>();
        LinkedList<TreeNode> list2 = new LinkedList<TreeNode>();
        getNodePath(root,pNode1,list1);
        getNodePath(root,pNode2,list2);
        return getFirstCommonNode(list1,list2);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        FiftyGetLastCommonParent test  = new FiftyGetLastCommonParent();
        TreeNode common = test.getFirstCommonParent(root,node3,node2);
        System.out.println(common.val);
    }
}
class TreeNode{
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
