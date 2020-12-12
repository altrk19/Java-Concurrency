package com.thread.serial.parallel.parallel;

import com.thread.serial.parallel.utils.PatternFinder;

import java.io.File;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main2 {
    private static Map<String, Future<List<Integer>>> resultMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        // pattern to search
        String pattern = "public";

        // Directory or folder to search
        File dir = new File("./src/sample");

        // list all the files present in the folder.
        File[] files = dir.listFiles();

        PatternFinder finder = new PatternFinder();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        long startTime = System.currentTimeMillis();
        // for each file in the list of files

        if (Objects.nonNull(files)) {
            for (File file : files) {
                // Submit a Callable task for the file.
                Future<List<Integer>> future = executorService.submit(new Callable<List<Integer>>() {
                    @Override
                    public List<Integer> call() {
                        return finder.find(file, pattern);
                    }
                });
                //Main thread callable threadlere taskı assign etti ve map'e yazdı. Bu map'te future nesnesinin referansı tutuluyor.
                //Thread, taskı tamamlayınca map içerisinde tamamlanmış taskın resultu olmuş olacak.
                //Ayrıca get() metotunu kullanıyorsak otomatik olarak thread'in taskının tamamlanmış olmasını beklemek zorunda kalmış olacağız.
                resultMap.put(file.getName(), future);
            }

            // Wait for the requests to complete.
            waitForAll(resultMap);

            // Display the result.
            for (Map.Entry<String, Future<List<Integer>>> entry : resultMap.entrySet()) {
                System.out.println(
                        pattern + " found at - " + entry.getValue().get() +
                                " in file " + entry.getKey());
            }

            System.out.println(
                    " Time taken for search - "
                            + (System.currentTimeMillis() - startTime));
        } else {
            System.err.println("files is null");
        }

    }

    private static void waitForAll(Map<String, Future<List<Integer>>> resultMap) throws Exception {
        Set<String> keys = resultMap.keySet();
        for (String key : keys) {
            Future<List<Integer>> future = resultMap.get(key);
            while (!future.isDone()) {
                // Passing the CPU to other threads so that they can complete the operation.
                // With out this we are simply keeping the CPU in loop and wasting its time.
                //Main thread fedekarlık yapıyor. CPU'yu thread'lerin taskı tamamlaması için main thread'in fedakarlık yapmasına yarıyor bu metot.
                Thread.yield();
            }
        }
    }
}
