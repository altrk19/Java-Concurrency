package concurrency;

import java.util.concurrent.atomic.AtomicInteger;

class MyRunnable implements Runnable {
    private AtomicInteger at;

    public MyRunnable(AtomicInteger at) {
        this.at = at;
    }

    public void run() {
        int myCounter;
        int myPrevCounter;
        int myCounterPlusFive;
        boolean isNine;

        myCounter = at.incrementAndGet();
        System.out.println("Thread " + Thread.currentThread().getId() + "  / Counter : " + myCounter);
        myPrevCounter = at.getAndIncrement();
        System.out.println("Thread " + Thread.currentThread().getId() + " / Previous : " + myPrevCounter);
        myCounterPlusFive = at.addAndGet(5);
        System.out.println("Thread " + Thread.currentThread().getId() + " / plus five : " + myCounterPlusFive);
        isNine = at.compareAndSet(9, 3);
        if (isNine) {
            System.out.println("Thread " + Thread.currentThread().getId()
                    + " / Value was equal to 9, so it was updated to " + at.intValue());
        }

    }
}
