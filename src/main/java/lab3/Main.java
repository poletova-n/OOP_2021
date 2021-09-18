package lab3;


public class Main {
    public static void main(String[] args) {
       try {
          Functions.consume(Functions.produce());
       }
       catch (QueueUnderFlow e){
           System.out.println(e.getMessage());
       }
    }
}
