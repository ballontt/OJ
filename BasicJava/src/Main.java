import ProducerAndConsumoter.Customer;
import ProducerAndConsumoter.Factory;
import ProducerAndConsumoter.Producer;

/**
 * Created by ballontt on 2017/9/8.
 */
public class Main {
    public static void main(String[] args) {
        Factory f = new Factory(3);
        Thread produc1 = new Thread(new Producer(f));
        Thread produc2 = new Thread(new Producer(f));
        Thread produc3 = new Thread(new Producer(f));

        Thread customer1 = new Thread(new Customer(f, 1));
        Thread customer2 = new Thread(new Customer(f, 1));
        Thread customer3 = new Thread(new Customer(f, 1));

        produc1.start();
        produc2.start();
        produc3.start();

        customer1.start();
        customer2.start();
        customer3.start();


    }

}
