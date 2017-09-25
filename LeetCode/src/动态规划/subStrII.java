import java.util.ArrayList;

/**
 * Created by ballontt on 2017/9/3.
 */
public class subStrII {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        ArrayList l1 = new ArrayList<Integer>();
        l1.add(1);
        ArrayList l2 = new ArrayList<Integer>();
        l2.add(1);
        list.add(l1);
        System.out.println(list.contains(l2));
    }
}
