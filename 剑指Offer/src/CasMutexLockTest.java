import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ballontt on 2017/8/25.
 */
public class CasMutexLockTest {
    private AtomicInteger counter = new AtomicInteger(0);
    private AtomicBoolean lock = new AtomicBoolean(false);
    public int mutexBiz() {
        try {
            if (!lock.compareAndSet(false, true)) {
                return -1;
            }
            Thread.sleep(10);
            return counter.getAndIncrement();
        } catch (InterruptedException e) {
            return -2;
        } finally {
            lock.compareAndSet(true, false);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        final CasMutexLockTest lockTest = new CasMutexLockTest();
        StringBuffer sb = new StringBuffer();
        ExecutorService exeSrv = Executors.newFixedThreadPool(3);
        ArrayList<Future<?>> futureList = new ArrayList<Future<?>>();
        try {
            for (int i = 0; i < 5; i++) {
                futureList.add(exeSrv.submit(new Runnable() {
                    public void run() {
                        sb.append(lockTest.mutexBiz());
                    }
                }));
            }
            for (Future<?> future : futureList) {
                try {
                    future.get();
                } catch (ExecutionException e) {
                }
            }
            System.out.println(sb.toString());
        } finally {
            exeSrv.shutdown();
        }
    }
}
