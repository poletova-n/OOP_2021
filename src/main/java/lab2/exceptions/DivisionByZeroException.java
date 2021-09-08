package lab2.exceptions;

public class DivisionByZeroException extends ArithmeticException{
    public DivisionByZeroException(String errorMessage) {
        super(errorMessage);
    }
}
