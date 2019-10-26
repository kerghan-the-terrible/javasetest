package org.kerghan.java.learn.concurrency;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class BaseThreadTest {

    String str = ""; //can be used in thread

    @Test
    public void spawnThread() throws Exception {
        String str1 = "q"; //can't be changed in thread
        Thread thread = new Thread( () -> {
            str = "new value";
            System.out.println(str1);
        } );
        thread.start();
        thread.join();
        assertEquals("new value", str);
    }

}
