package concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public class Main01 {
    static class ExecutorImpl implements Executor {
        @Override
        public void execute(Runnable command) {
            new Thread(command).start();
        }
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println("Thread executed under an executor");
        }
    }

    public static void main(String[] args) {
        ExecutorImpl executor = new ExecutorImpl();
        try {
            executor.execute(new Task());
        } catch (RejectedExecutionException | NullPointerException ex) {
            System.out.println(ex);
        }
    }
}
