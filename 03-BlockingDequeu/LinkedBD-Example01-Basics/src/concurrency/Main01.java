package concurrency;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Main01 {
    public static void main(String[] args) {
        BlockingDeque<Integer> deque = new LinkedBlockingDeque<>();

        //add numbers to deque
        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(4);

        // print Deque
        System.out.println("Linked Blocking Deque: " + deque);
        System.out.println("Size of Linked Blocking Deque: " + deque.size());
        System.out.println("Capacity of Linked Blocking Deque: " + deque.remainingCapacity());


        System.out.println("---------------------------------------------------------------");


        int capacity = 3;
        BlockingDeque<Integer> deque2 = new LinkedBlockingDeque<>(capacity);

        //add numbers to deque
        deque2.add(6);
        deque2.add(7);
        deque2.add(8);

        try {
            // adding the 4th element
            // will throw exception for Deque full
            deque2.add(74381793);
        }
        catch (Exception e) {
            System.out.println("Exception: " + e);
        }

        // print Deque
        System.out.println("Linked Blocking Deque2: " + deque2);
        System.out.println("Size of Linked Blocking Deque2: " + deque2.size());
        System.out.println("Capacity of Linked Blocking Deque2: " + deque2.remainingCapacity());


        System.out.println("---------------------------------------------------------------");



        // create object of LinkedBlockingDeque
        // using LinkedBlockingDeque(Collection c) constructor
        LinkedBlockingDeque<Integer> deque3 = new LinkedBlockingDeque<>(deque2);

        // print Deque3
        System.out.println("Linked Blocking Deque3: " + deque3);
    }
}
