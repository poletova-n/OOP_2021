package lab3;

import lab3.AnimalsHierarchy.*;
import lab3.exceptions.*;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Utilities {

    public static int SIZE = 13;

    public static Queue<? extends Animal> produce() throws QueueOverflow {

        Queue<? extends Animal> queue = new Queue<>(SIZE, Animal.class );

        Animal[] animals = new Animal[SIZE];
        animals[0]  = new Smelt("smelt");
        animals[1]  = new Animal("animal");
        animals[2]  = new Mammal("mammal");
        animals[3]  = new Herbivore("herbivore");
        animals[4]  = new Artiodactyla("artiodactyla");
        animals[5]  = new Striped("striped");
        animals[6]  = new Zebra("zebra");
        animals[7]  = new Giraffe("giraffe");
        animals[8]  = new Fish("fish");
        animals[9]  = new Salmon("salmon");
        animals[10] = new Osmeridae("osmeridae");
        animals[11] = new Scaly("scaly");
        animals[12] = new SalmonOfWisdom("salmonofwisdom");

        for (int i = 0; i < SIZE; i++){
            queue.add(animals[(int) (Math.random() * SIZE)]);
        }

        return queue;
    }

    public static void consume(Queue<? extends Animal> queue, Class<?> superClass) throws QueueUnderflow, QueueOverflow {

        Queue<? extends Animal> queueLow = new Queue<>(SIZE, Animal.class);
        List<Type> types = getListOfSuperClasses(superClass);

        while (!queue.isEmpty())
            if(types.contains(queue.get().getClass()))
                queueLow.add(queue.pop());
            else
                queue.pop();

        System.out.println("Lower bound queue:\n" + queueLow);

    }

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
            case "Animal"         -> consume(queue, Animal.class);
            case "Mammal"         -> consume(queue, Mammal.class);
            case "Herbivore"      -> consume(queue, Herbivore.class);
            case "Artiodactyla"   -> consume(queue, Artiodactyla.class);
            case "Striped"        -> consume(queue, Striped.class);
            case "Zebra"          -> consume(queue, Zebra.class);
            case "Giraffe"        -> consume(queue, Giraffe.class);
            case "Fish"           -> consume(queue, Fish.class);
            case "Salmon"         -> consume(queue, Salmon.class);
            case "Osmeridae"      -> consume(queue, Osmeridae.class);
            case "Scaly"          -> consume(queue, Scaly.class);
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

        return types;
    }
}