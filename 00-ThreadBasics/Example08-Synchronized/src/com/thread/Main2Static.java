package com.thread;

class Sample2 {

    static int a = 5;
    int b = 10;

    public  void increment( ) {
        // lock the Class object before modifying static content.
        synchronized(Sample2.class) {
            a++;
        }

        // lock the object before modifying instance members.
        synchronized(this) {
            b++;
        }
    }
}

class MyThread2 extends Thread{
    private Sample2 sample;

    public MyThread2(Sample2 sample){
        this.sample=sample;
    }

    public void run() {
        sample.increment();
    }
}

public class Main2Static{
    public static void main(String[] args) {
        Sample2 sample2 = new Sample2();
        MyThread2 t1 = new MyThread2(sample2);
        MyThread2 t2 = new MyThread2(sample2);

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Sample2.a);
    }
}