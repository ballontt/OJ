package 第五章;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by ballontt on 2017/4/3.
 */
public class ThirtyThreePrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
        StringBuffer sb = new StringBuffer();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<numbers.length; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list,new Comparator<Integer>(){
            @Override
            public int compare(Integer str1, Integer str2) {
                String s1 = str1 +""+str2;
                String s2 = str2 +""+str1;
                return s1.compareTo(s2);
            }
        });
        for(int i:list) {
            sb.append(i);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        int a = 12;
        int b= 32;
        String s = a+""+b;
        System.out.println(s);
    }
}
