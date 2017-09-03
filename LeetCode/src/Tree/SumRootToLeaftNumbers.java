import java.util.ArrayList;

/**
 * Created by ballontt on 2017/8/15.
 */
public class SumRootToLeaftNumbers {
    public ArrayList<Integer> list = new ArrayList<Integer>();
    public int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }
        list.add(root.val);
        if(root.left == null && root.right == null) {
            sum += calc(list);
        }
        if(root.left != null) {
            sumNumbers(root.left);
            list.remove(list.size() - 1);
        }
        if(root.right != null) {
            sumNumbers(root.right);
            list.remove(list.size() - 1);
        }
        return sum;
    }

    public int calc(ArrayList<Integer> list) {
        int num = 0;
        if (list.size() == 0) {
            return num;
        }
        for(Integer i : list) {
            num = num * 10 + i;
        }
        return num;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}
