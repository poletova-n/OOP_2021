package lab2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Matrix test = new Matrix("src/main/java/lab2/files/matrixSize");
        test.printMatrix();
        System.out.println("\n");
        for (int i = 0; i < 3; i++) {
            test.rotateMatrix();
            test.divideElements();
            test.printMatrix();
            System.out.println("\n");
        }
        test.printFile("src/main/java/lab2/files/matrixOut.txt");
    }
}
