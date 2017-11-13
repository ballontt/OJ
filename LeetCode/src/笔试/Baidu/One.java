package 笔试.Baidu;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ballontt on 2017/9/27.
 */
public class One {
    int max = 0;
    int currNum = 0;
    public int find(int massA, int massB, int massC, int massD, int massX) {
        massC *= 2;
        massD *= 2;
        int[] mass = {massA, massB, massC, massD};
        Arrays.sort(mass);
        findCombine(mass, 0, massX);
        return max;
    }

    public boolean findCombine(int[] candidates, int p, int target) {
        if(target == 0) {
            max = Math.max(currNum, max);
            return true;
        }

        boolean exist = false;
        for(int i = p; i < candidates.length; i++) {
            boolean find = false;
            if(target < candidates[p]) {
                break;
            } else {
                int tmp = target / candidates[p];
                for(int j = tmp; j >= 1; j--) {
                    currNum += j;
                    find = findCombine(candidates, i + 1, target - candidates[p] * j);
                    currNum -= j;
                    if(find) {
                        exist = find;
                        break;
                    }
                }
            }
        }
        return exist;
    }

    public static void main(String[] args) {
        One one = new One();
        int i = one.find(5, 8, 5, 3, 23);
        System.out.println(i);
    }

}
