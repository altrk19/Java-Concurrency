package concurrency;

import java.util.concurrent.Semaphore;

class PrintThread extends Thread {
    int id;
    Semaphore semaphore;

    PrintThread(int id, Semaphore semaphore) {
        this.id = id;
        this.semaphore = semaphore;
    }

    public void run() {
        try {
            semaphore.acquire();
            // critical
            System.out.println("Printer " + id + " is printing...");
            Thread.sleep(3000);
            semaphore.release();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Main01 {
    public static void main(String [] args) {
        Semaphore semaphore = new Semaphore(3);
        new PrintThread(1, semaphore).start();
        new PrintThread(2, semaphore).start();
        new PrintThread(3, semaphore).start();
        new PrintThread(4, semaphore).start();
    }

}