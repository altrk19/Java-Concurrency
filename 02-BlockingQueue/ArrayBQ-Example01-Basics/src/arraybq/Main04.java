package arraybq;

import java.util.concurrent.ArrayBlockingQueue;

public class Main04 {
    public static void main(String[] args) throws InterruptedException {
        int capacity = 15;
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(capacity);

        queue.put(1);
        queue.put(2);
        queue.put(3);

        //print queue
        System.out.println(queue);

        //print head of queue using peek()
        System.out.println(queue.peek());
    }
}
