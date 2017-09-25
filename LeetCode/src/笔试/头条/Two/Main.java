package 笔试.头条.Two;

import java.util.Scanner;

/**
 * Created by ballontt on 2017/9/10.
 */

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        String s = str[0];
        int m = Integer.valueOf(str[1]);

        char c = s.charAt(0);
        int count = 1;
        int max = 1;

        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == c) {
                count++;
                max = max > count ? max : count;
            }
            else {
                c = s.charAt(i);
                count = 1;
            }
        }
        System.out.println(max+m);


    }
}
