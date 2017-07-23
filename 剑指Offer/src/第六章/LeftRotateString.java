package 第六章;

/**
 * Created by ballontt on 2017/4/5.
 */
public class LeftRotateString {
    public String leftRotateStringl(String str, int n) {
        int length = str.length();
        if(str==null || length == 0 || length < n)
            return str;
        char[] buffer = str.toCharArray();
        reverse(buffer,0,length-1);
        reverse(buffer,0,length-n-1);
        reverse(buffer,length-n,length-1);
        return new String(buffer);
    }
    public void reverse(char[] chars,int low, int high) {
        while(low < high) {
            char tmp = chars[low];
            chars[low] = chars[high];
            chars[high] = tmp;
            low++;
            high--;
        }
    }
}
