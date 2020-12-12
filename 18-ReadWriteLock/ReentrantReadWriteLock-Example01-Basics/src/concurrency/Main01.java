package concurrency;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main01 {

    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

    private static String message = "a";

    static class Read implements Runnable {

        public void run() {
            for (int i = 0; i <= 10; i++) {
                if (lock.isWriteLocked()) {
                    System.out.println("I'll take the lock from Write");
                }
                lock.readLock().lock();
                System.out.println("ReadThread " + Thread.currentThread().getId() + " ---> Message is " + message);
                lock.readLock().unlock();
            }
        }
    }

    static class WriteA implements Runnable {

        public void run() {
            for (int i = 0; i <= 10; i++) {
                try {
                    lock.writeLock().lock();
                    message = message.concat("a");
                } finally {
                    lock.writeLock().unlock();
                }
            }
        }
    }

    static class WriteB implements Runnable {

        public void run() {
            for (int i = 0; i <= 10; i++) {
                try {
                    lock.writeLock().lock();
                    message = message.concat("b");
                } finally {
                    lock.writeLock().unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Read());
        Thread t2 = new Thread(new WriteA());
        Thread t3 = new Thread(new WriteB());
        t1.start();
        t2.start();
        t3.start();
    }
}
//Output
/*
ReadThread 11 ---> Message is a
ReadThread 11 ---> Message is a
ReadThread 11 ---> Message is a
ReadThread 11 ---> Message is aa
ReadThread 11 ---> Message is aaa
ReadThread 11 ---> Message is aaaa
ReadThread 11 ---> Message is aaaaa
ReadThread 11 ---> Message is aaaaaab
ReadThread 11 ---> Message is aaaaaabab
ReadThread 11 ---> Message is aaaaaababab
ReadThread 11 ---> Message is aaaaaabababab
*/