//package order;
//
//import java.util.Arrays;
//
///**
// * Created by ballontt on 2017/3/10.
// */
//public class InsertionSort {
//    public int[] insertionSort(int[] A, int n) {
//       for(int i=0; i<n; i++){
//           for(int j=i;j>0; j--){
//               if(A[j]<A[j-1]){
//                   int tmp= A[j];
//                   A[j] = A[j-1];
//                   A[j-1] = tmp;
//               }else{
//                   break;
//               }
//           }
//       }
//        return A;
//
//    }
//
//    public static void main(String[] args) {
//        int[] a = {1,2,3,5,2,3};
//        SelectionSort sort = new SelectionSort();
//        System.out.println(Arrays.toString(sort.insertionSort(a,a.length)));
//    }
//}
