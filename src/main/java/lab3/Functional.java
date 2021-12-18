package lab3;

import lab3.classes.*;
import lab3.exceptions.QueueOverflow;
import lab3.exceptions.QueueUnderflow;

import java.util.ArrayList;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

public class Functional {
    public static Queue<? extends Animals> produce() throws QueueUnderflow ,QueueOverflow {
        Queue<? extends Animals> queue = new Queue<>(20, Animals.class);
        queue.add(new Animals("Animal"));
        queue.add(new Chorda("Chorda"));
        queue.add(new Mammals("Mammals"));
        queue.add(new Predators("Predators"));
        queue.add(new Mustelidae("Mustelidae", "small"));
        queue.add(new WeaselsAndFerrets("WeaselsAndFerrets", "small"));
        queue.add(new Weasels("Weasel","small" ,"weasel"));
        queue.add(new Ferret("Ferret", "small", "ferret"));
        return queue;
    }
    public static void consume(Queue<? extends Animals> queue, Class<?> superClass) throws QueueUnderflow, QueueOverflow {
        Queue<? extends Animals> queueLow = new Queue<>(20, Animals.class);
        List<Type> types = getListOfSuperClasses(superClass);
        //System.out.println(queue.get().getClass());
        //System.out.println(queue.isEmty());
        while (!queue.isEmty()) {
            //System.out.println(queue.pick());
            if (types.contains(queue.pick().getClass())) {
                //System.out.println("Added");
                queueLow.add(queue.get());
            } else {
                //System.out.println("Not our case");
                queue.get();
            }
        }
        System.out.println("Lower bound queue:\n" + queueLow);
    }

    private static List<Type> getListOfSuperClasses(Class<?> superClass) {
        List<Type> types = new LinkedList<>();

        Class<?> sup = superClass;
        types.add(sup);
        while(!sup.equals(Object.class)){
            types.add(sup.getGenericSuperclass());
            sup = (Class<?>) sup.getGenericSuperclass();
            System.out.println(sup);
        }
        return types;
    }
}
