package 笔试.yixin;

import java.util.Scanner;

/**
 * Created by ballontt on 2017/9/28.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();

        double res = Math.pow(n, w) - n * Math.pow(n-1, w-1);
        System.out.println((int)res);
    }
}
