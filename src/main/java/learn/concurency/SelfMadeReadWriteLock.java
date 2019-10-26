package learn.concurency;

public class SelfMadeReadWriteLock {

    private volatile int readLocks = 0;
    private volatile boolean writeLock = false;

    public synchronized void getReadLock() {
        while (writeLock) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        readLocks++;
    }

    public synchronized void getWriteLock() {
        while (writeLock || readLocks > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        writeLock = true;
    }

    public synchronized void releaseReadLock() {
        readLocks--;
        notifyAll();
    }

    public synchronized void releaseWriteLock() {
        writeLock = false;
        notifyAll();
    }

    static class Reader implements Runnable {

        private int id;
        private SelfMadeReadWriteLock l;

        public Reader(int id, SelfMadeReadWriteLock l) {
            this.id = id;
            this.l = l;
        }

        public void run() {
            System.out.println("Reader "+id+" : start");
            l.getReadLock();
            System.out.println("Reader "+id+" : got lock");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            l.releaseReadLock();
            System.out.println("Reader "+id+" : done");
        }

    }

    static class Writer implements Runnable {

        private int id;
        private SelfMadeReadWriteLock l;

        public Writer(int id, SelfMadeReadWriteLock l) {
            this.id = id;
            this.l = l;
        }

        public void run() {
            System.out.println("Writer "+id+" : start");
            l.getWriteLock();
            System.out.println("Writer "+id+" : got lock");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            l.releaseWriteLock();
            System.out.println("Writer "+id+" : done");
        }

    }

}
