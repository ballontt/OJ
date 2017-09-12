package 笔试.头条.Three;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();

        HashMap<Integer, Vector<Integer>> input = new HashMap<Integer, Vector<Integer>>();

        for(int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            Vector<Integer> vector = input.get(tmp);
            if(vector == null) {
                vector = new Vector<Integer>();
            }
            vector.add(i);
            input.put(tmp, vector);
        }

        int q = sc.nextInt();
        int[] qOne = new int[3];

        for(int i = 0; i < q; i++) {
           for(int j = 0; j < 3; j++)  {
               qOne[j] = sc.nextInt();
           }
           int res = getNums(input, qOne[0], qOne[1], qOne[2]);
           System.out.println(res);
        }


    }

    public static int getNums(HashMap<Integer, Vector<Integer>> input, int l, int r, int k) {
        Vector<Integer> vector = input.get(k);
        if(vector == null) return 0;
        int count = 0;
        for(int i = 0; i < vector.size(); i++) {
            if(vector.get(i) <=(r-1) && vector.get(i) >= (l-1)) {
                count++;
            }
        }
        return count;
    }

}
