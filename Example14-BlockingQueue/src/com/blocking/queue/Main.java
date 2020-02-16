package com.blocking.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class ProducerThread extends Thread {
    BlockingQueue<String> queue;

    public ProducerThread(BlockingQueue<String>  queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for(int i=1; i <= 10; i++) {
            String msg = "Hello-" + i;

            // Blocks the thread until the space is available.
            try {
                queue.put(msg);
                System.out.println("Produced - " + msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class ConsumerThread extends Thread {
    BlockingQueue<String> queue;

    public ConsumerThread(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for(int i=1; i<=10; i++) {
            String message = null;

            // Blocks the thread until the element is available.
            try {
                message = queue.take();
                System.out.println("Consumed - " + message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(1);
        new ProducerThread(queue).start();
        new ConsumerThread(queue).start();
    }
}
