package concurrency;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class Main05_invokeAll {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Set<Callable<String>> callables = new HashSet<>();
        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Task 1";
            }
        });
        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Task 2";
            }
        });
        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Task 3";
            }
        });

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        List<Future<String>> futures = executorService.invokeAll(callables);

        for(Future<String> future : futures){
            System.out.println("future.get() = " + future.get());
        }
        executorService.shutdown();
    }
}
