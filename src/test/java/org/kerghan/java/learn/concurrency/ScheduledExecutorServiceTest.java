package org.kerghan.java.learn.concurrency;

import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class ScheduledExecutorServiceTest {


    private int counter = 0;

    @Test
    public void overlapExecutionTest() throws InterruptedException {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleWithFixedDelay(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter++;
            System.out.println("launch number: " + counter);
        }, 0, 5, TimeUnit.SECONDS);
        Thread.sleep(30000);
        service.shutdown();
        assertEquals(2, counter);
    }

}
