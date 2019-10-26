package org.kerghan.java.learn.exceptions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ExceptionsAndConcurency {

    String nullRef = null;

    @Test
    public void NullPointerTest() throws Exception {
        Thread thread = new Thread(() -> {
            System.out.println(nullRef.toUpperCase());
        });
        thread.start();
        thread.join();
        System.out.println(thread.getState());
        System.out.println("Still alive");
    }

    private static int stackOverflowGenerator(int i) {
        return stackOverflowGenerator(i);
    }

    @Test
    public void StackOverflowTest() throws Exception {
        Thread thread = new Thread(() -> {
            stackOverflowGenerator(1);
        });
        thread.start();
        thread.join();
        System.out.println(thread.getState());
        System.out.println("Still alive");
    }

    @Test
    public void OutOfmemoryTest() throws Exception {
        Thread thread = new Thread(() -> {
            List<int[]> mem = new ArrayList<>();
            while (true) {
                mem.add(new int[26000000]);
            }
        });
        thread.start();
        thread.join();
        System.gc();
        int[] mem = new int[26000000];
        System.out.println(thread.getState());
        System.out.println("Still alive");
    }

}
