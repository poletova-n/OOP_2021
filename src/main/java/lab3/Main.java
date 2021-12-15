package lab3;

import lab3.classes.Animals;
import lab3.classes.Chorda;
import lab3.classes.Mammals;
import lab3.classes.Weasels;
import lab3.exceptions.QueueOverflow;
import lab3.exceptions.QueueUnderflow;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Animals animal = new Weasels("me", "small", "weasel");
        Animals animal1 = new Animals("animal");
        Animals chorda = new Chorda("chorda");
        try {
            Queue<Animals> queue = new Queue<Animals>( 2);
            queue.add(animal);
            queue.add(animal1);
            ArrayList<Animals> upperBound = Functional.upperBound();
            ArrayList<Animals> lowerBound = Functional.lowerBound();
            System.out.println("UPPER");
            for (int i = 0; i < upperBound.size(); i++) {
                System.out.println(upperBound.get(i));
            }
            System.out.println("LOWER");
            for (int i = 0; i < lowerBound.size(); i++) {
                System.out.println(lowerBound.get(i));
            }
        }catch (QueueOverflow | QueueUnderflow e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
