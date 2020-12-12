package concurrency;

import java.util.concurrent.ConcurrentSkipListMap;

public class Main02 {
    public static void main(String[] args) {
        // create an instance of ConcurrentSkipListMap
        ConcurrentSkipListMap<Integer, Integer> map = new ConcurrentSkipListMap<>();

        // Add mappings using put method
        for (int i = 0; i < 6; i++) {
            map.put(i, i);
        }

        // The hasNext() method is used to check if there is a next element The next() method is used to retrieve the next element
        for (ConcurrentSkipListMap.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey()
                    + ", Value = "
                    + entry.getValue());
        }
    }
}
