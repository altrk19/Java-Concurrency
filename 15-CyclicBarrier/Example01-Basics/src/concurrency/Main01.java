package concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class A extends Thread {
    CyclicBarrier barrier;

    public A(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    public void run() {
        try {
            Thread.sleep(6000);
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println("A is done...");
    }
}

class B extends Thread {
    CyclicBarrier barrier;

    public B(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    public void run() {
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println("B is done...");
    }
}

public class Main01 {
    public static void main(String[] args) {
        System.out.println("main started");

        CyclicBarrier barrier = new CyclicBarrier(2);
        new A(barrier).start();
        new B(barrier).start();
    }
}