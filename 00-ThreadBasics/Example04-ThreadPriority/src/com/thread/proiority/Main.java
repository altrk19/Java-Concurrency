package com.thread.proiority;

class CopyTask implements Runnable {
    @Override
    public void run() {
        while(true) {
            System.out.print("C");
        }
    }
}

class ProgressTask implements Runnable {
    @Override
    public void run() {
        while(true) {
            System.out.print("-");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CopyTask copyTask = new CopyTask();
        Thread copyThread = new Thread(copyTask);
        copyThread.setPriority(Thread.NORM_PRIORITY + 3);
        copyThread.start();

        ProgressTask progressTask = new ProgressTask();
        Thread progressThread = new Thread(progressTask);
        progressThread.start();
    }
}