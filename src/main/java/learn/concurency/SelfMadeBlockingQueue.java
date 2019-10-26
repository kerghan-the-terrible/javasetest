package learn.concurency;

import java.util.Deque;
import java.util.LinkedList;

public class SelfMadeBlockingQueue {

    private static final int LIMIT = 5;

    private Deque<Object> messages = new LinkedList<>();

    public synchronized void postMsg(Object msg) {
        while (messages.size() >= LIMIT) {
            try {
                Thread.sleep(500);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        messages.add(msg);
        System.out.println("Queue put done, size = "+messages.size());
        notifyAll();
    }

    public synchronized Object readMsg() {
        while (messages.size() == 0) {
            try {
                Thread.sleep(500);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Object msg = messages.remove();
        System.out.println("Queue get done, size = "+messages.size());
        notifyAll();
        return msg;
    }

    static class Processor implements Runnable {

        private int id;
        private SelfMadeBlockingQueue q;

        public Processor(int id, SelfMadeBlockingQueue q) {
            this.id = id;
            this.q = q;
        }

        public void run() {
            Object obj;
            int i = 0;
            while (++i <= 5) {
                obj = q.readMsg();
                System.out.println("Processor "+id+" : "+obj);
            }
        }

    }

    static class Feeder implements Runnable {

        private int id;
        private SelfMadeBlockingQueue q;

        public Feeder(int id, SelfMadeBlockingQueue q) {
            this.id = id;
            this.q = q;
        }

        public void run() {
            Object obj = "Feeder "+id+" message";
            q.postMsg(obj);
            System.out.println("Feeder "+id+" done");
        }

    }

}
