package com.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class TicketReservationSystem {
    public static Map<String, Integer> trainInfo = new HashMap<>();

    static {
        trainInfo.put("a", 100);
        trainInfo.put("b", 100);
    }

    public void reserveTicket(String trainName, int ticketCount) {
        System.out.println("hello");
        if(trainName.equalsIgnoreCase("a")){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int number = trainInfo.get(trainName);
        int count = number - ticketCount;
        trainInfo.put(trainName, count);
    }
}

class MyThread5 extends Thread {
    TicketReservationSystem ticketReservationSystem;
    private String trainName;
    private int ticketCount;

    MyThread5(TicketReservationSystem ticketReservationSystem, String trainName, int ticketCount) {
        this.ticketReservationSystem = ticketReservationSystem;
        this.trainName = trainName;
        this.ticketCount = ticketCount;
    }

    public void run() {
        ticketReservationSystem.reserveTicket(trainName, ticketCount);
    }
}

public class Main5 {
    public static void main(String[] args) {
        TicketReservationSystem ticketReservationSystem = new TicketReservationSystem();
        MyThread5 t1 = new MyThread5(ticketReservationSystem, "a", 1);
        MyThread5 t2 = new MyThread5(ticketReservationSystem, "b", 1);
        MyThread5 t3 = new MyThread5(ticketReservationSystem, "a", 1);
        MyThread5 t4 = new MyThread5(ticketReservationSystem, "b", 1);
        MyThread5 t5 = new MyThread5(ticketReservationSystem, "a", 1);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("a ticket count:" + TicketReservationSystem.trainInfo.get("a"));
        System.out.println("b ticket count:" + TicketReservationSystem.trainInfo.get("b"));

    }
}

//Solution-1:
//public synchronized void reserveTicket
//Solution-2:
//ConcurrentHashMap