package lab2;

import lab2.utilities.*;

public class Main {

    public static final String  INPUT_FILE = "X:/Java projects/LAB 2/src/lab2/files/input.txt";
    public static final String  OUTPUT_FILE = "X:/Java projects/LAB 2/src/lab2/files/output.txt";

    public static void main(String[] args) {

        try {

            MatrixSizeReader sizeReader = new MatrixSizeReader(INPUT_FILE);
            Matrix mtx = new Matrix(sizeReader.readSize());
            mtx.printMatrixToFile(OUTPUT_FILE);

        }catch (OutOfMemoryError error){
            error.printStackTrace();
        }

    }
}
