package lab3;

import lab3.exceptions.NotEnoughCapacity;
import lab3.exceptions.OutOfCapacity;

public class Main {
    public static void main(String[] args) {
       try {
           Functions.consume(Functions.produce());
       }
       catch (NotEnoughCapacity | OutOfCapacity e){
           System.out.println(e.getMessage());
       }
    }
}
