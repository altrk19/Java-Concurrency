package concurrency;

import java.util.concurrent.atomic.AtomicBoolean;

public class Main01 {
    public static void main(String[] arguments) {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        new Thread("Thread 1") {

            public void run() {

                while (true) {
                    System.out.println(Thread.currentThread().getName()
                            + " Waiting for Thread 2 to set Atomic variable to true. Current value is "
                            + atomicBoolean.get());

                    if (atomicBoolean.compareAndSet(true, false)) {
                        System.out.println("Done!");
                        break;
                    }
                }
            }
        }.start();

        new Thread("Thread 2") {

            public void run() {
                System.out.println(Thread.currentThread().getName() +
                        ", Atomic Variable: " + atomicBoolean.get());
                System.out.println(Thread.currentThread().getName() +
                        " is setting the variable to true ");
                atomicBoolean.set(true);
                System.out.println(Thread.currentThread().getName() +
                        ", Atomic Variable: " + atomicBoolean.get());
            }
        }.start();
    }
}