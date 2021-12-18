package lab3;
import lab3.classification.*;

public class Main {
    public static void main(String[] args) {
        Queue<Chordata> task = new Queue<>();
        String prefix = "lab3.classification.";
        try {
            System.out.println("\nTask #1:");
            Queue<?> task1 = task.produce(Class.forName(prefix + "Chordata"));

            System.out.println("\nTask #2:");
            Queue<?> task2 = task1.consume();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}