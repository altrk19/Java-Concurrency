package concurrency;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class Main01 {
    public static void main(String[] args) {
        CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>();

        // Initial Iterator
        Iterator itr = set.iterator();

        // add elements using add() method
        set.add("GeeksforGeeks");

        // print the contents of set to the console
        System.out.print("Set contains1: ");
        while (itr.hasNext())
            System.out.print(itr.next());

        System.out.println();

        // iterator after adding an element
        itr = set.iterator();

        // print the elements to the console
        System.out.print("Set contains2:");
        while (itr.hasNext())
            System.out.print(itr.next());
    }
}
