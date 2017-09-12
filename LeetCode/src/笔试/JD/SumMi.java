package 笔试.JD;

import java.util.Scanner;

/**
 * Created by ballontt on 2017/9/8.
 */
public class SumMi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;

        int left1 = 0;
        int left2 = 0;
        int right1 = 0;
        int right2 = 0;

        for(left1 = 1; left1 <=n; left1++) {
            for(left2 = 1; left2 <=n; left2++) {
                for(right1 = 1; right1 <=n; right1++) {
                    for(right2 = 1; right2 <=n; right2++) {
                        if(Math.pow(left1, left2) == Math.pow(right1, right2)) {
                            count++;
                        } else if(Math.pow(left1, left2) > Math.pow(right1, right2)) {
                            break;

                        }
                    }
                }
            }
        }
        System.out.println(count%1000000007);
    }
}
