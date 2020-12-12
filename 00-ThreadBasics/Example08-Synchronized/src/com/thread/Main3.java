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
            Thread.sleep(10000);
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

        MyThread3 t1 = new MyThread3(myList);
        MyThread3 t2 = new MyThread3(myList);

        t1.start();
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
/*
Output:
1
2
test
test
 */

//Bu şekilde 2 farklı synchronization metotu kullanmak thread senkronizasyon sorununa yol açabilir.
//Bunun yerine listeyi locklamak ve liste üzerinde işlem yapmak daha mantıklıdır.