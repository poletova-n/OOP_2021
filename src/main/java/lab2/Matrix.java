package lab2;

import lab2.Exceptions.DivideZeroException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Matrix {
    private double[][] matrix;

    public Matrix(int size) {
        matrix = new double[size][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new double[size];
        }
        fillRandom();
    }

    private void fillRandom() {
        for (int i = 0; i < matrix.length; i++) {
            for (int ii = 0; ii < matrix.length; ii++) {
                matrix[i][ii] = ((double) (int) (((((double) ((int) (Math.random() * 10_000))) / 100) % matrix.length) * 10_000)) / 10_000;
                if (Math.random() % 2 > 0.5) {
                    matrix[i][ii] = -matrix[i][ii];
                }
            }
        }
    }

    public void fillCounting() {
        for (int i = 0; i < matrix.length; i++) {
            for (int ii = 0; ii < matrix.length; ii++) {
                matrix[i][ii] = ii + i * matrix.length;
            }
        }
    }

    public void printMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int i1 = 0; i1 < matrix[i].length; i1++) {
                System.out.print(matrix[i][i1]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private void rotate90degrees() {
        double[][] resultMatrix = new double[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            resultMatrix[i] = new double[matrix.length];
            for (int j = 0; j < matrix.length; j++) {
                resultMatrix[i][j] = matrix[j][matrix.length - i - 1];
                double dividing = getNeighbourSum(j, matrix.length - i - 1);
                try {
                    if (dividing == 0) {
                        throw new DivideZeroException("Try divide on zero");
                    }
                    resultMatrix[i][j] /= dividing;
                }catch (DivideZeroException e){
                    resultMatrix[i][j] = Double.POSITIVE_INFINITY;
                }
            }
        }
        matrix = Arrays.copyOf(resultMatrix, matrix.length);
    }

    public void rotate(int degrees) throws DivideZeroException {
        for (int i = 0; i < (degrees % 360) / 90; i++) {
            rotate90degrees();
        }
    }

    private double getNeighbourSum(int row, int colon) {
        double sum = 0;
        if (row - 1 >= 0) {
            sum += matrix[row - 1][colon];
        }
        if (row + 1 < matrix.length) {
            sum += matrix[row + 1][colon];
        }
        if (colon - 1 >= 0) {
            sum += matrix[row][colon - 1];
        }
        if (colon + 1 < matrix.length) {
            sum += matrix[row][colon + 1];
        }
        return sum;
    }

    public double[][] getMatrix() {
        return Arrays.copyOf(matrix, matrix.length);
    }

    public void writeIntoFile(FileWriter file) throws IOException {
        String matrixString = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int ii = 0; ii < matrix.length; ii++) {
                matrixString += String.valueOf(matrix[i][ii]) + " ";
            }
            matrixString += "\n";
        }
        file.write(matrixString);
    }
}
