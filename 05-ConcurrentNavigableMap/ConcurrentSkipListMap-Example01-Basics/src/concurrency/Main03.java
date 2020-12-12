package concurrency;

import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class Main03 {
    public static void main(String[] args) {
        ConcurrentNavigableMap map = new ConcurrentSkipListMap();

        map.put("1", "one");
        map.put("2", "two");
        map.put("3", "three");
        map.put("4", "four");
        map.put("5", "five");
        map.put("6", "six");

        ConcurrentNavigableMap subMap = map.subMap("2", "5");
        System.out.println(subMap);//{2=two, 3=three, 4=four}

        ConcurrentNavigableMap tailMap = map.tailMap("3");
        System.out.println(tailMap);//{3=three, 4=four, 5=five, 6=six}

        ConcurrentNavigableMap headMap = map.headMap("4");
        System.out.println(headMap);//{1=one, 2=two, 3=three}

    }
}
