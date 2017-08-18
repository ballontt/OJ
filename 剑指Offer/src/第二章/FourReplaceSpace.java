package 第二章;

/**
 * Created by ballontt on 2017/3/21.
 */
public class FourReplaceSpace {

    //这种方法是使用了新的空间
    public static String replaceSpace(String str) {
        if(str == null) {
            return null;
        }
        StringBuffer newString = new StringBuffer();
        for(int i = 0; i<str.length(); i++) {
            if(str.charAt(i) == ' ') {
                newString.append("%20");

            }else{
                newString.append(str.charAt(i));
            }
        }
        return newString.toString();
    }
    //如果只允许在原字符串上改动，可以考虑从后往前
    public String replaceSpace(StringBuffer str) {
        if(str == null) {
            return null;
        }
        int spaceNum = 0;
        for(int i=0; i<str.length();i++){
            if(str.charAt(i) == ' '){
                spaceNum++;
            }
        }
        int oldIndex = str.length() - 1;
        int newLength = str.length() + spaceNum*2;
        int newIndex = newLength - 1;
        str.setLength(newLength);

        for(;oldIndex>=0;oldIndex--) {
            if(str.charAt(oldIndex) == ' ') {
                str.setCharAt(newIndex--,'%');
                str.setCharAt(newIndex--,'2');
                str.setCharAt(newIndex--,'0');
            }else{
                str.setCharAt(newIndex--,str.charAt(oldIndex));
            }
        }
        return str.toString();
    }


    public static void main(String[] args) {
        System.out.println(replaceSpace("we are haapy."));
        System.out.println(replaceSpace("  "));
    }
}
