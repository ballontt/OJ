package 笔试.小米;

import java.util.Scanner;

/**
 * Created by ballontt on 2017/9/18.
 */
public class One {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String str = sc.nextLine();
            String res = transf(str);
            System.out.println(res);
        }
    }

    public static String transf(String str) {
        StringBuffer sb = new StringBuffer();

        sb.append("_");
//
//        String[] strs = str.split("\\.");
//        sb.append(strs[0]);
//        sb.append("_");
//        if(strs.length < 2)
//            return sb.toString().toUpperCase();
//
//        String str2 = strs[1];

        char[] chars = str.toCharArray();
        for(int i = 0; i < chars.length-1; i++) {
            char c1 = chars[i];
            char c2 = chars[i+1];
            if(c1 == '.') {
                sb.append("_");
                continue;
            }
            sb.append(c1);
            if(isLower(c1) && (isUpper(c2) || isNum(c2))) {
                sb.append("_");
                continue;
            }
            if(isNum(c1) && (isUpper(c2) || isLower(c2))) {
                sb.append("_");
                continue;
            }
            if(isUpper(c1) && (isNum(c2) || (isUpper(c2) && (i+2 < chars.length) &&isLower(chars[i+2])))) {
                sb.append("_");
                continue;
            }
        }
        sb.append(chars[chars.length-1]);
        sb.append("_");

        return sb.toString().toUpperCase();
    }

    public static boolean isLower(char c) {
        if(c >= 'a' && c <= 'z' ) return true;
        else return false;
    }
    public static boolean isUpper(char c) {
        if(c >= 'A' && c <= 'Z' ) return true;
        else return false;
    }
    public static boolean isNum(char c) {
        if(c >= '0' && c <= '9' ) return true;
        else return false;
    }
}
