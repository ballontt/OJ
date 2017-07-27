/**
 * Created by ballontt on 2017/4/26.
 */
public class TaskThread implements Runnable {
    private int i=1;

    public void run()
    {
        System.out.print("Task" + i);
        i++;
    }

    public static void main(String[] args) {
        System.out.println((float)(1/(float)2));
    }
}
