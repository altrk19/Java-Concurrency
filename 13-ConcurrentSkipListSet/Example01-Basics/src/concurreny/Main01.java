package concurreny;

import java.util.Iterator;
import java.util.concurrent.ConcurrentSkipListSet;

public class Main01 {
    public static void main(String[] args) {
        ConcurrentSkipListSet<Integer> set = new ConcurrentSkipListSet<>();
        set.add(78);
        set.add(64);
        set.add(12);
        set.add(45);
        set.add(8);

        // Printing the ConcurrentSkipListSet
        System.out.println("ConcurrentSkipListSet: " + set);

        // Initializing the set using ConcurrentSkipListSet(Collection)
        ConcurrentSkipListSet<Integer> set1 = new ConcurrentSkipListSet<>(set);

        // Printing the ConcurrentSkipListSet1
        System.out.println("ConcurrentSkipListSet1: " + set1);

        // Initializing the set using ConcurrentSkipListSet()
        ConcurrentSkipListSet<String> set2 = new ConcurrentSkipListSet<>();
        set2.add("Apple");
        set2.add("Lemon");
        set2.add("Banana");
        set2.add("Apple");

        // creating an iterator
        Iterator<String> itr = set2.iterator();

        System.out.print("Fruits Set: ");
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
    }
}
