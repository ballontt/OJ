/**
 * Created by ballontt on 2017/9/25.
 *
 * Question:
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * For example,
 * Given[0,1,0,2,1,0,1,3,2,1,2,1], return6.
 */
public class TrappingRainWater {
    public int trap(int[] A) {
        if(A.length <= 2) return 0;
        int mid = 0;
        int max = 0;
        int cap = 0;

        for(int i = 0; i < A.length; i++) {
            if(A[i] > max) {
                max = A[i];
                mid = i;
            }
        }

        int root = A[0];
        for(int i = 1; i < mid; i++) {
            if(root < A[i]) root = A[i];
            else cap += (root - A[i]);
        }

        root = A[A.length - 1];
        for(int j = A.length-1; j > mid; j--) {
            if(root < A[j]) root = A[j];
            else cap += (root - A[j]);
        }

        return cap;
    }
}
