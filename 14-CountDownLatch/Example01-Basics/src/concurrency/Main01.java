package concurrency;

import java.util.concurrent.CountDownLatch;

public class Main01 {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Decrementer decrementer = new Decrementer(countDownLatch);
        Waiter waiter = new Waiter(countDownLatch);

        new Thread(waiter).start();
        new Thread(decrementer).start();

        System.out.println("main thread cannot block");
    }
}
