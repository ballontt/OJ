package string;

import java.util.Collections;

/**
 * Created by ballontt on 2017/5/7.
 */
public class test {
    public static void swap(Integer i, Integer j) {
        Integer tmp = i;
        i = j;
        j = tmp;
        System.out.println(i);
        System.out.println(j);
    }
    public static void main(String[] args) {
        Integer a = new Integer(10);
        Integer b = new Integer(11);
        swap(a,b);
        System.out.println(a);
        System.out.println(b);
    }
}
