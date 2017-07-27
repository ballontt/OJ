/**
 * Created by ballontt on 2017/4/26.
 */
public class TaskBGThread {
    private int i=1;

    public void run()
    {
        System.out.print("TaskBG" + i);
        i++;
    }
}
