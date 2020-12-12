package concurrency;

import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class Main02_Exception {
    public static void main(String[] args) {
        CopyOnWriteArraySet<Integer> l = new CopyOnWriteArraySet<>();
        l.add(1);
        l.add(2);
        l.add(3);

        // Now we iterate through the CopyOnWriteArraySet and we wont get exception.
        Iterator<Integer> itr = l.iterator();
        while (itr.hasNext()) {
            Integer num = itr.next();
            System.out.println(num);

            if (num.equals(3)) {
                // Here we will get RuntimeException
                itr.remove();
            }
        }
    }
}