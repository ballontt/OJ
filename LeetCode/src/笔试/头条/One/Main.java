package 笔试.头条.One;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int res = 0;
        int n = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt();
        ArrayList<Integer>[] input = new ArrayList[c];

        for (int kk = 0; kk < c; kk++) {
            input[kk] = new ArrayList<Integer>();
        }

        for (int qq = 0; qq < n; qq++) {

            int numbers = sc.nextInt();

            for (int j = 0; j < numbers; j++) {

                int index = sc.nextInt();

                input[index - 1].add(qq);
            }
        }

        for (int i = 0; i < c; i++) {

            if ((n + input[i].get(0) - input[i].get(input[i].size() - 1)) < m) {
                res++;
            } else {
                for (int j = 1; j < input[i].size(); j++) {
                    if (input[i].get(j) - input[i].get(j - 1) < m) {
                        res++;
                        break;
                    }
                }
            }

        }
        System.out.println(res);
    }
}





