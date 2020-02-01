package com.executor.service.task;

import com.executor.service.util.IOUtils;

import java.io.IOException;

public class MyTask implements Runnable {
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
