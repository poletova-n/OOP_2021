package lab3.exceptions;

public class QueueUnderflow extends RuntimeException{
    public QueueUnderflow(String message){
        super(message);
    }
}
