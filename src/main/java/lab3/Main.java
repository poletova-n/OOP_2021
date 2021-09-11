package lab3;

import lab3.exceptions.NotEnoughCapacity;
import lab3.exceptions.OutOfCapacity;

public class Main {
    public static void main(String[] args) throws OutOfCapacity, NotEnoughCapacity {
       Functions.consume(Functions.produce());
    }
}
