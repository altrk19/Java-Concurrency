package concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main03_CheckTaskIsDone {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future future = executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("task running");
            }
        });

        if (future.isDone()) {
            Object result = future.get();
            System.out.println("task completed");
        } else {
            //do something else
            System.out.println("task not completed");
        }

        executorService.shutdown();
    }
}
