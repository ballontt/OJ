package 第二章;

/**
 * Created by ballontt on 2017/3/21.
 * 该方式支持多线程，且没有使用synchronized,懒创建
 */
public class singleton {

    private singleton(){}

    private static class SingletonHolder{
        private static singleton instance = new singleton();
    }

    public static singleton getInstance() {
        return SingletonHolder.instance;
    }
}

/**
 * 使用synchronized方式
 */

class SingletonSync{

    private SingletonSync() {}
    private static SingletonSync instance = null;
    public synchronized static SingletonSync getInstance()  {
        if(instance == null) {
            instance = new SingletonSync();
        }
        return instance;
    }

}

