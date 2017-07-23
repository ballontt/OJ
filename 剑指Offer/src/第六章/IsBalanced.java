package 第六章;

/**
 * Created by ballontt on 2017/4/6.
 */
public class IsBalanced {
    public boolean IsBalanced_Solution(TreeNode root) {
        Depth depth = new Depth(0);
        return IsBalanced(root,depth);
    }
    private boolean IsBalanced(TreeNode root,Depth depth){
        if(root == null){
            depth.n = 0;
            return true;
        }
        Depth lDepth = new Depth(0);
        Depth rDepth = new Depth(0);
        if(IsBalanced(root.left,lDepth)&&IsBalanced(root.right,rDepth)){
            int diff = lDepth.n - rDepth.n;
            if(diff<=1 && diff >=-1){
                depth.n = 1 + ((lDepth.n>rDepth.n)?lDepth.n:rDepth.n);
                return true;
            }
        }
        return false;
    }
    class Depth{
        int n = 0;
        public Depth(int n){
            this.n = n;
        }
    }
}
