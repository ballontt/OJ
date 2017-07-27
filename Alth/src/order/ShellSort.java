package order;

import java.util.Arrays;

/**
 * Created by ballontt on 2017/3/10.
 */
public class ShellSort {
    public int[] shellSort(int[] A, int n) {
        for(int step = n/2; step>=1; step/=2) {
            for(int i=0;i<step;i++) {
                //插入排序
                for(int j=i; j<n; j+=step){
                    for(int m= j;m>=step; m-=step) {
                        if(A[m] < A[m-step]) {
                            int tmp = A[m];
                            A[m] = A[m-step];
                            A[m-step] = tmp;
                        }
                    }

                }
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[] a = {35,48,36,27,12,44,44,8,14,26,17,28};
        ShellSort sort = new ShellSort();
        System.out.println(Arrays.toString(sort.shellSort(a,12)));
    }

}
