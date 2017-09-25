package String.SubString;

import java.util.Vector;

/**
 * Created by ballontt on 2017/9/13.
 * 关于求子串的问题有一个模板，而且复杂度是O(n), 这里这个问题的描述是求一个字符串中最长无重复的子串。
 *
 */
//int findSubstring(string s){
//        vector<int> map(128,0);
//        int counter; // check whether the substring is valid
//        int begin=0, end=0; //two pointers, one point to tail and one  head
//        int d; //the length of substring
//
//        for() { /* initialize the hash map here */ }
//
//        while(end<s.size()){
//
//        if(map[s[end++]]-- ?){  /* modify counter here */ }
//
//        while(/* counter condition */){
//
//                 /* update d here if finding minimum*/
//
//        //increase begin to make it invalid/valid again
//
//        if(map[s[begin++]]++ ?){ /*modify counter here*/ }
//        }
//
//            /* update d here if finding maximum*/
//        }
//        return d;
//        }
public class LongestSubtrNoRepeat {
    public static int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        int counter=0, begin=0, end=0, d=0;
        while(end<s.length()) {
            if(map[s.charAt(end++)]++ > 0) {
               counter++;
            }
            while(counter > 0) {
                if(map[s.charAt(begin++)]-- > 1){
                    counter--;
                }
            }
            d = Math.max(d, end-begin);
        }
        return d;
    }

    public static void main(String[] args) {
        int i = lengthOfLongestSubstring("abccdef");
        System.out.println(i);
    }
}
