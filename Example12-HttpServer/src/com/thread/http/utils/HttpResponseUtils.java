package com.thread.http.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class HttpResponseUtils {
	
	public static void sendSuccessResponse(InputStream in, OutputStream out) throws IOException {
		PrintWriter pw = new PrintWriter(out);
		pw.println("HTTP/1.0 200 OK");
		pw.println();
		pw.flush();
		
		IOUtils.copy(in, out);
		out.close();
	}
	
	public static void sendResourceNotFound(OutputStream out) throws IOException {
		PrintWriter pw = new PrintWriter(out);
		pw.println("HTTP/1.0 404 ResourceNotFound");
		pw.close();
		out.close();
	}
	
	public static void sendInternalError(OutputStream out) throws IOException {
		PrintWriter pw = new PrintWriter(out);
		pw.println("HTTP/1.0 500 InternalServerError");
		pw.close();
		out.close();
	}
}
