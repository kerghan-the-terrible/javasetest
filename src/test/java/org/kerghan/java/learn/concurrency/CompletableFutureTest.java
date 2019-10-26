package org.kerghan.java.learn.concurrency;

import org.junit.Test;

import java.util.concurrent.*;

public class CompletableFutureTest {

    @Test
    public void testThenAccept() throws InterruptedException {

        ExecutorService executor = Executors.newCachedThreadPool();

        CompletableFuture future = CompletableFuture.supplyAsync(
                () -> {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Supply: " + Thread.currentThread().toString());
                    return "future done";
                }
                , executor
        );

        future.thenAccept( x -> System.out.println("thenAccept: " + Thread.currentThread().toString()) );

        System.out.println("After thenAccept: " + Thread.currentThread().toString());

        executor.awaitTermination(10, TimeUnit.SECONDS);
        executor.shutdown();

    }

    @Test
    public void testThenAcceptWithManualFutureSet() throws InterruptedException {

        ExecutorService executor = Executors.newCachedThreadPool();

        CompletableFuture<String> future = new CompletableFuture<>();

        future.thenAccept(x -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("thenAccept: " + Thread.currentThread().toString());
        });

        executor.submit(() -> {
            System.out.println("Thread: " + Thread.currentThread());
            System.out.println("before");
            future.complete("future done");
            System.out.println("after");
        });

        executor.awaitTermination(10, TimeUnit.SECONDS);
        executor.shutdown();

    }

    @Test
    public void testThenAcceptAsyncWithManualFutureSet() throws InterruptedException {

        ExecutorService executor = Executors.newCachedThreadPool();

        CompletableFuture<String> future = new CompletableFuture<>();

        future.thenAcceptAsync(x -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("thenAccept: " + Thread.currentThread().toString());
        });

        executor.submit( () -> {
            System.out.println("Thread: " + Thread.currentThread());
            System.out.println("before");
            future.complete("future done");
            System.out.println("after");
        } );

        executor.awaitTermination(10, TimeUnit.SECONDS);
        executor.shutdown();

    }

    @Test
    public void testCompleteOnTimeout() throws InterruptedException {

        ExecutorService executor = Executors.newCachedThreadPool();

        CompletableFuture<String> future = CompletableFuture.supplyAsync(
                () -> {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Executor: " + Thread.currentThread().toString());
                    return "computed";
                }
                , executor
        );

        future.completeOnTimeout("default", 5, TimeUnit.SECONDS)
                .thenAccept(x -> {
                    System.out.println("accept thread: " + Thread.currentThread().toString());
                    System.out.println("thenAccept: " + x);
                });

        executor.awaitTermination(10, TimeUnit.SECONDS);
        executor.shutdown();

    }

    @Test
    public void testOrTimeout() throws Exception {

        ExecutorService executor = Executors.newCachedThreadPool();

        CompletableFuture<String> future = CompletableFuture.supplyAsync(
                () -> {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Executor: " + Thread.currentThread().toString());
                    return "computed";
                }
                , executor
        );

        future.orTimeout(5, TimeUnit.SECONDS)
                .whenComplete((x, e) -> {
                    System.out.println("accept thread: " + Thread.currentThread().toString());
                    System.out.println("thenAccept result: " + x);
                    System.out.println("thenAccept exception: " + e);
                });

        executor.awaitTermination(10, TimeUnit.SECONDS);
        executor.shutdown();

    }

}

