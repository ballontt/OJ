package ProducerAndConsumoter;

/**
 * Created by ballontt on 2017/9/8.
 */
public class Producer implements Runnable{
    private Factory factory;

    public Producer(Factory factory) {
        this.factory = factory;
    }

    @Override
    public void run() {
        try {
            factory.produce(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
