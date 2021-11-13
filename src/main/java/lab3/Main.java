package lab3;

public class Main {
    public static void main(String[] args) {

        try {
            Queue Box= Queue.produce(98);
                    Box.printQueue();
                    Queue.consume(Box);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

}
