package concurrency;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Main02 {
    public static void main(String[] args) {
        ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
        map.put("1", "1");
        map.put("2", "1");
        map.put("3", "1");
        map.put("4", "1");

        //Printing the map
        System.out.println("map:" + map);

        //removing existing key 4
        String valueRemoved = map.remove("4");
        System.out.println("After removing mapping with key 4:");
        System.out.println("Map: " + map);
        System.out.println("Value removed: " + valueRemoved);

        //removing with non-existing key 5
        String valueRemoved5 = map.remove("5");
        System.out.println("After removing mapping with key 5:");
        System.out.println("Map: " + map);
        System.out.println("Value removed: " + valueRemoved5);


        // Now clear the map using clear()
        map.clear();
        //Printing the map
        System.out.println("map:" + map);
    }
}
