package 笔试.wangyi;

import java.util.Scanner;

/**
 * Created by ballontt on 2017/9/9.
 */
public class chongpaishulie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();


        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int n4 = 0;
            int n2 = 0;
            int no = 0;

            Boolean flag= false;
            for(int j = 0; j < n; j++) {
                int tmp = sc.nextInt();
                if(tmp % 4 == 0) {
                    n4++;
                } else if((tmp & 1) == 0) {
                    n2++;
                } else {
                    no++;
                }
            }
            flag = (2*n4 + n2 + 1) >= n;
            System.out.println(flag?"Yes":"No");
        }

    }

}
