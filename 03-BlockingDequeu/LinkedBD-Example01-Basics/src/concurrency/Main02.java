package concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Main02 {
    public static void main(String[] args) {
        BlockingDeque<Integer> deque = new LinkedBlockingDeque<>();

        // Add number to end of LinkedBlockingDeque
        deque.add(1);

        // Add integer at the head or front
        deque.addFirst(2);

        // Add integer at the tail or end
        deque.addLast(3);

        // prints the Deque
        System.out.println("Linked Blocking Deque: " + deque);


        System.out.println("----------------------------------------------------------");


        List<Integer> list = Arrays.asList(20, 30, 40, 50);
        deque.addAll(list);
        // prints the Deque
        System.out.println("Linked Blocking Deque: " + deque);


        System.out.println("----------------------------------------------------------");


        // removes the front element
        deque.remove();
        // prints the Deque
        System.out.println("Linked Blocking Deque: " + deque);

        // removes the front element
        deque.removeFirst();
        // prints the Deque
        System.out.println("Linked Blocking Deque: " + deque);

        // removes the last element
        deque.removeLast();
        // prints the Deque
        System.out.println("Linked Blocking Deque: " + deque);
    }
}
