package lab3;

import lab3.classes.*;
import lab3.exceptions.QueueOverflow;
import lab3.exceptions.QueueUnderflow;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Animals animal = new Weasels("me", "small", "weasel");
        Animals animal1 = new Animals("animal");
        Animals chorda = new Chorda("chorda");
        try {
            Queue<? extends Animals> queue = Functional.produce();
            System.out.println("Upper bound queue:\n" + queue + "\n");
            System.out.println("Enter Animal - a parent for lower bound queue from a list.");

            Scanner sc = new Scanner(System.in);
            String classString = null;
            if (sc.hasNext())
                classString = sc.nextLine();
            //System.out.println(classString);
            if (Objects.equals(classString, "1"))
                Functional.consume(queue, Ferret.class);
            else if(Objects.equals(classString, "2"))
                Functional.consume(queue, Mammals.class);
            else if(Objects.equals(classString, "3"))
                Functional.consume(queue, Mustelidae.class);
            else if(Objects.equals(classString, "4"))
                Functional.consume(queue, Weasels.class);
            else if(Objects.equals(classString, "5"))
                Functional.consume(queue, Animals.class);

        }catch (QueueOverflow | QueueUnderflow e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
