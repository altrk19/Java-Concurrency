package com.thread.local.ex1;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class ThreadSimpleDateFormat {

    private static final ThreadLocal<SimpleDateFormat> SIMPLE_DATE_FORMAT =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("dd/MM/yyyy", new Locale("tr", "TR")));

    public static SimpleDateFormat getSimpleDateFormat() {
        return SIMPLE_DATE_FORMAT.get();
    }

//    public static void setSimpleDateFormat(SimpleDateFormat simpleDateFormat) {
//        SIMPLE_DATE_FORMAT.set(simpleDateFormat);
//    }

//    public static void removeSimpleDateFormat() {
//        SIMPLE_DATE_FORMAT.remove();
//    }
}