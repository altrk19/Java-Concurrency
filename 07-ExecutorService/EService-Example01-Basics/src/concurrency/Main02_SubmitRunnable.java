package concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main02_SubmitRunnable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future future = executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("task");
            }
        });

        System.out.println(future.get()); ////returns null if the task has finished correctly.
        executorService.shutdown();
    }
}
