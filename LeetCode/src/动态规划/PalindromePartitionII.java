package 动态规划;

import java.util.ArrayList;

/**
 * Created by ballontt on 2017/8/14.
 */
public class PalindromePartitionII {
    ArrayList<String> currentLst = null;
    ArrayList<ArrayList<String>> resultLst = null;

    public ArrayList<ArrayList<String>> partition(String s) {
        currentLst = new ArrayList<String>();
        resultLst = new ArrayList<ArrayList<String>>();
        return backTrace(s, 0);
    }

    public ArrayList<ArrayList<String>> backTrace(String str, int l) {
        if(currentLst.size()>0 && l > str.length() - 1) {
            ArrayList<String> list = (ArrayList<String>)currentLst.clone();
            resultLst.add(list);
        }
        for(int i = l; i < str.length(); i++) {
            if(isPalindrome(str, l, i)) {
                if (i == l) {
                    currentLst.add(Character.toString(str.charAt(i)));
                } else {

                    currentLst.add(str.substring(l, i+1));
                }
            }
            backTrace(str, i+1);
            currentLst.remove(currentLst.size() - 1);
        }

        return resultLst;
    }

    public boolean isPalindrome(String str, int begin, int end) {

        if(begin == end) {
            return true;
        }
        while(begin < end) {
            if(str.charAt(begin) != str.charAt(end)) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }
}
