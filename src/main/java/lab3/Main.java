package lab3;

public class Main {
    public static void main(String[] args) {

        try {
            Queue Box= Queue.produce(20);
                    Box.printQueue();
                    Queue.consume(Box);
            //Box.add(new PolarBear());
            //Box.add(new BabyPolarBear());
            //Box.printQueue();

        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

}
