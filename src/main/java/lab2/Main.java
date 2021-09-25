package lab2;

import lab2.exceptions.*;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws FileNotFound, InvalidSize {

        Matrix matrix = new Matrix("test.txt");
        //System.out.println(Arrays.deepToString(matrix.array).replace("], ", "]\n"));

        for (int i = 0; i < 3; i++) {
            matrix.rotate90Degrees();
            matrix.divideElem();
            matrix.printToFile("out.txt");
        }
    }
}
