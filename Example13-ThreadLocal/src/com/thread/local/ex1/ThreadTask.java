package com.thread.local.ex1;

import java.text.SimpleDateFormat;

public class ThreadTask implements Runnable {

    @Override
    public void run() {
        int interval = 0;
        for (int i = 0; i < 5; i++) {
            //Same thread processes 5 times
            SimpleDateFormat simpleDateFormat = ThreadSimpleDateFormat
                    .getSimpleDateFormat();
            interval = interval + 1000 * 60 * 60 * 24;
            String formatedDate = simpleDateFormat.format((System
                    .currentTimeMillis() + interval));
            System.out.println("Thread : " + Thread.currentThread().getName()
                    + "  -  Formated Date: " + formatedDate);
        }
    }
}