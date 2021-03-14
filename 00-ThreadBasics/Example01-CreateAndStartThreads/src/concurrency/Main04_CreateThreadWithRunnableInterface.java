package concurrency;

public class Main04_CreateThreadWithRunnableInterface {
    static class MyRunnable implements Runnable {
        @Override
        public void run(){
            System.out.println("MyRunnable running");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }
}
