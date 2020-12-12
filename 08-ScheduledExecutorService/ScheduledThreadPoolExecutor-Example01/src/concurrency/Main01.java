package concurrency;

import java.util.concurrent.*;

public class Main01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        ScheduledFuture scheduledFuture = scheduledExecutorService.schedule(new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("Executed");
                return "Called";
            }
        },5, TimeUnit.SECONDS);
        System.out.println("result = " + scheduledFuture.get());
        scheduledExecutorService.shutdown();
    }
}
