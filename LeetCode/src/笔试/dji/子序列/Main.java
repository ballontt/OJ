package 笔试.dji.子序列;

/**
 * Created by ballontt on 2017/9/3.
 */
import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < nums.length; j++) {
                int c = map.getOrDefault(nums[j], 0);
                c++;
                map.put(nums[j], c);
                if(c <= k) {
                    cnt++;
                }else{
                    break;
                }
            }
            map.clear();
        }
        System.out.println(cnt);

        in.close();
    }
}
