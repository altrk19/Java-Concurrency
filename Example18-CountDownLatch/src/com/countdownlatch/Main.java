package com.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable {
    private CountDownLatch latch;

    public Processor(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("Thread started.");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        latch.countDown();
    }
}
public class Main {

    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(3);

        /*
        CountDownLatch latch = new CountDownLatch(5);  -> program will not complete
         */

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            executorService.submit(new Processor(latch));
        }
        executorService.shutdown();

        System.out.println("Waiting threads complete task");
        System.out.println("Waiting threads complete task");
        System.out.println("Waiting threads complete task");
        System.out.println("Waiting threads complete task");
        System.out.println("Waiting threads complete task");
        System.out.println("Waiting threads complete task");
        System.out.println("Waiting threads complete task");
        System.out.println("Waiting threads complete task");
        try {
            latch.await();
        } catch (InterruptedException e) {
        }

        //main thread will wait until latch is zero
        System.out.println("Program finished.");
    }
}