package concurrency;

import java.util.concurrent.*;

public class Main01_Get {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future future = executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("task running");
            }
        });

        Object result = future.get(); // it blocks main thread until task completed
        System.out.println(result); // prints null if task is completed



        /*--------------------------------------------------*/


        future = executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("task completed");
            }
        });

        Object result2 = future.get(3000, TimeUnit.MILLISECONDS);
        System.out.println(result2); // prints null if task is completed



        /*--------------------------------------------------*/



        future = executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("task completed");
            }
        });

        Object result3 = null;
        try {
            result3 = future.get(3000, TimeUnit.MILLISECONDS); //throw TimeoutException if task is not completed in 3000ms
        } catch (TimeoutException e) {
            executorService.shutdown();
            e.printStackTrace();
        }
        System.out.println(result3); // prints null if task is completed


        executorService.shutdown();

    }


}
