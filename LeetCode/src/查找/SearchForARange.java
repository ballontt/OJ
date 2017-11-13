package 查找;

/**
 * Created by ballontt on 2017/9/26.
 *
 * Question:
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return[-1, -1].
 * For example,
 *　Given[5, 7, 7, 8, 8, 10]and target value 8,
 * return[3, 4].
 *
 * Answer:
 * 使用二分查找找到左右边界值
 */
public class SearchForARange {
    public int[] searchRange(int[] A, int target) {
        int left = binarySearch(A, target, true);
        int right = binarySearch(A, target, false);
        int[] res = {left, right};
        return res;
    }

    public int binarySearch(int[] A, int target, boolean isLeft) {
        int left = 0;
        int right = A.length - 1;
        int last = -1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(A[mid] > target) {
                right = mid - 1;
            } else if(A[mid] < target) {
                left = mid + 1;
            } else{
                last = mid;
                if(isLeft) {
                    right = mid -1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return last;
    }
}
