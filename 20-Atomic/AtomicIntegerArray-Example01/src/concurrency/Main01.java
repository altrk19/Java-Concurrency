package concurrency;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class Main01 {
    public static void main(String[] args) {
        int[] ints = new int[10];
        ints[5] = 123;
        AtomicIntegerArray array = new AtomicIntegerArray(ints);

        //get
        int value = array.get(5);
        System.out.println(value); //123

        //set
        array.set(6, 999);//999
        System.out.println(array.get(6));//999

        //compareAndSet
        boolean swapped = array.compareAndSet(6, 999, 588);
        System.out.println(swapped);//true
        System.out.println(array.get(6));//588

        //addAndGet
        int newValue = array.addAndGet(5, 3);
        System.out.println(newValue);//126

        //incrementAndGet
        int newValueInc = array.incrementAndGet(5);
        System.out.println(newValueInc);//127

        //getAndAdd
        int oldValue = array.getAndAdd(5, 3);

        //decrementAndGet
        int newValueDec = array.decrementAndGet(5);

    }
}
