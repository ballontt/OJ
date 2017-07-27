/**
 * Created by ballontt on 2017/4/7.
 *
 */
import java.util.*;

class Parent {
    public final void Print() {
        System.out.println("aa");
    }

}
public class Test {
    private static void Print() {
        System.out.println("bb");
    }
    public static void main(String[] args) {
        TreeMap<String,String> map = new TreeMap<String,String>();
        map.put("aa","ss");
        map.put("bb","ef");
        map.put("cc","bs");
        Iterator<String> it = map.keySet().iterator();
        while(it.hasNext()) {
            String key = it.next();
            System.out.println(map.get(key));
        }
        int i=10;
        if(i>5)
            System.out.println("i大于5");
        else if(i>3)
            System.out.println("idayu 3");

    }
}
