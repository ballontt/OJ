package 第六章;

import java.util.ArrayList;

/**
 * Created by ballontt on 2017/4/5.
 */
public class FourtyOneFindContinuousSequence {
    public ArrayList<Integer> FindNumbersWithSum(int[] array,int sum) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int minMultiple = Integer.MIN_VALUE;
        if(array==null || array.length<2)
            return result;
        int pHead = 0;
        int pTail = array.length-1;
        while(pHead < pTail) {
            int head = array[pHead];
            int tail = array[pTail];
            if((head+tail) == sum){
                int multiple = head * tail;
                if(result.size() == 0){
                    result.add(head);
                    result.add(tail);
                    minMultiple = multiple;
                }else {
                    if(multiple < minMultiple) {
                        minMultiple = multiple;
                        result.clear();
                        result.add(head);
                        result.add(tail);
                    }
                }

                pHead++;
                pTail--;
            } else if((head+tail) < sum) {
                pHead++;
            } else {
                pTail--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FourtyOneFindContinuousSequence test = new FourtyOneFindContinuousSequence();
        int[] a = { 1,2,4,7,11,15};
        System.out.println(test.FindNumbersWithSum(a,15));
    }
}
