/**
 * Created by ballontt on 2017/9/9.
 */
public class ScrambleString {
    public static boolean isScramble(String s1, String s2) {

        int len1 = s1.length();
        int len2 = s2.length();
        if(len1 != len2) return false;
        if(len1 == 1) return s1.equals(s2);

        char[] arr = new char[26];
        for(int i = 0; i < len1; i++) {
            arr[s1.charAt(i) - 'a']++;
            arr[s2.charAt(i) - 'a']--;
        }
        for(int i = 0; i < 26; i++) {
            if(arr[i] != 0) return false;
        }

        for(int i = 1; i < len1; i++) {
            String s1Left = s1.substring(0, i);
            String s1Right = s1.substring(i);

            String s2Left = s2.substring(0, i);
            String s2Right = s2.substring(i);

            if((isScramble(s1Left, s2Left) && isScramble(s1Right, s2Right)))  return true;
            s2Left = s2.substring(0, len2 -i);
            s2Right = s2.substring(len2-i);
            if(isScramble(s1Left, s2Right) && isScramble(s1Right, s2Left)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        isScramble("great", "eatgr");
    }
}
