package lab2.exceptions;
import java.io.FileNotFoundException;

public class FileNotFound extends FileNotFoundException {
    public FileNotFound(String message)
    {
        super(message);
    }
}