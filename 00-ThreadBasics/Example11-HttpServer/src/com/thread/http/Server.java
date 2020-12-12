package com.thread.http;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public static void main(String[] args) throws Exception {

        ServerSocket serSock = new ServerSocket(8000);
        ExecutorService executor = Executors.newFixedThreadPool(5);

        while (true) {
            System.out.println("Waiting for client...");
            Socket sock = serSock.accept();

            System.out.println("Task submitted");
            executor.submit(new ServiceRequestTask(sock));
        }

    }

}

