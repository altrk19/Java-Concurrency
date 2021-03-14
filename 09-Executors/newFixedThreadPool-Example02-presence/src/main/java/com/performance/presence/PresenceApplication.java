package com.performance.presence;

import com.performance.presence.task.Task;
import com.performance.presence.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@SpringBootApplication
public class PresenceApplication implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(PresenceApplication.class);

    private final FileUtil fileUtil;

    public PresenceApplication(FileUtil fileUtil) {
        this.fileUtil = fileUtil;
    }

    public static void main(String[] args) {
        SpringApplication.run(PresenceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        log.debug("Enter the thread count (example:4)");
        int threadSize = scanner.nextInt();

        log.debug("Enter the number of people to send presence (example:20)");
        int presenceNumber = scanner.nextInt();

        log.debug("Enter the thread sleep time as milliseconds (example:100)");
        int sleepTime = scanner.nextInt();

        log.debug("Enter the fileName with extension (example:resource.txt)");
        String fileName = scanner.next();

        String url = "https://webhook.site/372dedbb-d6c1-45b2-a9f6-87606c997562";

        log.debug("Starting read file from file");
        List<String> userChannelList = fileUtil.getUserChannelList(fileName);
        log.debug("Finished read file from file");

        ExecutorService executorService = Executors.newFixedThreadPool(threadSize);
        for (int i = 0; i < threadSize; i++) {
            int skip = userChannelList.size() / threadSize;
            if (skip % 2 == 1) {
                skip++;
            }
            List<String> taskList = userChannelList.stream().skip(i * skip).limit(skip).collect(Collectors.toList());
            Task task = new Task(url, presenceNumber, sleepTime, taskList);
            executorService.submit(task);
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }
        log.debug("Finished all notifications");
        log.debug("Total SUCCESS : {}", Task.successCount);
        log.debug("Total FAIL : {}", Task.failCount);
        System.exit(1);
    }

//    private void writeFile() throws IOException {
//        FileWriter fileWriter = new FileWriter("myfile.txt");
//        PrintWriter printWriter = new PrintWriter(fileWriter);
//        for (int i = 1; i <= 20000; i++) {
//            printWriter.println("/rest/version/1/user/ua-u" + i + "@traffic1.com/websocket/ws-" + i);
//        }
//        printWriter.close();
//        log.debug("COMPLETED");
//    }


}
