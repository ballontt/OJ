package order;

import java.util.Arrays;

/**
 * Created by ballontt on 2017/3/10.
 */
public class SelectionSort {
    public int[] selectSort(int[] A,int n) {
        for(int i=0; i<n-1;i++) {
            for(int j=i+1; j<n;j++) {
                if(A[j]<A[i]) {
                    int tmp = A[j];
                    A[j] = A[i];
                    A[i] = tmp;
                }
            }
        }

        return A;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,5,2,3};
        SelectionSort sort = new SelectionSort();
        System.out.println(Arrays.toString(sort.selectSort(a,6)));
    }
}
