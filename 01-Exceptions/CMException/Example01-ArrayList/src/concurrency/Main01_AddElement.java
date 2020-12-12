package concurrency;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Main01_AddElement {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("123");
        list.add("456");
        list.add("789");

        Iterator<String> iterator = list.iterator();

        /*while(iterator.hasNext()) {
            String value = iterator.next();

            if(value.equals("456")){
                list.add("999");
            }
        }*/

        //solution1(list);
        solution2(list);
    }

    private static void solution2(List<String> list) {
        List<String> newList =
                list.stream().filter(el -> el.equals("456")).map(s -> s = "999").collect(Collectors.toList());

        list.addAll(newList);
        System.out.println(list);
    }

    private static void solution1(List<String> list) {
        List<String> toAdd = new ArrayList<>();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String value = it.next();
            if (value.equals("456")) {
                toAdd.add("999");
            }
        }

        // Add all elements
        list.addAll(toAdd);

        // Print
        list.forEach(System.out::println);
        System.out.println("----------");
        toAdd.forEach(System.out::println);
    }
}
