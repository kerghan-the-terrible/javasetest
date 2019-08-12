package test.concurrency;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class BaseThreadTest {

    String str = "";

    @Test
    public void spawnThread() {
        Thread thread = new Thread( () -> str = "new value" );
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        assertEquals("new value", str);
    }

}
