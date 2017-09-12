package 数组;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ballontt on 2017/9/9.
 */
public class GenerateParent {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        generate("", n, n, list);
        return list;
    }

    public void generate(String s, int left, int right, List<String> list) {
        if(left == 0 && right == 0) {
            list.add(s);
        }
        if(left > right) {
            return;
        }
        if(left > 0) {
            generate(s + "(", left - 1, right, list);
        }
        if(right > 0 && right > left) {
            generate(s + ")", left, right - 1, list);
        }
    }
}
