package com.cyclic.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

// CyclicBarrier

// A and B are two participants in a game where they should start
// at once when both are ready. (Rendezvous Pattern)

class A extends Thread {
    CyclicBarrier barrier;

    public A(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    public void run() {
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println("A begins...");
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

        System.out.println("B begins...");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("main started");

        //2 tane thread oldugu için 2 setlendi
        //tüm thread'ler await metotu'nu çağırmadan task'lar çalışmaz
        CyclicBarrier barrier = new CyclicBarrier(2);
        new A(barrier).start();

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
        }

        new B(barrier).start();
    }
}
//8 saniye sonra 2 thread aynı anda taskları çalıştırır.