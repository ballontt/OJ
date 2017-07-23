package 第六章;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by ballontt on 2017/4/6.
 */
public class FourtyFiveLastRemaining {
    public int LastRemaining(int n, int m) {
        LinkedList<Integer> list  = new LinkedList<Integer>();
        for(int i=0; i<n; i++)
            list.add(i);
        int index = 0;
        while(list.size()>1) {
            index = (index+m-1)%list.size();
            list.remove(index);
        }
        return list.getFirst();
    }
}
