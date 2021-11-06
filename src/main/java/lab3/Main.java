import animal.hierarchy.*;

import java.lang.reflect.InvocationTargetException;

/**
 The full class hierarchy is located in the same directory as the lab
 Animal Hierarchy.uml
 */

public class Main {
    public static void main(String[] args) {
        try {
            Functions functions = new Functions();
            Queue<Animal> animalQueue = Functions.produce(Animal.class);
            System.out.println("\nFull Animal hierarchy: " + animalQueue);
            Queue<Animal> upperBoundedQueue = Functions.produce(Tailless.class);
            System.out.println("Queue with Tailless as upper bound: " + upperBoundedQueue);
            Queue<Animal> resultingBoundedQueue = Functions.consume(upperBoundedQueue, Frog.class);
            System.out.println("Queue with Tailless as upper bound and Frog as lower bound: " + resultingBoundedQueue);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
