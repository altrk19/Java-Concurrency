package concurrency;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main04_invokeAny {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
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
        String result = executorService.invokeAny(callables);
        System.out.println("result = " + result);
        executorService.shutdown();

        //If one of the tasks complete (or throws an exception), the rest of the Callable's are cancelled.
    }
}
