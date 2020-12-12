package arraybq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Main03 {
    public static void main(String[] args) throws InterruptedException {
        int capacity = 15;
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(capacity);

        queue.offer(1, 3, TimeUnit.SECONDS);
        queue.offer(2, 3, TimeUnit.SECONDS);
        queue.offer(3, 3, TimeUnit.SECONDS);

        //print queue
        System.out.println(queue);

        //remove
        boolean response = queue.remove(2);

        //print queue
        System.out.println("Removal of 2 :"+response);
        System.out.println(queue);

        //remove all elements
        queue.clear();

        //print queue
        System.out.println(queue);
    }
}
