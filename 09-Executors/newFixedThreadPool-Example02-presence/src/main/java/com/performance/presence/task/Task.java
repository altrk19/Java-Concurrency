package com.performance.presence.task;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.performance.presence.constant.HttpStatusCodeRange;
import com.performance.presence.model.NotificationMessage;
import com.performance.presence.util.HttpStatusCodeRangeUtil;
import com.performance.presence.util.NotificationMessageGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Task implements Runnable {
    private static final Logger log = LoggerFactory.getLogger(Task.class);
    public static AtomicInteger successCount = new AtomicInteger(0);
    public static AtomicInteger failCount = new AtomicInteger(0);

    private String url;
    private int friendCount;
    private int sleepTime;
    private List<String> userChannelList;
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public Task(String url, int friendCount, int sleepTime, List<String> userChannelList) {
        this.url = url;
        this.friendCount = friendCount;
        this.sleepTime = sleepTime;
        this.userChannelList = userChannelList;
    }

    @Override
    public void run() {
        while (!userChannelList.isEmpty()) {
            for (int i = 0; i < friendCount; i++) {
                NotificationMessage notificationMessage =
                        NotificationMessageGenerator.generateNotificationMessage(userChannelList.get(0), "b" + (i + 1));
                ResponseEntity<String> response;
                try {
                    response = sendRequests(url, notificationMessage);
                    log.debug("Thread : {} RESPONSE : {}", Thread.currentThread().getName(), response.getStatusCode());
                    if (HttpStatusCodeRangeUtil.getRange(response.getStatusCodeValue()) ==
                            HttpStatusCodeRange.SUCCESS_RANGE) {
                        successCount.getAndIncrement();
                    } else {
                        failCount.getAndIncrement();
                    }
                    Thread.sleep(sleepTime);

                } catch (Exception ex) {
                    log.error("Exception occurred while sending request");
                    failCount.getAndIncrement();
                }
            }
            userChannelList.remove(0);
            userChannelList.remove(0);
        }
    }

    private ResponseEntity<String> sendRequests(String url, NotificationMessage notificationMessage)
            throws JsonProcessingException {
        log.debug("sending requests");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String body = objectMapper.writeValueAsString(notificationMessage);
        log.debug("Sending rest Request to : {} with the following body : {}", url, body);
        HttpEntity<String> request = new HttpEntity<>(body, headers);
        return restTemplate.postForEntity(url, request, String.class);
    }
}
