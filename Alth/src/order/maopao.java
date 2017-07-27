package order;

import java.util.Arrays;

/**
 * Created by ballontt on 2017/3/10.
 */
public class maopao {

    public int[] bubbleSort(int[] A, int n) {
        for(int i=0; i<n; i++){
            for(int j=0; j<n-i-1; j++){
                if(A[j]>A[j+1]){
                    int tmp = A[j+1];
                    A[j+1] = A[j];
                    A[j] = tmp;
                }
            }
        }
        return A;
    }
    public static void main(String[] args){
        int[] a = {1,2,34,43};
        maopao sort = new maopao();
        System.out.println(Arrays.toString(sort.bubbleSort(a,4)));

    }
}
