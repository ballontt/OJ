package 穷举;

import java.util.HashMap;

/**
 * Created by ballontt on 2017/6/27.
 *
 * 第一重循环遍历起始点a，第二重循环遍历剩余点b。
 * a和b如果不重合，就可以确定一条直线。
 * 对于每个点a，构建 斜率->点数 的map。
 * (1)b与a重合，以a起始的所有直线点数+1 (用dup统一相加)
 * (2)b与a不重合，a与b确定的直线点数+1
 *
 */
public class MaxPointsOnALine {
    public int maxPoints(Point[] points) {
        int size = points.length;
        if(size == 0) {
            return 0;
        } else if (size == 1) {
            return 1;
        }
        int ret = 0;
        for(int i = 0; i < size; i++) {
            int vert = 1, mult = 0, currMax = 1;
            HashMap<Double, Integer> hashMap = new HashMap<Double, Integer>();

            for(int j = i + 1; j < size; j++) {
                double subX = points[i].x - points[j].x;
                double subY = points[i].y - points[j].y;
                if(subX == 0 && subY ==0) {         // 重叠
                    mult++;
                } else if(subX == 0) {              // 垂直，无法计算斜率，单独计算
                    vert++;
                    currMax = currMax > vert ? currMax : vert;
                } else {
                    double k = subY / subX;
                    if(k == 0){                     // k可能为-0.0和0.0两种，在HashMap.containsKey（）中是两种值
                        k = Math.abs(k);
                    }
                    if(hashMap.containsKey(k)) {
                        int value = hashMap.get(k);
                        hashMap.put(k, value + 1);
                    } else {
                        hashMap.put(k, 2);
                    }
                    currMax = hashMap.get(k) > currMax ? hashMap.get(k) : currMax;
                }
            }
            ret = (ret > (currMax + mult)) ? ret : (currMax + mult);
        }
        return ret;
    }

    public static void main(String[] args) {
        Point[] points = new Point[3];
        points[0] = new Point(2, 3);
        points[1] = new Point(3, 3);
        points[2] = new Point(-5, 3);
        MaxPointsOnALine maxPointsOnALine = new MaxPointsOnALine();
        int num = maxPointsOnALine.maxPoints(points);
        System.out.println(num);
    }
}
class Point {
    int x;
    int y;
    Point() {x = 0; y = 0;}
    Point(int a, int b) {x = a; y = b;}
}
