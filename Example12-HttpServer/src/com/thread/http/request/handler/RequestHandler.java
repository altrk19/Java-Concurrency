package com.thread.http.request.handler;


import com.thread.http.utils.HttpResponseUtils;
import com.thread.http.utils.HttpUtils;
import com.thread.http.utils.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class RequestHandler {
	
	ResourceLoader resourceLoader = new ResourceLoader();
	
	public void handleRequest(Socket sock) {
		OutputStream out = null;

		try {
			out = sock.getOutputStream();
			String request = HttpUtils.getRequest(sock);
			System.out.println("request:" + request);

			String uri = HttpUtils.getRequestUri(request);
			System.out.println("Received request for - " + uri);

			//request içerisindeki resource, resources dizini altında var mı diye bakılır.
			InputStream in = resourceLoader.getResource(uri);

			if (in == null) {
				System.out.println("Sending resource not found ");
				HttpResponseUtils.sendResourceNotFound(out);
				return;
			}

			System.out.println("Sending response ");
			HttpResponseUtils.sendSuccessResponse(in, out);

		} catch (Exception e) {
			e.printStackTrace();
			if (out != null) {
				try {
					System.out.println("Sending internal error ");
					HttpResponseUtils.sendInternalError(out);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				sock.close();
			} catch (Exception e) {
			}
		}
	}
}
