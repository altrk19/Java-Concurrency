package concurrency;

import java.util.concurrent.atomic.AtomicReference;

public class Main01 {

    private static String message;
    private static Person person;
    private static AtomicReference<String> aRmessage;
    private static AtomicReference<Person> aRperson;

    static class MyRun1 implements Runnable {
        public void run() {
            aRmessage.compareAndSet(message, "Thread 1");
            message = message.concat("-Thread 1!");
            person.setAge(person.getAge() + 1);
            person.setName("Thread 1");
            aRperson.getAndSet(new Person("Thread 1", 1));
            System.out.println("\n" + Thread.currentThread().getName() + " Values "
                    + message + " - " + person.toString());
            System.out.println("\n" + Thread.currentThread().getName() + " Atomic References "
                    + message + " - " + person.toString());
        }
    }

    static class MyRun2 implements Runnable {
        public void run() {
            message = message.concat("-Thread 2");
            person.setAge(person.getAge() + 2);
            person.setName("Thread 2");
            aRmessage.lazySet("Thread 2");
            aRperson.set(new Person("Thread 2", 2));
            System.out.println("\n" + Thread.currentThread().getName() + " Values: "
                    + message + " - " + person.toString());
            System.out.println("\n" + Thread.currentThread().getName() + " Atomic References: "
                    + aRmessage.get() + " - " + aRperson.get().toString());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyRun1());
        Thread t2 = new Thread(new MyRun2());
        message = "hello";
        person = new Person("Phillip", 23);
        aRmessage = new AtomicReference<>(message);
        aRperson = new AtomicReference<>(person);
        System.out.println("Message is: " + message
                + "\nPerson is " + person.toString());
        System.out.println("Atomic Reference of Message is: " + aRmessage.get()
                + "\nAtomic Reference of Person is " + aRperson.get().toString());
        t1.start();
        t2.start();
        System.out.println("\nNow Message is: " + message
                + "\nPerson is " + person.toString());
        System.out.println("Atomic Reference of Message is: " + aRmessage.get()
                + "\nAtomic Reference of Person is " + aRperson.get().toString());
    }
}

//Message is: hello
//Person is [name Phillip, age 23]
//Atomic Reference of Message is: hello
//Atomic Reference of Person is [name Phillip, age 23]
//
//Thread-1 Values: hello-Thread 2-Thread 1! - [name Thread 1, age 26]
//
//Thread-0 Values hello-Thread 2-Thread 1! - [name Thread 1, age 26]
//
//Thread-1 Atomic References: Thread 2 - [name Thread 1, age 1]
//
//Thread-0 Atomic References hello-Thread 2-Thread 1! - [name Thread 1, age 26]
//
//Now Message is: hello-Thread 2-Thread 1!
//Person is [name Thread 1, age 26]
//Atomic Reference of Message is: Thread 2
//Atomic Reference of Person is [name Thread 1, age 1]


