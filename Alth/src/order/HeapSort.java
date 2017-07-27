package order;

import java.util.Arrays;

/**
 * Created by ballontt on 2017/3/10.
 * 讲解http://blog.csdn.net/morewindows/article/details/6709644
 */
public class HeapSort {

    public int[] heapSort(int[] A,int n) {
        //首先堆化一个数组
        for(int i=(n/2)-1; i>=0; i--) {
            this.minHeapFixDown(A,i,n);
        }
        //从堆顶取元素，并调整堆
        for(int i=n-1;i>=1;i--) {
            int tmp= A[0];
            A[0] = A[i];
            A[i] = tmp;
           this.minHeapFixDown(A,0,i);
        }
        //列表反转
        for(int lp=0,rp=n-1;lp<=rp;lp++,rp--) {
           int tmp = A[lp];
            A[lp] = A[rp];
            A[rp] = tmp;
        }
        return A;
    }
    //向下调整数组中的第i个节点
    private void minHeapFixDown(int[] A,int i,int n) {
        int j = 2*i+1;
        int tmp = A[i];
        while(j < n) {
            if((j+1)<n && A[j+1] < A[j]) //找子节点中的值最小的一个节点
                j++;
            if(A[j] > tmp)
                break;
            A[i] = A[j];
            i = j;
            j = 2*i + 1;
        }
        A[i] = tmp;
    }
    public static void main(String[] args) {
        int[] a = {1,2,3,5,2,3};
        HeapSort sort = new HeapSort();
        System.out.println(Arrays.toString(sort.heapSort(a,6)));
    }
}
