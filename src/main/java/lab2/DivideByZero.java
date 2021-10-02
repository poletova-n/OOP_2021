package lab2;

public class DivideByZero extends Exception {
    private int number;
    public int getNumber() {return number;}
    public DivideByZero(String message, int num) {
        super(message);
        number = num;
    }
}

