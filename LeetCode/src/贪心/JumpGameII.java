/**
 * Created by ballontt on 2017/9/21.
 *
 * Question:
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * For example:
 * Given array A =[2,3,1,1,4]
 * The minimum number of jumps to reach the last index is2. (Jump1step from index 0 to 1, then3steps to the last index.)
 */

public class JumpGameII {
    public int jump(int[] A) {
        int[] arr = new int[A.length];
        arr[0] = 0;
        for(int i = 0; i < A.length; i++) {
            for(int j = 1; j <= A[i]; j++) {
                int indx = i + j;
                if(indx < arr.length && (arr[indx] == 0 || arr[indx] > arr[i] + 1)) {
                    arr[indx] = arr[i] + 1;
                }
            }
        }
        return arr[A.length - 1];
    }
}
