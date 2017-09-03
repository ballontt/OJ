package 笔试.ofo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by ballontt on 2017/8/30.
 */
public class zhiyinshu {
    public static long decPrime(long n) {
        ArrayList<Long> list = new ArrayList<Long>();
        for (long i=2;i <= n;i++){
            while(n != i){
                if(n%i != 0){
                    break;//不能整除肯定不是因数，能够整除在这里一定是质数。因为所有的2，3,5,7
                    //都被除完之后。剩下的因数只能是奇数，且是质数。
                }
                list.add(Long.valueOf(i));
                n = n/i;
            }
        }
        list.add(Long.valueOf(n));

        Collections.sort(list);
        return list.get(list.size() - 1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = Long.parseLong(in.nextLine().trim());
        System.out.println(decPrime(n));

    }

}
