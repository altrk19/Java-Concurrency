package concurrency;

import java.util.concurrent.ConcurrentSkipListMap;

public class Main01 {
    public static void main(String[] args) {
        // Initializing the map
        ConcurrentSkipListMap<String, String> map = new ConcurrentSkipListMap<>();

        // Adding elements to this map
        map.put("3", "Geeks");
        map.put("2", "from");
        map.put("1", "Hi!");
        map.put("5", "Geeks");
        map.put("4", "for");

        // print map
        System.out.println("After put(): " + map);

        // remove() operation on the map
        map.remove("3");
        // print the modified map
        System.out.println("After remove(): " + map);


        // remove the first mapping and print it
        System.out.println("pollFirstEntry: "+ map.pollFirstEntry());
        // remove the last mapping and print it
        System.out.println("pollLastEntry: "+ map.pollLastEntry());
        // Print final map
        System.out.println("map contents: " + map);
    }
}
