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

            Queue<?> task1 = (new Queue<Animals>()).produce(Class.forName("lab3.classes.Animals"));
            Queue<?> task2 = task1.consume();

        }catch (QueueOverflow | QueueUnderflow e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
