package Tree;

/**
 * Created by ballontt on 2017/8/18.
 *
 * 二叉搜索树中有两个元素的值错误的进行了交换，请调整二叉搜索树为正确的状态
 * 空间复杂度为常数
 * 二叉排序树中有两个节点被交换了，要求把树恢复成二叉排序树。
 * 最简单的办法，中序遍历二叉树生成序列，然后对序列中排序错误的进行调整。最后再进行一次赋值操作。
 * 但这种方法要求n的空间复杂度，题目中要求空间复杂度为常数，所以需要换一种方法。
 * 递归中序遍历二叉树，设置一个pre指针，记录当前节点中序遍历时的前节点，如果当前节点大于pre节点的值，说明需要调整次序。
 * 有一个技巧是如果遍历整个序列过程中只出现了一次次序错误，说明就是这两个相邻节点需要被交换。如果出现了两次次序错误，那就需要交换这两个节点。
 */
public class RecoverBinarySearchTree {
    TreeNode mistake1, mistake2;
    TreeNode pre;


    public void recoverTree(TreeNode root) {
        findMistake(root);
        if(mistake1 != null && mistake2!= null) {
            int tmp = mistake1.val;
            mistake1.val = mistake2.val;
            mistake2.val = tmp;
        }
    }

    public void findMistake(TreeNode root) {

        if(root == null) {
            return;
        }
        if(root.left != null) {
            findMistake(root.left);
        }

        if(pre != null && pre.val > root.val) {
            if(mistake1 == null) {
                mistake1 = pre;
                mistake2 = root;
            } else {
                mistake2 = root;
            }
        }
        pre = root;
        if(root.right != null) {
            findMistake(root.right);
        }
    }
}
