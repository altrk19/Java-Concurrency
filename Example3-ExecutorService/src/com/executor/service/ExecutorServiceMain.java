package com.executor.service;

import com.executor.service.task.MyTask;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceMain {
    public static void main(String[] args) throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Assume you are submitting 100 copy tasks,
        // then executor service uses a fixed thread
        // pool of size 5 to execute them.

        executor.execute(new MyTask("a.txt", "c.txt"));
        executor.execute(new MyTask("b.txt", "d.txt"));
    }
}