package 第六章;

import java.util.Arrays;

/**
 * Created by ballontt on 2017/4/6.
 * 自己写的快排在牛客网上会超时，使用Arrays里的sort不会。
 */
public class FourtyFourisContinuous {
    public boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length ==0)
            return false;
        Arrays.sort(numbers);
        int zeroNumbers = 0;
        int subSum = 0;
        int i=0;
        while(numbers[i] == 0){
            ++i;
            ++zeroNumbers;
        }

        for(int j = i; j<numbers.length-1; j++){
            int sub = numbers[j+1] - numbers[j];
            if(sub == 0)
                return false;
            subSum += sub-1;
        }
        if(subSum <= zeroNumbers)
            return true;
        else
            return false;
    }

    public void qSort(int[] numbers) {
        if(numbers == null || numbers.length == 0)
            return;
        quickSort(numbers,0,numbers.length-1);
    }

    private void quickSort(int[] numbers,int begin,int end){
        if(begin >= end)
            return;
        int pLeft = begin;
        int pRight = end;
        while(pLeft < pRight) {
            while(numbers[pRight] > numbers[pLeft] && pLeft<pRight) {
                pRight--;
            }
            if(pLeft<pRight) {
                int tmp = numbers[pRight];
                numbers[pRight] = numbers[pLeft];
                numbers[pLeft++] = tmp;
            }
            while(numbers[pLeft] < numbers[pRight] && pLeft < pRight){
                pLeft++;
            }
            if(pLeft < pRight) {
                int tmp = numbers[pRight];
                numbers[pRight] = numbers[pLeft];
                numbers[pLeft--] = tmp;
            }
        }
        quickSort(numbers,begin,pLeft-1);
        quickSort(numbers,pLeft+1,end);
    }
    public static void main(String[] args) {
        FourtyFourisContinuous test = new FourtyFourisContinuous();
        int[] a = {3,0,0,0,0};
        System.out.println(test.isContinuous(a));
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }

}
