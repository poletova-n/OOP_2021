package lab3;

import lab3.Exceptions.*;
import lab3.Animals.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws QueueOverFlow, QueueUnderFlow {

        try {
            Queue.selectClass();
        }
        catch (QueueUnderFlow | QueueOverFlow | ClassCastException e){
            System.out.println(e.getMessage());
        }
//            Queue<? extends Chordal> queue = new Queue<>(7, Chordal.class);
//            queue = queue.produce();
//            Queue q1 = new Queue(30, Chordal.class);
//            System.out.println("produce queue containing random members of class Mammalia");
//            Queue q2 = q1.produce(new Hares().getClass());
//
//            Queue q3 = q2.consume(new Mammals().getClass());

//
//            System.out.println("Upper bound queue:\n" + queue + "\n");
//
//            System.out.println("Enter Animal - a parent for lower bound queue from a list.");
//
//            Scanner sc = new Scanner(System.in);
//            String classString = null;
//            if (sc.hasNext())
//                classString = sc.nextLine();

//            switch (classString) {
//                case "Chordal" -> queue.consume(queue, Chordal.class);
//                case "Hares" -> queue.consume(queue, Hares.class);
//                case "Insectivores" -> queue.consume(queue, Insectivores.class);
//                case "Rodents" -> queue.consume(queue, Rodents.class);
//                case "Brown Hare" -> queue.consume(queue, BrownHare.class);
//                case "White Hares" -> queue.consume(queue, WhiteHare.class);
//                case "Mammals" -> queue.consume(queue, Mammals.class);
//                default -> System.out.println("Don't have this class of animal");
//            }

    }
}
