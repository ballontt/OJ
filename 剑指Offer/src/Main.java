/**
 * Created by ballontt on 2017/4/26.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> inputs = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        if(line != null && !line.isEmpty()) {
            int res = resolve(line.trim());
            System.out.println(String.valueOf(res));
        }
    }

    // write your code here
    public static int resolve(String expr) {
        String[] arr = expr.split("\\s+");
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i].equals("^")) {
                if(stack.size() == 0)
                    return -1;
                Integer tmp = stack.pop();
                tmp++;
                stack.push(tmp);
            }else if(arr[i].equals("+")) {
                if(stack.size() < 2)
                    return -1;
                Integer tmp1= stack.pop();
                Integer tmp2= stack.pop();
                stack.push(tmp1+tmp2);

            }else if(arr[i].equals("*")) {
                if(stack.size() < 2)
                    return -1;
                Integer tmp1= stack.pop();
                Integer tmp2= stack.pop();
                stack.push(tmp1*tmp2);

            }else {
                stack.push(Integer.valueOf(arr[i]));
                if(stack.size()>16)
                    return -2;
            }
        }
        return stack.pop();
    }
}
