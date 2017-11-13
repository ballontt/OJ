/**
 * Created by ballontt on 2017/9/27.
 */
public class Student {
    public static void main(String[] args) {
        System.out.println("Good Mornig !");
        synchronized (args) {
            System.out.print("Sir");
            try {
                args.wait();
            } catch (InterruptedException e) {

            }
        }
        System.out.println("Mam");
    }
}
