package Lab2.exceptions;

public class FileNotExistException extends RuntimeException {
    public FileNotExistException(String message) {
        super(message);
    }
}
