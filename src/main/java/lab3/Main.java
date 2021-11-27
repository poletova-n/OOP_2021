package lab3;
import lab3.animals.*;

public class Main {
    public static void main(String[] args) {
        Queue<Chordate> task = new Queue<>();
        String prefix = "lab3.animals.";
        try {
            System.out.println("\nTask #1:");
            Queue<?> task1 = task.produce(Class.forName(prefix + "Chordate"));

            System.out.println("\nTask #2:");
            Queue<?> task2 = task1.consume();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
