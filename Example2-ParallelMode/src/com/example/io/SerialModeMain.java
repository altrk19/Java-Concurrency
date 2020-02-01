package com.example.io;

import com.example.io.utils.IOUtils;

import java.io.IOException;

public class SerialModeMain {
    public static void main(String[] args) throws IOException {
        // 1. Copy a.txt to c.txt
        IOUtils.copyFile("a.txt", "c.txt");

        // 2. Copy b.txt to d.txt
        IOUtils.copyFile("b.txt", "d.txt");
    }
}
