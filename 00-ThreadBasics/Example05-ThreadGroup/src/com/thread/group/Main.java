package com.thread.group;

class MyTask implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class Main {

    public static void main(String[] args) {
        // CREATING A THREADGROUP
        ThreadGroup myGroup = new ThreadGroup("MyGroup");
        myGroup.setMaxPriority(4);

        // ASSOCIATING A THREAD WITH THREAD GROUP
        Thread myThread = new Thread(myGroup, new MyTask(), "DemoThread");
        myThread.start();

        System.out.println("System threads..........");
        Thread thr = Thread.currentThread();
        ThreadGroup grp = thr.getThreadGroup();
        while (grp.getParent() != null) {
            grp = grp.getParent();
        }
        grp.list();
    }
}
