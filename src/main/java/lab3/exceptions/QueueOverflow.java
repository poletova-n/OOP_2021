package lab3.exceptions;

public class QueueOverflow extends RuntimeException{
    public QueueOverflow(String message){
        super(message);
    }
}
