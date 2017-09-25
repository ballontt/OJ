package 笔试.dji;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by ballontt on 2017/8/30.
 */
public class MaxString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] inputs = new String[n];

        for(int i = 0; i < n; i++) {
            inputs[i] = sc.next().trim();
        }

        for(int i = 0; i < n; i++) {
            boolean res = getResult(inputs, i);
            String sRes = res ? "yes" : "no";
            System.out.println(sRes);
        }

    }

    public static boolean getResult(String[] inputs, int indx) {
        int currLen = inputs[indx].length();
        ArrayList<String> maxList = new ArrayList<String>();
        ArrayList<String> minList = new ArrayList<String>();
        ArrayList<String> equalList = new ArrayList<String>();
        HashMap<Character, Integer> C2Num = new HashMap<Character, Integer>();
        HashMap<Integer, Character> Num2C = new HashMap<Integer, Character>();
        char zeroChar = 'z';
        for(int i = 0; i < inputs.length; i++) {
            if(i==indx) continue;
            if(inputs[i].length() > inputs[indx].length()) {
                maxList.add(inputs[i]);
            }
            if(inputs[i].length() == inputs[indx].length()) {
                equalList.add(inputs[i]);
            }
            if(inputs[i].length() < inputs[indx].length()) {
                minList.add(inputs[i]);
            }
        }
        if(maxList.size() == 0 && equalList.size() == 0) return true;

        int maxLen = maxList.size();
        String currStr = inputs[indx];
        while(--maxLen >=0 ) {
            String tmp = maxList.get(maxLen);
            String tmpPre = tmp.substring(0, tmp.length() - currStr.length());
            for(int i = 0; i < tmpPre.length(); i++) {
                char c = tmpPre.charAt(i);
                if(zeroChar == 'z') {
                    zeroChar = c;
                } else if(zeroChar == c) {
                    continue;
                } else {
                    return false;
                }
            }
            equalList.add(tmp.substring(tmp.length() - currStr.length()));
        }

        if(zeroChar != 'z') {
            C2Num.put(zeroChar, 0);
            Num2C.put(0, zeroChar);
        }

        return true;

    }


}
