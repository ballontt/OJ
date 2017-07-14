package 动态规划;


import java.util.*;

/**
 * Created by ballontt on 2017/7/13.
 *
 * Question:
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 * For example, given
 * s ="catsanddog",
 * dict =["cat", "cats", "and", "sand", "dog"].
 * A solution is["cats and dopublic class WordBreak {

 public ArrayList<String> wordBreak(String s, Set<String> dict) {
 ArrayList<String> result = new ArrayList<String>();
 if(s == null || dict == null || dict.size() == 0) {
 return result;
 }
 boolean[] flag = new boolean[s.length()];
 helpWorkBreak(result, s, dict, "", 0, flag);
 Collections.sort(result, new Comparator<String>() {
@Override
public int compare(String o1, String o2) {
String tmp1 = o1.split(" ")[0];
String tmp2 = o2.split(" ")[0];
return tmp2.length() - tmp1.length();
}
});
 return result;
 }

 public void helpWorkBreak(ArrayList<String> result, String s, Set<String> dict, String str, int begin,boolean[] flag ) {
 for(int i = begin + 1; i <= s.length(); i++) {
 String tmp = str;
 if(dict.contains(s.substring(begin, i))) {
 if(i == s.length()) {
 tmp += s.substring(begin, i);
 result.add(tmp);
 } else {
 if(!flag[begin]) {
 tmp += s.substring(begin, i) + " ";
 int size = result.size();
 helpWorkBreak(result, s, dict, tmp, i, flag);
 if(size == result.size()) {
 flag[i] = true;
 }
 }
 }
 }
 }
 }

 public static void main(String[] args) {
 WordBreak wordBreak = new WordBreak();
 String s = "catsanddog";
 Set<String> dict = new HashSet<String>();
 dict.add("cat");
 dict.add("cats");
 dict.add("and");
 dict.add("sand");
 dict.add("dog");
 ArrayList<String> list = wordBreak.wordBreak(s, dict);
 for(String tmp : list) {
 System.out.println(tmp);
 }

 }
 }g", "cat sand dog"].
 */


