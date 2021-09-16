package lab3;


import lab3.fauna.Chordate;
import lab3.fauna.Diprotodontia;
import lab3.fauna.Macropodidae;
import lab3.fauna.Mammalia;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Queue q1 = new Queue(Macropodidae.class , 30);

        System.out.println("produce queue containing random members of class Mammalia");
        Queue q2 = q1.produce(new Mammalia().getClass());

        System.out.println("\n Consume queue with dividing line in class Diprotodontia");
        Queue q3 = q2.consume(new Diprotodontia().getClass());


    }
}
