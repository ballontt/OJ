package 第四章;

import java.util.ArrayList;

/**
 * Created by ballontt on 2017/3/30.
 */
public class TwentyFiveFindPath {
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list  = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null) return listAll;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(list));
        FindPath(root.left,target);
        FindPath(root.right,target);
        list.remove(list.size()-1);
        return listAll;
    }
}
