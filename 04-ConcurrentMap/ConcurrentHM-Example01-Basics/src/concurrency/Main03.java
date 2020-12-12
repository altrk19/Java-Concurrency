package concurrency;

import java.util.concurrent.ConcurrentHashMap;

public class Main03 {
    public static void main(String[] args) {
        // create an instance of ConcurrentHashMap
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

        // Add elements using put()
        map.put(8, "Third");
        map.put(6, "Second");
        map.put(3, "First");
        map.put(11, "Fourth");

        // The hasNext() method is used to check if there is a next element The next() method is used to retrieve the next element
        for (ConcurrentHashMap.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey()
                    + ", Value = "
                    + entry.getValue());
        }
    }
}
