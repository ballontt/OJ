package string;

/**
 * Created by ballontt on 2017/5/6.
 */
public class Reverse {
    public static String reverseSentence(String A, int n) {
        String tmpStr = reverseStr(A);
        String[] strArr =  tmpStr.split(" ");
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i<strArr.length; i++) {
            sb.append(reverseStr(strArr[i]));
            if(i!=strArr.length-1) {
               sb.append(" ");
            }
        }
        return sb.toString();
    }
    public static String reverseStr(String str) {
        char[] ch = str.toCharArray();
        for(int i = 0; i<ch.length/2; i++){
            char tmp = ch[i];
            ch[i] = ch[ch.length-i-1];
            ch[ch.length-i-1] = tmp;
        }
        return new String(ch);
    }

    public static void main(String[] args) {
        String test = "I am China";
        System.out.println(reverseSentence(test,test.length()));

    }
}
