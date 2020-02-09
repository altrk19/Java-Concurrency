package com.thread;

import java.util.ArrayList;
import java.util.List;

class MyList {
    private List<String> list = new ArrayList<>();

    public synchronized int sizeList() {
        return list.size();
    }

    public synchronized void addValue(String value) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list.add(value);
    }

    public void addValueNoSynchronized(String value) {
        list.add(value);
    }

    public void print() {
        for (String str : list) {
            System.out.println(str);
        }
    }

}

class MyThread3 extends Thread {
    MyList myList;

    MyThread3(MyList myList) {
        this.myList = myList;
    }

    public void run() {
        if (myList.sizeList() < 3) {
            myList.addValue("test");
        }
    }
}

public class Main3 {
    public static void main(String[] args) {
        MyList myList = new MyList();
        myList.addValueNoSynchronized("1");
        myList.addValueNoSynchronized("2");

        System.out.println("hello");
        MyThread3 t1 = new MyThread3(myList);
        MyThread3 t2 = new MyThread3(myList);

        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myList.print();
    }


}
