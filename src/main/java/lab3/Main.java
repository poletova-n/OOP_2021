package lab3;


import lab3.exceptions.QueueOverFlow;
import lab3.exceptions.QueueUnderFlow;

public class Main {
    public static void main(String[] args) {
       try {
          Functions.consume(Functions.produce());
       }
       catch (QueueUnderFlow | QueueOverFlow e){
           System.out.println(e.getMessage());
       }
    }
}
