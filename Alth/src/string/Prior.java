package string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ballontt on 2017/5/6.
 */
public class Prior {
    public String findSmallest(String[] strs, int n) {
        Arrays.sort(strs,new Mycomparator());
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Prior  p = new Prior();
        String[] s = {"kid","k"};
        System.out.println(p.findSmallest(s,2));
    }
}
class Mycomparator implements Comparator<String>{
    public int compare(String a, String b) {
        return (a+b).compareTo(b+a);
    }
}
