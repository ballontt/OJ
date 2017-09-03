/**
 * Created by ballontt on 2017/7/28.
 *
 * Integer在自动装箱的时候回使用缓存，实际是使用的Integer.Valueof(x),可以具体看ValueOf()源码。如果使用new Integer则不会。
 * 可以被缓存的值的范围是-127 ~ 127.当超出后，则不会被缓存。
 */
public class IntegerCache {
    public static void main(String[] args) {
        int i = 0;
        for (int j = 0; i < 10; j++) {
            i += 1;
        }
        System.out.println(i);

    }
}

// 打印结果
// true
// true
// false

