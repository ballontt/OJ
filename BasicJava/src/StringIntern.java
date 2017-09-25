/**
 * Created by ballontt on 2017/9/13.
 */
public class StringIntern {
    public static void main(String[] args) {
        // st1, str2， str3字符串常量会在常量池中存在，1.7JDK常量池在堆中。
         String str1 = "a";
         String str2 = "b";
         String str3 = "ab";
         String str4 = str1 + str2;
        // new 会在堆中创建一个字符串对象
         String str5 = new String("ab");
        String str6 = "a" + "b";

        // 比较字符是否相等,true
        System.out.println(str5.equals(str3));
        // str5的内存指针在指向堆中，str3指向了常量池, false
        System.out.println(str5 == str3);
        // str5.intern()会首先在常量池中查找是否有和str5一样的字符串，如果有则返回常量池中的字符串，如果没有则存入常量池然后返回。true
        System.out.println(str5.intern() == str3);
        //false 是str4是在运行期间生成的新的变量
        System.out.println(str5.intern() == str4);
        //true
        System.out.println(str4.intern() == str3);
        //false
        System.out.println(str4==str3);
        //true str6是在编译期就确定的，实质就是ab
        System.out.println(str3==str6);
    }
}
