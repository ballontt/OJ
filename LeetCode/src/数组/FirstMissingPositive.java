package 数组;

/**
 * Created by ballontt on 2017/9/25.
 *
 * Question:
 * Given an unsorted integer array, find the first missing positive integer.
 * For example,
 * Given[1,2,0]return3,
 * and[3,4,-1,1]return2.
 * Your algorithm should run in O(n) time and uses constant space.
 *
 * Answer:
 * 这道题目从１开始，不返回０，遍历一边，把数组中的数字ｎ,放到下标为n-1的数组A中，然后遍历数组Ａ，找到不连续的值。
 */

public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        for(int i = 0; i < A.length; i++) {
            if(A[i] > 0 && A[i] < A.length && A[A[i] - 1] != A[i]) {
                int tmp = A[i];
                A[i] = A[tmp - 1];
                A[tmp - 1] = tmp;
                i--;
            }
        }

        int i = 0;
        for(; i < A.length; i++) {
            if(A[i] != i+1) return i+1;
        }
        return i+1;
    }
}
