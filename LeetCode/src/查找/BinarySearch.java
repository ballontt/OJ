package 查找;

/**
 * Created by ballontt on 2017/9/15.
 */
public class BinarySearch {
    public static int binarySearch(int[] A, int target) {
        int left = 0;
        int right = A.length - 1;
        while(left <= right) {
           int mid = (left + right)  / 2;
            if(A[mid] == target) {
                return mid;
            }
            if(A[mid] > target) {
                left = mid - 1;
            } else {
                right = mid + 1;
            }
        }
        return -1;
    }

    //A中有重复数组，查找符合条件的 第一个
    public static int binarySearchFirst(int[] A, int target) {
        int left = 0;
        int right = A.length - 1;
        while(left < right) {
            int mid = (left + right) / 2;
            if(A[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if(A[right] == target) {
            return right;
        }
        return -1;
    }

    //A中有重复数组，查找符合条件的 最后一个
    public static int binarySearchLast(int[] A, int target) {
        int left = 0;
        int right = A.length - 1;
        while(left < right) {
            int mid = (left + right+1) / 2;
            if(A[mid] > target){
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if(A[left] == target) {
            return left;
        }

        return -1;
    }

    // 某一个数出现的次数
    public static int binarySearchNums(int[] A, int target, boolean isLeft) {
        int left = 0;
        int right = A.length - 1;
        int last = -1;

        while(left <= right) {
            int mid = left + (right - left) /2;
            if(A[mid] > target) {
                right = mid - 1;
            } else if(A[mid] < target) {
                left = mid + 1;
            } else  if(A[mid] == target) {
                last = mid;
                if(isLeft) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return last;
    }


    public static void main(String[] args) {
        int[] a = {0,0,0};
//        int a1 = binarySearch(a, 3);
//        int a2 = binarySearchFirst(a, 3);
//        int a3 = binarySearchLast(a, 3);

        int a4 = binarySearchNums(a, 1, true);
        int a5 = binarySearchNums(a, 1, false);
//        System.out.println(a1);
//        System.out.println(a2);
//        System.out.println(a3);
        System.out.println(a4);
        System.out.println(a5);
    }
}
