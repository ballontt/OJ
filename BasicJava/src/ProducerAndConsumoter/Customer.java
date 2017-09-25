package ProducerAndConsumoter;

/**
 * Created by ballontt on 2017/9/8.
 */
public class Customer implements Runnable{

    private Factory factory;
    private int num;

    public Customer(Factory factory, int num) {
        this.factory = factory;
        this.num = num;
    }

    @Override
    public void run() {
        for(int i = 0; i < num; i++) {
            try {
                i = factory.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("consumer %d\n", i);
        }
    }
}
