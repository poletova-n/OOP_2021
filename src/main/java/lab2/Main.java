package lab2;

import lab2.exceptions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotExist, FileNotFoundException, WrongSize {

       try (Scanner in = new Scanner(new File("src/main/java/lab2/size.txt"))) {
            int n = in.nextInt();

            Matrix matrix = new Matrix("src/main/java/lab2/size.txt");

            try (FileWriter writer = new FileWriter("src/main/java/lab2/out.txt", false)) {

                writer.write("Matrix\n");

                for (int i = 0; i <n; i++) {
                    for (int j = 0; j < n; j++) {
                        writer.write(String.format("%.1f", matrix.getMatrix()[i][j]));
                        writer.write(" ");
                    }
                    writer.append('\n');
                }

                matrix.turn90();

                writer.append('\n');

                for (int i = 0; i <n; i++) {
                    for (int j = 0; j < n; j++) {
                        writer.write(String.format("%.1f", matrix.getMatrix()[i][j]));
                        writer.write(" ");
                    }
                    writer.append('\n');
                }

                matrix.action90();

                writer.append('\n');

                for (int i = 0; i <n; i++) {
                    for (int j = 0; j < n; j++) {
                        writer.write(String.format("%.1f", matrix.getMatrix()[i][j]));
                        writer.write(" ");
                    }
                    writer.append('\n');
                }

                matrix.action90();

                writer.append('\n');

                for (int i = 0; i <n; i++) {
                    for (int j = 0; j < n; j++) {
                        writer.write(String.format("%.1f", matrix.getMatrix()[i][j]));
                        writer.write(" ");
                    }
                    writer.append('\n');
                }
            }
        }
        catch (IOException ex  ) {

            System.out.println(ex.getMessage());
        }
    }
}
