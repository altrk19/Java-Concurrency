package com.example.io.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtils {
    public static void copy(InputStream src, OutputStream dest) throws IOException {
        int value;
        while ((value = src.read()) != -1) {
            dest.write(value);
        }
    }

    public static void copyFile(String srcFile, String destFile) throws IOException {
        FileInputStream fin = new FileInputStream(srcFile);
        FileOutputStream fout = new FileOutputStream(destFile);
        copy(fin, fout);
        fin.close();
        fout.close();
    }
}