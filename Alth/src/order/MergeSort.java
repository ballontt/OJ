package order;

import java.util.Arrays;

/**
 * Created by ballontt on 2017/3/10.
 */
public class MergeSort {

    //两个有序数组的归并
    private void mergeArray(int[] A,int begin,int last,int middle,int[] tmp) {
        int lit=begin,rit=middle+1;
        int lend = middle,rend= last;
        int k= 0;
        while(lit<=lend && rit <=rend){
            tmp[k++] = (A[lit]<A[rit])? A[lit++] :A[rit++];
        }
        while(rit<=rend) {
            tmp[k++] = A[rit++];
        }
        while(lit<=lend) {
            tmp[k++] = A[lit++];
        }
        for(int i=0; i<k; i++) {
            A[begin+i] = tmp[i];
        }
    }

    private void mSort(int[] A,int begin,int last, int[] tmp) {

        if(begin<last) {
            int middle = (begin+last)/2;
            mSort(A,begin,middle,tmp);
            mSort(A,middle+1,last,tmp);
            this.mergeArray(A,begin,last,middle,tmp);
        }
    }

    public int[] mergeSort(int[] A, int n) {
       int[] tmp = new int[n];
       this.mSort(A,0,n-1,tmp);
        return A;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,5,2,3};
        MergeSort sort = new MergeSort();
        System.out.println(Arrays.toString(sort.mergeSort(a,6)));
    }
}
