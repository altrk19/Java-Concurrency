package concurrency;


public class Main02_CreateThreadWithSubclass {
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("MyThread running");
        }

        public static void main(String[] args) {
            MyThread myThread = new MyThread();
            myThread.start();
        }
    }
}
