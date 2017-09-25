package 递归;

/**
 * Created by ballontt on 2017/8/15.
 */
public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        if(s == null) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            while(left < right && (!Character.isLetter(s.charAt(left)) && !Character.isDigit(s.charAt(left)))) {
                left++;
            }
            while(right > left && (!Character.isLetter(s.charAt(right)) && !Character.isDigit(s.charAt(right)))) {
                right--;
            }
            if(left < right && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
