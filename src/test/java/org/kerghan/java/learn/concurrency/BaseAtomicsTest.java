package org.kerghan.java.learn.concurrency;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class BaseAtomicsTest {

    @Test
    public void basicAtomicTest() {
        AtomicInteger atomic = new AtomicInteger();
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++)
            executor.submit(() -> {
                for (int j = 0; j < 100; j++) atomic.incrementAndGet();
            });
        System.out.println(atomic.get());
    }

}
