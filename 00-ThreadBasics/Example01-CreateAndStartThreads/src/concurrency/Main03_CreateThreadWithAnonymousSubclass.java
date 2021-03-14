package concurrency;

public class Main03_CreateThreadWithAnonymousSubclass {
    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run(){
                System.out.println("Thread Running");
            }
        };
        thread.start();
    }

}
