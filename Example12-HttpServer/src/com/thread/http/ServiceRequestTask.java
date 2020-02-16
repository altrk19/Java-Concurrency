package com.thread.http;

import com.thread.http.request.handler.RequestHandler;

import java.net.Socket;


public class ServiceRequestTask implements Runnable {

    Socket sock;

    RequestHandler requestHandler = new RequestHandler();

    public ServiceRequestTask(Socket sock) {
        this.sock = sock;
    }

    @Override
    public void run() {
        requestHandler.handleRequest(sock);
    }

}