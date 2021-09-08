package lab2.exceptions;

import java.io.FileNotFoundException;

public class MyFileNotFoundException extends FileNotFoundException {
    public MyFileNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
