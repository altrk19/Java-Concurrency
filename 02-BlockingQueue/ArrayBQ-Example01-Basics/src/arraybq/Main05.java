package arraybq;

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;

public class Main05 {
    public static void main(String[] args) {
        int capacity = 15;
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(capacity);

        queue.offer("User");
        queue.offer("Employee");
        queue.offer("Manager");
        queue.offer("Analyst");
        queue.offer("HR");

        //Print queue
        System.out.println("Queue is " + queue);

        // Call iterator() method and Create an iterator
        Iterator iteratorValues = queue.iterator();

        // Print elements of iterator
        System.out.println("\nThe iterator values:");
        while (iteratorValues.hasNext()) {
            System.out.println(iteratorValues.next());
        }
    }
}
