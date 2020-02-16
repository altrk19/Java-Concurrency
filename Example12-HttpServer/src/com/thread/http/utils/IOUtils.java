package com.thread.http.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtils {
	
	public static void copy(InputStream in, OutputStream out) throws IOException {
		int value;
		while ((value = in.read()) != -1) {
			out.write(value);
		}
	}
}
