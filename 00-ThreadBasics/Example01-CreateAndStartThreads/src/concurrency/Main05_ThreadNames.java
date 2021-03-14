package concurrency;

public class Main05_ThreadNames {
    public static void main(String[] args) {
        Thread thread = new Thread("New Name") {
            @Override
            public void run(){
                System.out.println("run by: " + this.getName());
            }
        };
        thread.start();
        System.out.println(thread.getName());
    }
}
