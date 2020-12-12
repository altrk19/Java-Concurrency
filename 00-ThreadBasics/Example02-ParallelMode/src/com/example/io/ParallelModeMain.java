package com.example.io;

import com.example.io.utils.IOUtils;

import java.io.IOException;

public class ParallelModeMain {
    public static void main(String[] args) {

        // 1. Copy a.txt to c.txt
        Thread t1 = new Thread(new MyTask("a.txt", "c.txt"));
        t1.start();

        // 2. Copy b.txt to d.txt
        Thread t2 = new Thread(new MyTask("b.txt", "d.txt"));
        t2.start();
    }
}

class MyTask implements Runnable {
    private String source;
    private String destination;

    public MyTask(String source, String destination) {
        this.source = source;
        this.destination = destination;
    }

    @Override
    public void run() {
        try {
            IOUtils.copyFile(source, destination);
            System.out.println(String.format("Competed transfer from %s to %s",source,destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
