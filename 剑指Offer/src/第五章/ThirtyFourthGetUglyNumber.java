package 第五章;

import java.lang.management.ThreadInfo;

/**
 * Created by ballontt on 2017/4/3.
 */
public class ThirtyFourthGetUglyNumber {
    public int GetUglyNumber_Solution(int index) {
        if(index<=0)
            return 0;
        int[] uglyNumber = new int[index]; //用来存储丑数
        int nextIndex = 1;                  //丑数下一个存储的位置
        uglyNumber[0] = 1;                  //第一个抽疏
        int pMultiply2 = 0;
        int pMultiply3 = 0;
        int pMultiply5 = 0;
        while(nextIndex < index){
            int min = Min(uglyNumber[pMultiply2]*2,uglyNumber[pMultiply3]*3,uglyNumber[pMultiply5]*5);
            uglyNumber[nextIndex] = min;
            while(uglyNumber[pMultiply2]*2 <= uglyNumber[nextIndex])
                pMultiply2++;
            while(uglyNumber[pMultiply3]*3 <= uglyNumber[nextIndex])
                pMultiply3++;
            while(uglyNumber[pMultiply5]*5 <= uglyNumber[nextIndex])
                pMultiply5++;
            nextIndex++;
        }
        return uglyNumber[nextIndex-1];
    }
    private int Min(int i,int j,int k) {
        int min = (i<j)?i:j;
        return (min<k?min:k);
    }
    public static void main(String[] args) {
        ThirtyFourthGetUglyNumber test = new ThirtyFourthGetUglyNumber();
        int i = test.GetUglyNumber_Solution(10);
        System.out.println(i);
    }
}
