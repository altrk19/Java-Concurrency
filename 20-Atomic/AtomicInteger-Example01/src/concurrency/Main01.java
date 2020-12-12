package concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class Main01 {
    public static void main(String[] args) {
        AtomicInteger at = new AtomicInteger(0);
        Thread t1 = new Thread(new MyRunnable(at));
        Thread t2 = new Thread(new MyRunnable(at));
        t1.start();
        t2.start();
    }
}