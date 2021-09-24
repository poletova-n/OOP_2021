package lab2;

import lombok.Getter;

public class Matrices {
    @Getter
    private final int size;
    @Getter
    private final double[][] matrix;

    Matrices(int size) {
        this.size = size;
        matrix = new double[size][size];
    }

    public void fillMatrix() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = Math.random()*(2*size) - size;
            }
        }
    }

    public Matrices getRotatedMatrix() {
        Matrices temp = new Matrices(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                temp.matrix[i][j] = this.matrix[j][size - 1 - i];
            }
        }
        return temp;
    }

    public void modifyValues() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == size-1 && j == size-1) {
                    matrix[i][j] = matrix[i][j] / (matrix[i-1][j] + matrix[i][j-1]);
                }
                else if (i == size-1) {
                    matrix[i][j] = matrix[i][j] / (matrix[i-1][j] + matrix[i][j+1]);
                }
                else if (j == size-1) {
                    matrix[i][j] = matrix[i][j] / (matrix[i][j-1] + matrix[i+1][j]);
                }
                else {
                    matrix[i][j] = matrix[i][j] / (matrix[i+1][j] + matrix[i][j+1]);
                }
            }
        }
    }

    public void printMatrix() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] >= 0) {
                    System.out.print(" ");
                }
                if (matrix[i][j] < 10 || matrix[i][j] > -10) {
                    System.out.print(" ");
                }
                System.out.printf("%.2f", matrix[i][j]);
                if (j != size-1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
