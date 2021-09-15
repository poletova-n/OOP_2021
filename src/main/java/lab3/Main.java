package lab3;

import lab3.exceptions.QueueOverFlow;
import lab3.exceptions.QueueUnderFlow;

public class Main {
    public static void main(String[] args) {
       try {
           Functions.consume(Functions.produce());
       }
       catch (QueueOverFlow | QueueUnderFlow e){
           System.out.println(e.getMessage());
       }
    }
}
