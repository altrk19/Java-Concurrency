package com.daemon.thread;

class MyTask implements Runnable {

    @Override
    public void run() {
        while (true){
            System.out.print("T");
        }
    }
}
public class Main2 {
    public static void main(String[] args) {
        Thread myThread = new Thread(new MyTask());
        myThread.setPriority(8);
        //thmyThreadr will be interrupted when the main thread finished
        myThread.setDaemon(true);
        myThread.start();

        for (int i=1; i <= 200; i++) {
            System.out.print("M");
        }
    }
}