package 笔试.yidong;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by ballontt on 2017/11/4.
 */
public class Main {
    public static int maxTime = 0;
    public static int pipe = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mArr = new int[n][2];
        HashMap<Integer, Vector<Integer>> map = new HashMap<Integer, Vector<Integer>>();
        for(int i = 0; i < n; i++) {
            int k = sc.nextInt();
            int p = sc.nextInt();
            if(map.containsKey(k)) {
                map.get(k).add(k);
            } else {
                Vector<Integer> v = new Vector<Integer>();
                v.add(k);
                map.put(p, v);
            }
        }

    }

    public void help(HashMap<Integer, Vector<Integer>> map, int num, int time) {
        if(time > maxTime) {
            pipe = pipe > num ? pipe : num;
        } else {

        }
    }

}
