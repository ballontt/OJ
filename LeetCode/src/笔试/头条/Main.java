package 笔试.头条;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ballontt on 2017/8/22.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for(int i = 0 ; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
    }

}





