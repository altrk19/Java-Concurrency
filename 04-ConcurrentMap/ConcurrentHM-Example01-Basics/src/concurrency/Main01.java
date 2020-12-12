package concurrency;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Main01 {
    public static void main(String[] args) {
        ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
        map.put("1", "1");
        map.put("2", "1");
        map.put("3", "1");
        map.put("4", "1");

        //Printing the map
        System.out.println("map:" + map);

        //Create another concurrentHashMap
        ConcurrentMap<String, String> map2 = new ConcurrentHashMap<>();
        map2.putAll(map);
        //Printing the map
        System.out.println("map2:" + map2);

        //Create another concurrentHashMap with constructor
        ConcurrentMap<String, String> map3 = new ConcurrentHashMap<>(map2);
        //Printing the map
        System.out.println("map3:" + map3);
    }
}
