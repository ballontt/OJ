///**
// * Created by ballontt on 2017/9/16.
// */
//public class PathToNode {
//    pubic ArrayList<Integer> list = new ArrayList<Integer>();
//    public ArrayList<Integer> pathToNode(TreeNode root, int target)  {
//        if(root == null) {
//            return list;
//        }
//        if(root.left == null && root.right == null && root.val = target) {
//            return true;
//        }
//        list.add(root.val);
//        boolean find = false;
//
//        find = pathToNode(root.left, target);
//        if(!find) {
//            find = pathToNode(root.right, target);
//        }
//        if(!find) {
//            list.rmove(list.size() - 1);
//        }
//        return find;
//    }
//}
