package lab2;

public class LargeMatrix extends Exception{
    private int number;
    public int getNumber() {return number;}
    public LargeMatrix(String message, int num) {
        super(message);
        number = num;
    }
}
