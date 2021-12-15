package lab2.Exceptions;

public class WrongValueException extends RuntimeException{
    public WrongValueException(String message){
        super(message);
    }
}
