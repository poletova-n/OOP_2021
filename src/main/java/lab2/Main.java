package Lab2;
import Lab2.exceptions.DivisionByZeroException;
import Lab2.exceptions.FileNotExistException;
import Lab2.exceptions.OverflowException;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            File file = new File("input.txt");
            FileReader input = new FileReader(file);
            Scanner reader = new Scanner(input);
            int size = reader.nextInt();

            Matrix matrix = new Matrix(size);
            matrix.fillMatrix();
            matrix.dividingElementsOfMatrix();

            File outputFile = new File("output.txt");
            FileWriter output;
            output = new FileWriter(outputFile);
            outputInFile(matrix, output);

            matrix.rotateNinetyDegree();
            outputInFile(matrix, output);

            matrix.rotateOneHundredEightyDegree();
            outputInFile(matrix, output);

            matrix.rotateTwoHundredSeventyDegree();
            outputInFile(matrix, output);
            output.close();
        } catch (FileNotExistException | FileNotFoundException e) {
            throw new FileNotExistException("File not exist!");
        } catch (DivisionByZeroException | IOException | OverflowException e) {
            e.printStackTrace();
        }
    }
    public static void outputInFile(Matrix matrix, FileWriter output) throws IOException {
        for (int i = 0; i < 1; i++) {
            output.write(matrix.toString());
        }
        output.write("\n");
    }
}
