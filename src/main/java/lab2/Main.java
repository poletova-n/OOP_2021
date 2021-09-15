package lab2;

import lab2.exceptions.DivideZero;
import lab2.exceptions.EmptyFile;
import lab2.exceptions.FileIsNotExist;
import lab2.exceptions.IllegalValue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static final String OUTPUT_FILE_NAME = "/Users/evgenijsmirnov/IdeaProjects/OOP_2021/src/main/java/lab2/files/output.txt";
    public static final String INPUT_FILE_NAME = "/Users/evgenijsmirnov/IdeaProjects/OOP_2021/src/main/java/lab2/files/input.txt";

    public static void main(String[] args) {
        try {
            int N = 0;
            double[][] matrix = null;
            N = readFromFile(INPUT_FILE_NAME);
            matrix = initMatrixRandom(N);
            matrix = mergeNeighbors(matrix);
            writeToFile(matrix);
        } catch (DivideZero | EmptyFile | IllegalValue | FileIsNotExist  e) {
            System.out.println(e.getMessage());
        }
    }

    public static double[][] initMatrixRandom(int N) {
        double[][] matrix = null;
        matrix = new double[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = (int) (Math.random() * (2 * N + 1)) - N;
            }
        }
        return matrix;
    }
    public static double[][] mergeNeighbors(double[][] matrix) throws DivideZero {
        int N = matrix.length;
        double[][] result = new double[N][N];

        double sum = 0;
        if (N == 1) {
            result[0][0] = matrix[0][0];
            return result;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (i == 0 && j == 0) {
                    sum = matrix[i][j + 1] + matrix[i + 1][j];
                } else if (i == 0 && j == N - 1) {
                    sum = matrix[i][j - 1] + matrix[i + 1][j];
                } else if (i == N - 1 && j == 0) {
                    sum = matrix[i - 1][j] + matrix[i][j + 1];
                } else if (i == N - 1 && j == N - 1) {
                    sum = matrix[i][j - 1] + matrix[i - 1][j];
                } else if (i == 0 && j > 0 && j < N - 1) {
                    sum = matrix[i][j - 1] + matrix[i + 1][j] + matrix[i][j + 1];
                } else if (i == N - 1 && j > 0 && j < N - 1) {
                    sum = matrix[i][j - 1] + matrix[i - 1][j] + matrix[i][j + 1];
                } else if (j == 0 && i > 0 && i < N - 1) {
                    sum = matrix[i - 1][j] + matrix[i][j + 1] + matrix[i + 1][j];
                } else if (j == N - 1 && i > 0 && i < N - 1) {
                    sum = matrix[i - 1][j] + matrix[i][j - 1] + matrix[i + 1][j];

                } else {
                    sum = matrix[i][j + 1] + matrix[i][j - 1] + matrix[i + 1][j] + matrix[i - 1][j];
                }
                if (sum != 0.0000000000)
                    result[i][j] = (double) Math.round((matrix[i][j] / sum) * 100) / 100;
                else
                    throw new DivideZero("In matrix one divider is equal '0'.");
            }
        }
        return result;
    }
    public static double[][] rotate90Degrees(double[][] matrix) {
        int N = matrix.length;
        double[][] result = new double[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result[i][j] = matrix[N - j - 1][i];
            }
        }
        return result;
    }

    public static int readFromFile(String FileName) throws EmptyFile, IllegalValue, FileIsNotExist {
        File file = new File(FileName);
        if (!file.exists())
            throw new FileIsNotExist("Input file not found!");

        try (FileInputStream reader = new FileInputStream(FileName)) {
            int N = -1;
            if (reader.available() == 0)
                throw new EmptyFile("File: " + FileName + " is empty!");

            byte[] buffer = new byte[reader.available()];
            reader.read(buffer, 0, reader.available());
            for (byte b : buffer)
                if (b < '0' || b > '9')
                    throw new IllegalValue("Impossible number. '" + (char) b + "' is not a digit");

            N = Integer.parseInt(new String(buffer));

            if (N > 1_000_000)
                throw new IllegalValue("It is too big decimal!");

            if (N <= 0)
                throw new IllegalValue("It is too small decimal!");

            return N;

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }
    public static void writeToFile(double[][] matrix) throws FileIsNotExist {

        File file = new File(INPUT_FILE_NAME);
        if (!file.exists())
            throw new FileIsNotExist("Output file not found!");
        try (FileOutputStream writer = new FileOutputStream(OUTPUT_FILE_NAME)) {

            writing(rotate90Degrees(matrix), writer);
            writing(rotate90Degrees(rotate90Degrees(matrix)), writer);
            writing(rotate90Degrees(rotate90Degrees(rotate90Degrees(matrix))), writer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void writing(double[][] matrix, FileOutputStream writer) throws Exception {
        for (double[] i : matrix) {
            byte[] buffer = Arrays.toString(i).getBytes();

            writer.write(buffer, 0, buffer.length);
            writer.write("\n".getBytes(), 0, "\n".getBytes().length);
        }

        writer.write("\n".getBytes(), 0, "\n".getBytes().length);
        writer.write("\n".getBytes(), 0, "\n".getBytes().length);
    }
}