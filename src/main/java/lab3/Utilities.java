package lab3;

import lab3.AnimalsHierarchy.*;
import lab3.exceptions.*;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Utilities {

    public static int SIZE = 7;

    public static Queue<? extends Animal> produce() throws QueueOverflow {

        Queue<? extends Animal> queue = new Queue<>(SIZE, Animal.class );

        Animal[] animals = new Animal[SIZE];
        animals[0]  = new Smelt();
        animals[1]  = new Zebra();
        animals[2]  = new Giraffe();
        animals[3]  = new SalmonOfWisdom();
        animals[4]  = new GoldenKoi();
        animals[5]  = new Antilopa();
        animals[6]  = new Lion();

        for (int i = 0; i < SIZE; i++){
//            queue.add(animals[(int) (Math.random() * SIZE)]);
            queue.add(animals[i]);
        }

        return queue;
    }

    public static void consume(Queue<? extends Animal> queue, Class<?> superClass) throws QueueUnderflow, QueueOverflow {

        Queue<? super Animal> queueLow = new Queue<>(SIZE, Animal.class);
        List<Type> types = getListOfSuperClasses(superClass);

        System.out.println(types);

    }

//    public static void consume(Queue<? extends Animal> queue, Class<?> superClass) throws QueueUnderflow, QueueOverflow {
//
//        Queue<? super Animal> queueLow = new Queue<>(SIZE, Animal.class);
//        List<Type> types = getListOfSuperClasses(superClass);
//        System.out.println(types);
//        while (!queue.isEmpty())
//            if(types.contains(queue.get().getClass()))
//                queueLow.add(queue.pop());
//            else
//                queue.pop();
//
//        System.out.println("Lower bound queue:\n" + queueLow);
//
//    }

    public static void selectClass() throws QueueOverflow, QueueUnderflow {

        Queue<? extends Animal> queue = produce();
        System.out.println("Upper bound queue:\n" + queue + "\n");
        System.out.println("Enter Animal's class name - a parent class for lower bound queue from a list.");

        Scanner sc = new Scanner(System.in);
        String className = null;

        if (sc.hasNext()) {
            className = sc.nextLine();
        }

        switch (className) {
            case "GoldenKoi"         -> consume(queue, GoldenKoi.class);
            case "Lion"         -> consume(queue, Lion.class);
            case "Antilopa"      -> consume(queue, Antilopa.class);
            case "Zebra"          -> consume(queue, Zebra.class);
            case "Giraffe"        -> consume(queue, Giraffe.class);
            case "SalmonOfWisdom" -> consume(queue, SalmonOfWisdom.class);
            case "Smelt"          -> consume(queue, Smelt.class);
            default               -> System.out.println("Unknown class name!");
        }
    }

    private static List<Type> getListOfSuperClasses(Class<?> superClass) {

        List<Type> types = new LinkedList<>();

        Class<?> superc = superClass;
        types.add(superc);

        while(!superc.equals(Object.class)){

            types.add(superc.getGenericSuperclass());
            superc = (Class<?>) superc.getGenericSuperclass();
        }

        types.remove(types.size()-1);

        return types;
    }
}