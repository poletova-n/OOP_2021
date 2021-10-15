package lab3;

import lab3.Animal.*;

public class Main {
    public static void main(String[] args) {
        GenericLinkedQueue<Chordate> task = new GenericLinkedQueue<>();
        String prefix = "lab3.Animal.";
        try {
            System.out.println("\nTask #1:");
            GenericLinkedQueue<?> task1 = task.produce(Class.forName(prefix + "Primates"));

            System.out.println("\nTask #2:");
            GenericLinkedQueue<?> task2 = task1.consume();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
