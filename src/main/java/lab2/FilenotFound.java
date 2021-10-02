package lab2;

import java.io.IOException;

public class FilenotFound extends Exception{
    private int number;
    public int getNumber() {return number;}
    public FilenotFound(String message, int num) {
        super(message);
        number = num;
    }
}
