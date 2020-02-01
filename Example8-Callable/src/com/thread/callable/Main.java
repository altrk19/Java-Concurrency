package com.thread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyMath {
    public static int add(int a, int b) {
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        int x = 10;
        int y = 20;

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return MyMath.add(x, y);
            }
        });

        // do some parallel task
        // Inefficient to simply wait,
        // instead you can release the CPU
        // by calling Thread.yield() inside
        // the while loop.
        while (!future.isDone()); // wait

        // fetch the result
        int z = future.get();

        System.out.println("Result is " + z);
    }
}

