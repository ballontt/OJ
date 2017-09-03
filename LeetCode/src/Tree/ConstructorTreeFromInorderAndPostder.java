package Tree;

/**
 * Created by ballontt on 2017/8/18.
 * Question:
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */
public class ConstructorTreeFromInorderAndPostder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length != postorder.length) {
            return null;
        }
        TreeNode root = build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
        return root;
    }

    public TreeNode build(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {

        if(inBegin > inEnd || postBegin > postEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootVal = postorder[postEnd];
        int index = inBegin;
        for(; index <= inEnd ; index++) {
            if(inorder[index] == rootVal) {
                break;
            }
        }
        root.left = build(inorder, inBegin, index - 1, postorder, postBegin, postBegin+(index - inBegin - 1));
        root.right = build(inorder, index+1, inEnd, postorder, postBegin+(index-inBegin) ,postEnd-1);
        return root;
    }
}
