package lab2;

import lab2.exceptions.DivideZero;
import lab2.exceptions.EmptyFile;
import lab2.exceptions.IllegalValue;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static final String OUTPUT_FILE_NAME = "/Users/evgenijsmirnov/IdeaProjects/OOP_2021/src/main/java/lab2/files/output.txt";
    public static final String INPUT_FILE_NAME = "/Users/evgenijsmirnov/IdeaProjects/OOP_2021/src/main/java/lab2/files/input.txt";

    public static void main(String[] args) throws Exception {
        try {
            int N = 0;
            double[][] matrix = null;
            N = readFromFile();
            matrix = initMatrixRandom(N);
            matrix = mergeNeighbors(matrix);
            writeToFile(matrix);
        } catch (OutOfMemoryError | DivideZero | EmptyFile | IllegalValue | UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
    }

    public static double[][] initMatrixRandom(int N) {

        double[][] matrix = null;
        try {
            matrix = new double[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = (int) (Math.random() * (2 * N + 1)) - N;
                }
            }

        } catch (OutOfMemoryError e) {
            System.out.println(e.getMessage());
            return null;
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

                // углы
                if (i == 0 && j == 0) {
                    sum = matrix[i][j + 1] + matrix[i + 1][j];
                } else if (i == 0 && j == N - 1) {
                    sum = matrix[i][j - 1] + matrix[i + 1][j];
                } else if (i == N - 1 && j == 0) {
                    sum = matrix[i - 1][j] + matrix[i][j + 1];
                } else if (i == N - 1 && j == N - 1) {
                    sum = matrix[i][j - 1] + matrix[i - 1][j];
                }

                // края
                else if (i == 0 && j > 0 && j < N - 1) {
                    sum = matrix[i][j - 1] + matrix[i + 1][j] + matrix[i][j + 1];
                } else if (i == N - 1 && j > 0 && j < N - 1) {
                    sum = matrix[i][j - 1] + matrix[i - 1][j] + matrix[i][j + 1];
                } else if (j == 0 && i > 0 && i < N - 1) {
                    sum = matrix[i - 1][j] + matrix[i][j + 1] + matrix[i + 1][j];
                } else if (j == N - 1 && i > 0 && i < N - 1) {
                    sum = matrix[i - 1][j] + matrix[i][j - 1] + matrix[i + 1][j];

                    // внутренние точки
                } else {
                    sum = matrix[i][j + 1] + matrix[i][j - 1] + matrix[i + 1][j] + matrix[i - 1][j];
                }
                if (sum != 0.0000000000)
                    result[i][j] = (double) Math.round((matrix[i][j] / sum) * 100) / 100;
                else
                    throw new DivideZero("В матрице во время операции один из делителей= '" + sum + "' == 0.");
            }
        }

        return result;
    }

    public static double[][] rotate90Degrees(double[][] matrix) {

        int N = matrix.length;
        try {
            double[][] result = new double[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    result[i][j] = matrix[N - j - 1][i];
                }
            }
            return result;
        } catch (OutOfMemoryError e) {
            throw new OutOfMemoryError("Невозможно продолжить вычисление, так как не хватило памяти.");
        }
    }

    public static int readFromFile() throws EmptyFile, IllegalValue {
        int N = -1;
        try (FileInputStream reader = new FileInputStream(INPUT_FILE_NAME)) {

            if (reader.available() == 0)
                throw new EmptyFile("File: " + INPUT_FILE_NAME + " is empty!");

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

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return N;
    }

    public static void writeToFile(double[][] matrix) {

        try (FileOutputStream writer = new FileOutputStream(OUTPUT_FILE_NAME)) {
            writing(rotate90Degrees(matrix), writer);
            writing(rotate90Degrees(rotate90Degrees(matrix)), writer);
            writing(rotate90Degrees(rotate90Degrees(rotate90Degrees(matrix))), writer);
        } catch (Exception e) {
            throw new UnsupportedOperationException("Неизвестная ошибка. Запись не удалась.");
        }
    }

    public static void writing(double[][] matrix, FileOutputStream writer) throws Exception {
        // перевод в байты
        for (double[] i : matrix) {
            byte[] buffer = Arrays.toString(i).getBytes();

            writer.write(buffer, 0, buffer.length);
            writer.write("\n".getBytes(), 0, "\n".getBytes().length);
        }

        writer.write("\n".getBytes(), 0, "\n".getBytes().length);
        writer.write("\n".getBytes(), 0, "\n".getBytes().length);
    }
}