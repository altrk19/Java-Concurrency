package concurrency;

import java.util.concurrent.CountDownLatch;

public class Decrementer implements Runnable {
    private CountDownLatch countDownLatch;

    public Decrementer(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            System.out.println("countDownLatch decreased");
            this.countDownLatch.countDown();

            Thread.sleep(3000);
            System.out.println("countDownLatch decreased");
            this.countDownLatch.countDown();

            Thread.sleep(3000);
            System.out.println("countDownLatch decreased");
            this.countDownLatch.countDown();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
