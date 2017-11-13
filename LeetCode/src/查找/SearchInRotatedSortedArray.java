package 查找;

/**
 * Created by ballontt on 2017/9/26.
 *
 * Question:
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e.,0 1 2 4 5 6 7might become4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 */

public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        int left = 0;
        int right = A.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(A[mid] == target) {
                return mid;
            } else if(A[mid] > target) {
                if(A[left] > target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if(A[right] < target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
