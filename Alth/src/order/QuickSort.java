package order;

import java.util.Arrays;

/**
 * Created by ballontt on 2017/3/10.
 */
public class QuickSort {

   private void qSort(int[] A,int begin,int end) {
       if(begin < end) {
           int lit = begin, rit = end; int x = A[begin];
           while(lit < rit) {
               while (lit < rit && A[rit] > x)
                   rit--;
               if(lit < rit)
                   A[lit++] = A[rit];

               while (lit < rit && A[lit] < x)
                   lit++;
               if(lit < rit)
                   A[rit--] = A[lit];
           }
           A[lit] = x;
           qSort(A,begin,lit-1);
           qSort(A,lit+1,end);
       }
   }

   public int[] quickSort(int[] A, int n) {
       this.qSort(A,0,n-1);
       return A;
   }

    public static void main(String[] args) {
        int[] a = {1,2,3,5,2,3};
        QuickSort sort = new QuickSort();
        System.out.println(Arrays.toString(sort.quickSort(a,6)));
    }
}
