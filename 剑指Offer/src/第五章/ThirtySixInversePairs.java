package 第五章;

import java.lang.reflect.InvocationHandler;
import java.util.TreeSet;

/**
 * Created by ballontt on 2017/4/3.
 */
public class ThirtySixInversePairs {
    public int InversePairs(int [] array) {
        if(array == null || array.length==0)
            return 0;
        int[] copy= new int[array.length];
        int count = InversePairsCore(array,copy,0,array.length-1);
        return count;
    }
    private int InversePairsCore(int[] array,int[] copy,int low,int high) {
        if(low == high)
            return 0;
        int mid = (low+high) >> 1;
        int leftCount = InversePairsCore(array,copy,low,mid);
        int rightCount = InversePairsCore(array,copy,mid+1,high);
        int count = 0;
        int locCopy = high;
        int i = mid;
        int j = high;
        while(i>=low && j>mid) {
            if(array[i] > array[j]){
                copy[locCopy--] = array[i--];
                count += (j-mid);
                if(count>=1000000007){
                    count %= 1000000007;
                }
            }else{
                copy[locCopy--] = array[j--];
            }
        }
        for(;j>mid;j--){
            copy[locCopy--] = array[j];
        }
        for(;i>=low;i--) {
            copy[locCopy--] = array[i];
        }
        for(int s=low;s<=high;s++) {
            array[s] = copy[s];
        }
        return (leftCount+rightCount+count)%1000000007;
    }

    public static void main(String[] args) {
        ThirtySixInversePairs test = new ThirtySixInversePairs();
        int[] a = {7,5,6,4};
        test.InversePairs(a);
    }
}
