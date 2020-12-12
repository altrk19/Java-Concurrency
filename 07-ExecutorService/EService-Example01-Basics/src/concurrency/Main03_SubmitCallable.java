package concurrency;

import java.util.concurrent.*;

public class Main03_SubmitCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future future = executorService.submit(new Callable() {
            @Override
            public Object call() throws Exception {
                return "Callable Result";
            }
        });
        System.out.println("future.get() = "+future.get());
        executorService.shutdown();
    }
}
