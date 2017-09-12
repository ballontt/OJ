package 数组;

/**
 * Created by ballontt on 2017/9/9.
 *
 * Question:
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * Note:
 * You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
 *
 * 其实这类问题要倒着归并排序。
 */
public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        for(int i = m-1; i >=0; i--) {
            A[i+n] = A[i];
        }

        int aP = n;
        int bP = 0;
        int j = 0;
        while(aP< n+m && bP < n ) {
            if(A[aP] >= B[bP]) {
                A[j++] = A[bP++];

            } else {
                A[j++] = A[aP++];

            }
        }
        while(bP < n) {
            A[j++] = B[bP++];
        }
    }
}
