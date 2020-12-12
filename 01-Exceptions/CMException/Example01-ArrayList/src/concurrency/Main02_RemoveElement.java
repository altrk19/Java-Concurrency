package concurrency;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class Main02_RemoveElement {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");

        for (String value : list) {
            if (value.equals("3")) {
                System.out.println("value is 3");
                list.remove("3");
            }

            System.out.println("List Value:" + value);
        }

        //solution1(list);
        //solution2(list);
        //solution3(list);
        //solution4CopyOnWriteArrayList();
    }

    private static void solution1(List<String> list) {
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            if (iter.next().equalsIgnoreCase("3"))
                iter.remove();
        }
        System.out.println("list items : " + list);
    }

    private static void solution2(List<String> list) {
        list.removeIf(s -> s.equals("3"));
        System.out.println("list items : " + list);
    }

    private static void solution3(List<String> list) {
        List<String> list2 = list.stream().filter(s -> !s.equals("3")).collect(Collectors.toList());
        System.out.println("list items : " + list2);
    }

    private static void solution4CopyOnWriteArrayList() {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");

        for (String value : list) {
            if (value.equals("3")) {
                System.out.println("value is 3");
                list.remove("3");
            }
        }
        System.out.println("List Value:" + list);

    }
}
