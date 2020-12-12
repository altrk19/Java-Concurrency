package concurrency;

import java.util.Iterator;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Main03 {
    public static void main(String[] args) {
        BlockingDeque<Integer> deque = new LinkedBlockingDeque<>();

        //add numbers to deque
        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(4);

        // Call iterator() method of LinkedBlockingDeque
        Iterator<Integer> iteratorValues = deque.iterator();

        // prints the elements using an iterator
        while (iteratorValues.hasNext()) {
            System.out.println(iteratorValues.next());
        }
    }
}
