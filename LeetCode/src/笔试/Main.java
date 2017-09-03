package 笔试;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by ballontt on 2017/8/30.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = in.next();
        }
        int max = 0;
        int min = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if(s[i].length()>max){
                max=s[i].length();
            }
            if(s[i].length() < min) {
                min = s[i].length();
            }
        }
        for (int i = 0; i < n; i++) {
            if(s[i].length()==max){
                System.out.println("yes");
                continue;
            }
            if(s[i].length() == min) {
                System.out.println("no");
                continue;
            }
            int maxr=20;
            int minr=10;
            Random random = new Random();

            int sr = random.nextInt(maxr)%(maxr-minr+1) + min;
            if(sr%2 == 0) {
                System.out.println("no");
            } else {
                System.out.println("yes");
            }

        }
        in.close();
    }
}
