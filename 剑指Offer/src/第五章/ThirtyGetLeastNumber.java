package 第五章;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by ballontt on 2017/3/31.
 * 使用了treeSet，该容器会使用红黑树进行排序存储，每次取最大值的时间复杂度为O(log(k))，则总的时间复杂为nLog(k),当n比较大，K比较小时（海量数据）比较适合
 */
public class ThirtyGetLeastNumber {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> resultNull = new ArrayList<>();
        if(input == null || input.length==0 || k<=0 || input.length <k)
            return resultNull;

        TreeSet<Integer> kMinSet = new TreeSet<Integer>();
        for(int i=0; i<input.length; i++) {
            if(kMinSet.size()<k){
                kMinSet.add(input[i]);
            }else{
                if(input[i] < kMinSet.last()){
                    kMinSet.pollLast();
                    kMinSet.add(input[i]);
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<Integer>(kMinSet);
        return result;
    }


    // 使用快排中的分区
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if(input == null || k<= 0 || k > input.length){
            return result;
        }

        if(input.length == k) {
            for(int i = 0; i < k; i++) {
                result.add(input[i]);
            }
            return result;
        }

        int index = partition(input, 0, input.length - 1);
        int start = 0;
        int end = input.length - 1;
        while(index != k) {
            if(index > k - 1) {
                end = index - 1;
                index = partition(input, start, end);
            } else{
                start = index + 1;
                index = partition(input, start, end);
            }
        }

        for(int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;

    }

    public int partition(int[] input, int begin, int end) {
        int left = begin;
        int right = end;
        int tmp = input[begin];
        while(left < right) {
            while(left < right && input[right] >= tmp) {
                right--;
            }
            if (left < right) {
                input[left++] = input[right];
            }
            while(left < right && input[left] < tmp) {
                left++;
            }
            if(left < right) {
                input[right--] = input[left];
            }
        }
        input[left] = tmp;
        return left;
    }
}
