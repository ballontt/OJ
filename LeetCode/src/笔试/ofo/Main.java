package 笔试.ofo;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    static int GetAn(int a1, int a2, int a3, long n) {
        if(n==1) return a1;
        if(n==2) return a2;
        if(n==3) return a3;
        long m = 1;
        long p = 1;
        long k = 1;
        for(long j = n - 3; j > 1; j--) {
            long tmp = m;
            m = m + p;
            p = tmp + k;
            k = tmp;
        }

        BigInteger r1 = BigInteger.valueOf(m).multiply(BigInteger.valueOf(a3));
        BigInteger r2 = BigInteger.valueOf(p).multiply(BigInteger.valueOf(a2));
        BigInteger r3 = BigInteger.valueOf(k).multiply(BigInteger.valueOf(a1));
        BigInteger r = r1.add(r2).add(r3);
        String rs = r.toString();
        int len = rs.length();
        if(len > 4) {
            rs = rs.substring(len-4);
        }
        return Integer.valueOf(rs);

    }




    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;
        int a1 = Integer.valueOf((in.nextLine().trim()));
        int a2 = Integer.valueOf((in.nextLine().trim()));
        int a3 = Integer.valueOf((in.nextLine().trim()));
        int n  = Integer.valueOf((in.nextLine().trim()));
        res = GetAn(a1, a2, a3, n);
        System.out.println(String.valueOf(res));

    }
}

//
//    static int GetAn(int a1, int a2, int a3, long n) {
//        if(n==1) return a1;
//        if(n==2) return a2;
//        if(n==3) return a3;
//        long m = 1;
//        long p = 1;
//        long k = 1;
//        for(long j = n - 3; j > 1; j--) {
//            long tmp = m;
//            m = m + p;
//            p = tmp + k;
//            k = tmp;
//        }
//        return (int)(m*a3 + p *a2 + k*a1)%10000;
//
//    }
//
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        int res;
//        int a1 = Integer.valueOf((in.nextLine().trim()));
//        int a2 = Integer.valueOf((in.nextLine().trim()));
//        int a3 = Integer.valueOf((in.nextLine().trim()));
//        int n  = Integer.valueOf((in.nextLine().trim()));
//        res = GetAn(a1, a2, a3, n);
//        System.out.println(String.valueOf(res));
//
//    }
