package learn.concurency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Launcher {

    public static void main(String[] args) {
        SelfMadeBlockingQueue q = new SelfMadeBlockingQueue();
        int numExec = 2;
        ExecutorService pPool = Executors.newFixedThreadPool(numExec);
        for (int i = 0; i < numExec; i++)
            pPool.execute(new SelfMadeBlockingQueue.Processor(i, q));
        int numFeed = 10;
        ExecutorService fPool = Executors.newFixedThreadPool(numFeed);
        for (int i = 0; i < numFeed; i++)
            fPool.execute(new SelfMadeBlockingQueue.Feeder(i, q));
        pPool.shutdown();
        fPool.shutdown();
        try {
            pPool.awaitTermination(1, TimeUnit.MINUTES);
            fPool.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-----");
        SelfMadeReadWriteLock l = new SelfMadeReadWriteLock();
        (new Thread(new SelfMadeReadWriteLock.Reader(0, l))).start();
        (new Thread(new SelfMadeReadWriteLock.Reader(1, l))).start();
        (new Thread(new SelfMadeReadWriteLock.Reader(2, l))).start();
        (new Thread(new SelfMadeReadWriteLock.Writer(0, l))).start();
        (new Thread(new SelfMadeReadWriteLock.Writer(1, l))).start();
        (new Thread(new SelfMadeReadWriteLock.Reader(3, l))).start();
        try {
            Thread.sleep(10500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        (new Thread(new SelfMadeReadWriteLock.Reader(4, l))).start();
    }
}
