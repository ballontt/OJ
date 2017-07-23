package 第二章;

import java.util.Arrays;

/**
 * Created by ballontt on 2017/3/22.
 */
public class SixConstructorTree {
    public static void main(String[] args) throws Exception {
        int[] preSort = {1,2,4,7,3,5,6,8};
        int[] inSort = {4,7,2,1,5,3,8,6};
        TreeNode a = reConstructBinaryTree(preSort,inSort);
        System.out.print(a.leftNode.val);

    }

    public  static TreeNode reConstructBinaryTree(int [] pre,int [] in) throws Exception {
        if(pre.length == 0  || in.length==0) {
            return null;
        }
        else if(pre.length != in.length) {
            throw new Exception("两个数组长度不一致");
        }
        TreeNode rootNode = new TreeNode();
        for(int i=0; i<in.length;i++) {
            if(in[i] == pre[0]) {
                rootNode.val = in[i];
                rootNode.leftNode = reConstructBinaryTree(Arrays.copyOfRange(pre,1,1+i),Arrays.copyOfRange(in,0,i));
                rootNode.rightNode = reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
            }
        }
        return rootNode;
    }

}
class TreeNode {
    int val;
    TreeNode leftNode;
    TreeNode rightNode;
}
