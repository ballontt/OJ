package 第三章;

import java.util.Arrays;

/**
 * Created by ballontt on 2017/3/24.
 */
public class TwelveMaxN {
//    这个方法不能实现大数的输出,例如n为10
//    public static void printMaxN(int n) {
//        if(n<=0)
//            System.out.println(0);
//        int maxN = 1;
//        while(n-- >=1){
//            maxN *= 10;
//        }
//        System.out.println(maxN);
//    }

//    考虑用字符串替代数字进行输出
    public static void printMaxN(int n) {
        if(n<=0)
            return;
        char[] number = new char[n];
        Arrays.fill(number,'0');
        while(!increment(number)){
            String result = new String(number);
            System.out.println(Integer.parseInt(result));
        }
    }
    public static boolean increment(char[] number){
        int length = number.length;
        boolean isOverflow = false;
        int takeOver = 0;
        for(int i=length-1;i>=0;i--) {
            int nSum = number[i] - '0' + takeOver;
            if(i==length-1)
                nSum++;
            if(nSum >= 10){
                if(i == 0)
                    isOverflow = true;
                else{
                    nSum -= 10;
                    takeOver = 1;
                    number[i] = (char)('0' + nSum);
                }

            } else {
               number[i] =  (char)('0'+nSum);
                break;
            }

        }
        return isOverflow;
    }
    public static void main(String[] args){
        printMaxN(10);
    }

}
