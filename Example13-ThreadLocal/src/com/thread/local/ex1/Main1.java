package com.thread.local.ex1;

public class Main1 {
    public static void main(String[] args) {

        Thread th1 = new Thread(new ThreadTask());
        Thread th2 = new Thread(new ThreadTask());
        Thread th3 = new Thread(new ThreadTask());

        th1.start();
        th2.start();
        th3.start();
    }
}
