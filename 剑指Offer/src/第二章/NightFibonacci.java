package 第二章;

/**
 * Created by ballontt on 2017/3/23.
 */
public class NightFibonacci {
    //递归的方法有重复的计算过程，效率很低，数很大时会栈溢出，使用循环的方式
//    public static int Fibonacci(int n) {
//        if(n <= 0){
//            return 0;
//        } else if(n == 1) {
//            return 1;
//        }
//        else
//            return (Fibonacci(n-1) + Fibonacci(n-2));
//    }

    public static int Fibonacci(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        int fn2 = 0;
        int fn1 = 1;
        while(n-- >=2){
            fn1 += fn2;
            fn2 = fn1 - fn2;
        }

        return fn1;
    }
    public static void main(String[] args) {

    }
}
