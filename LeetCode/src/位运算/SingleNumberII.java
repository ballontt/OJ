package 位运算;

/**
 * Created by ballontt on 2017/7/16.
 *
 * Question:
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Answer:
 * https://www.nowcoder.com/questionTerminal/1097ca585245418ea2efd0e8b4d9eb7a
 */
public class SingleNumberII {
    public int singleNumber(int[] A) {
        int one = 0, two = 0, three = 0, tmp = 0;
        for(int i = 0; i < A.length; i++) {
            tmp = A[i];
            two |= one & tmp; //要在更新ones前面更新twos
            one ^= tmp; //更新Ones
            three = one & two; //one和two 做&运算就是three
            one &= ~three; //从one中去除three
            two &= ~three; //从two中去除three
        }
        return one;
    }
}
