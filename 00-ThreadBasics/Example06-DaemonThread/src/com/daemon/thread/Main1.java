package com.daemon.thread;

public class Main1 {
    public static void main(String[] args) {
        System.out.println("System threads..........");
        Thread thr = Thread.currentThread();
        ThreadGroup grp = thr.getThreadGroup();

        //find parent thread group
        while (grp.getParent() != null) {
            grp = grp.getParent();
        }

        Thread [] threads = new Thread[10];
        //enumerate method lists the threads in that group and copies the references to the given array. It also returns the number of threads copied
        int n = grp.enumerate(threads);

        for (int i=0; i < n; i++) {
            System.out.println(
                    "Thread Name: " + threads[i].getName() +
                            " ; isDaemon: " + threads[i].isDaemon());
        }
    }
}
//You can see that Reference Handler, Finalizer, Single Dispatcher all these are daemon threads because they run the background and they doesn't stop the application from exiting.
