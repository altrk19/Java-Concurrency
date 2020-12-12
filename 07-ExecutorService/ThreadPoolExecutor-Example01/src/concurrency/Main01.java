package concurrency;


import java.util.concurrent.*;

public class Main01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int corePoolSize = 5;
        int maxPoolSize = 10;
        long keepAliveTime = 5000;
        ExecutorService executorService =
                new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<Runnable>());

        Future future = executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("task is running");
            }
        });
        future.get();
        System.out.println("task completed");
        executorService.shutdown();
    }
}
