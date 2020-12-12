package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main01 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(new Runnable() {
            public void run() {
                System.out.println("Asynchronous task");
            }
        });

        executorService.shutdown();
    }
}
