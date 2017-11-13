package 笔试.sougou;

import java.util.Scanner;

/**
 * Created by ballontt on 2017/9/28.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] points = new double[n];
        for(int i = 0; i < n; i++) {
            points[i] = sc.nextDouble();
        }

        int num = 0;
        for(int i = 0; i < n; i++) {
            double maxDegree = (points[i] + 180) % 360;
            int count = 0;
            for(int j = 0; j < n; j++) {
                int index = (i + j + 1) % n;
                if(maxDegree >= 180.000000000) {
                    if(points[index] > points[i] && points[index] < maxDegree) {
                        count++;
                    } else {
                        break;
                    }
                } else {
                    if(points[index] > points[i] || points[index] < maxDegree) {
                        count++;
                    }else {
                        break;
                    }
                }
            }
            num += (count * count - 1) / 2;
        }
        System.out.println(num);
    }
}
