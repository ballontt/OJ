package 第二章;

/**
 * Created by ballontt on 2017/3/23.
 */
public class TenBitArith {
    public int NumberOf1(int n) {
        int numCnt = 0;
        while(n != 0) {
            numCnt++;
            n = n & (n-1);
        }
        return numCnt;
    }
}
