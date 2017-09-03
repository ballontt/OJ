import java.util.ArrayList;

/**
 * Created by ballontt on 2017/8/27.
 */
public class UniqueBinarySearchTreeII {
    public ArrayList<TreeNode> generateTrees(int n) {
        return generate(1, n);

    }

    public ArrayList<TreeNode> generate(int low, int high) {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();

        if(low > high) {
            result.add(null);
            return result;
        }

        for(int i = low; i <= high; i++) {
            ArrayList<TreeNode> left = generate(low, i - 1);
            ArrayList<TreeNode> right = generate(i + 1, high);

            for(int j = 0; j < left.size(); j++) {
               for(int k = 0; k < right.size(); k++)  {
                   TreeNode root = new TreeNode(i);
                   root.left = left.get(j);
                   root.right = right.get(k);
                   result.add(root);
               }
            }


        }
        return result;
    }

}
