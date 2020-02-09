package com.thread;

class Sample{
    private int x;

    public Sample(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public synchronized void  inc(){
        int y = getX();
        try{
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setX(++y);
    }
}

class MyThread extends Thread{
    private Sample sample;

    public MyThread(Sample sample){
        this.sample=sample;
    }

    public void run() {
        sample.inc();
    }
}

public class Main1 {
    public static void main(String[] args) {
        Sample sample = new Sample(10);
        MyThread t1 = new MyThread(sample);
        MyThread t2 = new MyThread(sample);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(sample.getX());
    }
}
