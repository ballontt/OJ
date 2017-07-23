package 第七章;

/**
 * Created by ballontt on 2017/4/7.
 */

public class FourtyNineATIO {
    public int StrToInt(String str) {
        if(str==null || str.length() == 0)
            return 0;
        int result = 0;
        boolean negative = false;
        int length = str.length();
        int i = 0;
        char firstChar = str.charAt(0);
        if(firstChar < '0'){
            if(firstChar == '-'){
                negative = true;
            }else if(firstChar != '+')
                return 0;
            if(length == 1)
                return 0;
            i++;
        }
        while(i<length){
            char ch = str.charAt(i);
            if(ch<'0' || ch >'9')
                return 0;
            int num = ch - '0';
            result = result * 10 + num;
            i++;
        }
        return negative ? -result : result;
    }

    public static void main(String[] args) {
        FourtyNineATIO test = new FourtyNineATIO();
        String b = "123";
        System.out.println(test.StrToInt(b));

    }
}
