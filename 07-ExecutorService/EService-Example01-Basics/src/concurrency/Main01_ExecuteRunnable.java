package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main01_ExecuteRunnable {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("task completed");
            }
        });
        executorService.shutdown();
    }
}
