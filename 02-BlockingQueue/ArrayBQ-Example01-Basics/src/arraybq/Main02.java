package arraybq;

import java.util.concurrent.ArrayBlockingQueue;

public class Main02 {
    public static void main(String[] args) {
        int capacity = 15;
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(capacity);

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        //print queue
        System.out.println(queue);

        //take
        Integer element = null;
        try {
            element = queue.take();
        } catch (InterruptedException e) {
            System.out.println("exception");
        }

        System.out.println("take element from queue : " + element);

        //print queue
        System.out.println(queue);
    }
}
