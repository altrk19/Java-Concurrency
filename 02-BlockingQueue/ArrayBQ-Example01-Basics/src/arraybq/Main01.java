package arraybq;

import java.util.concurrent.ArrayBlockingQueue;

public class Main01 {
    public static void main(String[] args) {
        int capacity = 15;
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(capacity);

        queue.add(1);
        queue.add(2);
        queue.add(3);

        //print queue
        System.out.println(queue);
    }
}
