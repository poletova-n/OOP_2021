package lab3;

import lab3.exceptions.*;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("-----------------------------------------------\nStart queue :");
            Queue Box= Queue.produce(10);
            Box.printQueue();
            System.out.println("-----------------------------------------------");
            Queue.consume(Box);
            System.out.println("-----------------------------------------------\nEnd of program");

        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}