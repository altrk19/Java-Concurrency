package com.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Sample4 {
    private int x;
    // ReadWriteLock object for requesting the lock.
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void incr() {
        // Request the write lock as the operation is intended to modify the data.
        Lock lock = readWriteLock.writeLock();
        lock.lock();
        try {

            int y = getX();
            y++;

            // Just for simulation
            try {
                Thread.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            setX(y);
        } finally {
            // Unlock
            lock.unlock();
        }
    }
}

class MyThread4 extends Thread {
    Sample4 obj;
    public MyThread4(Sample4 obj) {
        this.obj = obj;
    }
    public void run() {
        obj.incr();
    }
}

public class Main4ReentrantLocks {
    public static void main(String[] args) {
        Sample4 obj = new Sample4();
        obj.setX(10);

        MyThread4 t1 = new MyThread4(obj);
        MyThread4 t2 = new MyThread4(obj);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(obj.getX());
    }
}
