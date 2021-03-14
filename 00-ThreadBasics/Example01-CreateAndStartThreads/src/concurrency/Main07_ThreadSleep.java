package concurrency;

public class Main07_ThreadSleep {
    public static void main(String[] args) {
        System.out.println("Hello1");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Hello2");
    }
}
