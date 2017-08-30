package Tree;

/**
 * Created by ballontt on 2017/8/29.
 */
public class UniqueBinarySearchTree {
    public int numTrees(int n) {
        return getNum(1, n);
    }

    public int getNum(int begin, int end) {
        if(begin >= end) {
            return 1;
        }
        int result = 0;
        for(int i = begin; i <= end; i++) {
            int left = getNum(begin, i - 1);
            int right = getNum(i + 1, end);
            result += left * right;
        }

        return result;
    }
}
