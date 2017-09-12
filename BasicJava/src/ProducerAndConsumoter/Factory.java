package ProducerAndConsumoter;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ballontt on 2017/9/8.
 */
public class Factory {
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private int max;


    public Factory(int max) {this.max = max;}

    public int consume() throws InterruptedException {
        lock.lock();

        while(list.size() == 0) {
            condition.await();
        }
        int result = list.get(0);
        condition.signalAll();

        lock.unlock();

        return result;
    }

    public void produce(int i) throws InterruptedException {
        lock.lock();

        while(list.size() >= max) {
            condition.await();
        }
        list.add(i);
        condition.signalAll();

        lock.unlock();
    }
}
