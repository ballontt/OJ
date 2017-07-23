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
}
